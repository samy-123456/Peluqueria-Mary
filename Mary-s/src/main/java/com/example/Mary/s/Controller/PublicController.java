/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Controller;

/*importamos las librerias que necesitamos manejamos tambien la sesion iniciada y encriptador de contraseña */
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Mary.s.Model.Certificados;
import com.example.Mary.s.Model.Citas;
import com.example.Mary.s.Model.Credenciales;
import com.example.Mary.s.Model.Empleados;
import com.example.Mary.s.Model.EstadoCita;
import com.example.Mary.s.Model.Galeria;
import com.example.Mary.s.Model.Servicios;
import com.example.Mary.s.Repository.CategoriaServicioRepository;
import com.example.Mary.s.Repository.CertificadosRepository;
import com.example.Mary.s.Repository.CitasRepository;
import com.example.Mary.s.Repository.ClienteRepository;
import com.example.Mary.s.Repository.CredencialesRepository;
import com.example.Mary.s.Repository.EmpleadoRepository;
import com.example.Mary.s.Repository.GaleriaRepository;
import com.example.Mary.s.Repository.ServicioRepository;

import jakarta.servlet.http.HttpSession;

/*establecemos la clase como un controlador para el usuario */

@Controller
public class PublicController {
    
    /*inyectamos a lso distintos repositorios para poder interactuar con la base de datos */
    /*repositorio de la categoria del servicio */
    @Autowired
    private CategoriaServicioRepository categoriaRepositorio;
    /*repositorio del servicio */
    @Autowired
    private ServicioRepository servicioRepositorio;
    /*repositorio del empleado */
    @Autowired
    private EmpleadoRepository empleadoRepositorio;
    /*repositorio de la citas */
    @Autowired
    private CitasRepository citasRepositorio;
    /*repositorio del cliente */
    @Autowired
    private ClienteRepository clienteRepositorio;
    /*repositorio delas credenciales */
    @Autowired
    private CredencialesRepository credencialesRepositorio;
    /*repositorio de la galeria */
    @Autowired
    private GaleriaRepository galeriaRepositorio;
    /*repositorio de los certificados */
    @Autowired 
    private CertificadosRepository certificadosRepositorio;

    /*herramienta para encriptar contraseñas */
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /*Este metodo lo usaremos con varias paginas para no repetir codigo */
    /*agrega el nombre del usuario y si esta logueado a todas las vistas */
    private void agregarDatosComunes(HttpSession session, Model model){

        /*creamos la sesion del usuario */
        Credenciales usuario = (Credenciales) session.getAttribute("usuarioLoguedo");

        /*comprobamos si el suuario esta logueado */
        if (usuario != null){
            /*guardamos el nombre */
            String nombre ="";
            /*comprobamos si es un cliente*/
            if (usuario.get_cliente() != null){
                nombre = usuario.get_cliente().get_nombre_cliente();
            }
            /*enviamos datos al html */
            model.addAttribute("nombreUsuario", nombre);
            model.addAttribute("estaLogueado", true);
            model.addAttribute("usuarioLogueado", usuario);
        }else{
            /*si ndaie esta logueado */
            model.addAttribute("estaLogueado", false);
        }
    }

    /*Paginas principales */
    @GetMapping("/index")
    public String mostrarIndex(HttpSession session, Model model){

        agregarDatosComunes(session, model);

        /*traemos todo el contenido de la galeria */
        List<Galeria> todoGaleria = galeriaRepositorio.findByActivoTrueOrderByOrdenAsc();

        /*filtramos la galeria para solo mostrar fotos de cortes y videos */
        List<Galeria> contenidoIndex = todoGaleria.stream()
        .filter(item ->{

            String titulo = item.getTitulo().toLowerCase().trim();
            /*mostramos todos los videos */
            if (item.getTipo().equalsIgnoreCase("video")){
                return true;
            }
            /*mostramos solo las fotos que no sean las del local*/
            if (item.getTipo().equalsIgnoreCase("imagen")){
                return !titulo.contains("local");
            }
            return false;
        })
        .collect(Collectors.toList());

        /*enviamos el contenido a la vista del html */
        model.addAttribute("galeriaIndex", contenidoIndex);

        return "index";
    }

    /*detalles del empleado */
    @GetMapping("/detalles_empleado")
    public String detalleEmpleado(@PathVariable Long id,HttpSession session, Model model){

        agregarDatosComunes(session, model);

        Empleados empleado = empleadoRepositorio.findById(id).orElse(null);

        if (empleado == null){
            model.addAttribute("error", "Empleado no encontrado");
            return "redirect:/empleados";
        }

        /*certificaciones de este empleado */
        List<Certificados> certificacionesEmpleado = certificadosRepositorio.findAll().stream()
        .filter(cert -> cert.get_id_empleado() != null &&
                cert .get_id_empleado().get_id_empleado().equals(id))
        .toList();

        /*imagenes de los trabajos del empleado */
        List<Galeria> trabajosEmpleado = galeriaRepositorio.findAll().stream()
        .filter(g -> g.getEmpleado() !=null &&
                g.getEmpleado().get_id_empleado().equals(id) &&
                g.getActivo())
                .toList();

        model.addAttribute("empelado", empleado);
        model.addAttribute("certificaciones", certificacionesEmpleado);
        model.addAttribute("trabajosEmpleado", trabajosEmpleado);

        return"detalles_empleado";
    }

    /*certificaciones de la barberia */
    @GetMapping("/certificados")
    public String mostrarCertificados(HttpSession session, Model model){
        agregarDatosComunes(session, model);

        List<Certificados> certificaciones = certificadosRepositorio.findAll().stream()
        .filter(cert -> cert.get_id_empleado() == null)
        .toList();

        model.addAttribute("certificaciones", certificaciones);
        return "certificados";
    }

    /*otras paginas */

    /*categorias de servicios */
    @GetMapping("/categoria")
    public String mostrarCategorias(HttpSession session, Model model){
        agregarDatosComunes(session, model);
        model.addAttribute("categorias",categoriaRepositorio.findAll());
        return "categoria";
    }

    /*servicios mostramos los datos que tenemos en la base de datos */
    @GetMapping("/servicios")
    public String mostrarServicios(HttpSession session, Model model){
        agregarDatosComunes(session, model);
        model.addAttribute("servicios", servicioRepositorio.findAll());
        return "servicios";
    }

    @GetMapping("/contactanos")
    public String mostrarContactos(HttpSession session, Model model){
        agregarDatosComunes(session, model);
        return "contactanos";
    }

    /*empleados mostramos los detos de la BD */
    @GetMapping("/empleados")
    public String mostrarEmpleados(HttpSession session, Model model){
        agregarDatosComunes(session, model);
        model.addAttribute("empleados", empleadoRepositorio.findAll());
        return "empleados";
    }

    /*=========================== PERFIL ======================= */
    /*perfil del cliente es algo extenso */
    @GetMapping("/perfil")
    public String mostrarPerfil(HttpSession session, Model model){
        Credenciales usuario = (Credenciales) session.getAttribute("usuarioLogueado");
        /*validamos q el usuario este en sesion y el cliente exista */
        if(usuario == null || usuario.get_cliente() == null){
            return "redirect:/login";
        }

        agregarDatosComunes(session, model);
        model.addAttribute("cliente");
        return "perfil";
    }

    @PostMapping("/perfil/cambiar_contraseña")
    public String cambiarContraseña(@RequestParam String contraseña_actual,
                                    @RequestParam String nueva_contraseña,
                                    @RequestParam String confirmar_contraseña,
                                    HttpSession session, Model model){
    
    Credenciales usuario = (Credenciales) session.getAttribute("usuarioLogueado");
    if(usuario == null || usuario.get_cliente() == null){
        return "redirect:/login";
    }

    boolean coincide = passwordEncoder.matches(contraseña_actual, usuario.get_contraseña_usuario());
    if (!coincide){
        model.addAttribute("error", "La contraseña actual es incorrecta");
        model.addAttribute("cliente", usuario.get_cliente());
        return "perfil";
    }

    if(!nueva_contraseña.equals(confirmar_contraseña)){
        model.addAttribute("error", "Las nuevas contraseñas no coinciden");
        model.addAttribute("cliente", usuario.get_cliente());
        return "perfil";
    }

    String nuevaEncriptada = passwordEncoder.encode(nueva_contraseña);
    usuario.set_contraseña_usuario(nuevaEncriptada);
    credencialesRepositorio.save(usuario);

    model.addAttribute("mensaje", "!Contraseña cambiada exitosamente");
    model.addAttribute("cliente", usuario.get_cliente());
    return "perfil";
    }

    /*=============================agendar la cita =======================*/
    /*agendar la cita */
    @GetMapping("/agendar_cita")
    public String mostrarAgendarCita(HttpSession session, Model model){
        Credenciales user = (Credenciales) session.getAttribute("usuarioLogueado");
        if(user == null) return "redirect:/login";

        agregarDatosComunes(session, model);
        model.addAttribute("categorias", categoriaRepositorio.findAll());
        model.addAttribute("servicios", servicioRepositorio.findAll());
        model.addAttribute("empleados", empleadoRepositorio.findAll());
        model.addAttribute("cita", new Citas());
        return "agendar_cita";
    }

    // Procesa el formulario cuando el usuario envía la cita
    @PostMapping("/agendar-cita")
    public String procesarCita(@ModelAttribute Citas nuevaCita,
                               @RequestParam Long id_servicio,
                               @RequestParam Long id_empleado,
                               HttpSession session, Model model) {

        Credenciales usuarioLogueado = (Credenciales) session.getAttribute("usuarioLogueado");
        if (usuarioLogueado == null || usuarioLogueado.get_cliente() == null) {
            return "redirect:/login";
        }

        // Buscamos los objetos relacionados
        Servicios servicio = servicioRepositorio.findById(id_servicio).orElse(null);
        Empleados empleado = empleadoRepositorio.findById(id_empleado).orElse(null);

        if (servicio == null || empleado == null) {
            model.addAttribute("error", "Servicio o empleado no válido");
            return "agendar_cita";
        }

        // ==================== ASIGNACIÓN DE DATOS ====================
        nuevaCita.set_id_cliente(usuarioLogueado.get_cliente());   // Cliente logueado
        nuevaCita.set_id_servicio(servicio);
        nuevaCita.set_id_empleado(empleado);

        // Estado por defecto
        nuevaCita.set_estado_cita(EstadoCita.pendiente);

        // Guardamos la cita en la base de datos
        citasRepositorio.save(nuevaCita);

        model.addAttribute("mensaje", "¡Cita agendada exitosamente para el " + 
                           nuevaCita.get_fecha_cita() + " a las " + nuevaCita.get_hora_cita());

        return "redirect:/mis-citas";
    }
}