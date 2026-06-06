/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Controller;

/*importamos las librerias del controlador y los modelos y repositorios q vamos a utilizar */
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/*importamos librerias para encriptar la contraseña del usuario */
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*importamos todos los archivos de la carpeta model y repository */
import com.example.Mary.s.Model.*;
import com.example.Mary.s.Repository.*;
/*importamos la funcion de opcional */
import java.util.Optional;

/*establecemos la clase como un controlador */
/*es decir que va a manejar las rutas web */
@Controller
public class AuthController {
    /* spring inyecta directamente al repositorio */
    @Autowired
    private CredencialesRepository credencialesRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    /* creamos el encriptador de la contraseña */
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // --------------------------- Login ----------------------------//

    /* mostramos el formulario del Login */
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    /* procesamos el login cuando el usuario envia el formulario */
    @PostMapping("/login")
    private String procesarLogin(@RequestParam String nombre_usuario, @RequestParam String contraseña_usuario,
            HttpSession session, Model model) {

        /* buscamos en la base d e datos el usuario si es q existe */
        Optional<Credenciales> credencialOpt = credencialesRepository.findBynombre_usuario(nombre_usuario);

        if (credencialOpt.isPresent()) {
            /* obtenemos los dato del formulario */
            Credenciales credencial = credencialOpt.get();

            /* compara la contraseña ingresada con la encriptada */
            boolean contraseñaCoincide = passwordEncoder.matches(contraseña_usuario,
                    credencial.get_contraseña_usuario());

            /* si coinciden guardamos el login */
            if (contraseñaCoincide) {
                session.setAttribute("usuarioLogueado", credencial);
                /* verificamos que quien esta sea el admin para enviarlo a su pagina */
                if (credencial.get_rol_usuario() == RolUsuario.admin) {
                    return "redirect:/principal";
                } else {
                    return "redirect:/index";
                }
            }
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";

    }

    /* registro en 2 pasos */
    /* paso 1 */
    /*---------- registro para el cliente sin credenciales ---------- */
    /* mostramos el formilario de registro del cleinte */
    @GetMapping("/registrar_cliente")
    public String mostrarRegistroCliente(Model model) {
        /* agregamos un objeto vacio para el formulario */
        model.addAttribute("cliente", new Clientes());
        /* retornamos la vista */
        return "registrar_cliente";
    }

    /*
     * procedemos a registrar es decir a obtener y guardar los datos del formulario
     */

    @PostMapping("/registrar_cliente")
    public String procesarRegistroCliente(@ModelAttribute Clientes cliente, HttpSession session, Model model) {

        /* verificamos q el usuario llene el formulario de forma obligatoria */
        if (cliente.get_nombre_cliente() == null || cliente.get_apellido_cliente() == null
                || cliente.get_correo_cliente() == null) {
            /*
             * mostramos un mensaje de error con model . adddAttribute que sirve para
             * agregar atributos a la vista
             */
            model.addAttribute("error", "Nombre, Apellido y Correo son obligatorios");
            model.addAttribute("cliente", cliente);
            return "registrar_cliente";
        }

        /* guardamos al cliente en la base de datos */
        cliente.set_fecha_registro_cliente(java.time.LocalDateTime.now());
        Clientes clienteGuardado = clienteRepository.save(cliente);
        /* guardamos el id del cliente en la sesion para usarlo en el paso 2 */
        session.setAttribute("clienteEnRegistro", clienteGuardado);

        return "redirect:registrar_usuario";
    }

    /* paso 2 mostramos el formulario de usuario */
    @GetMapping("/registrar_usuario")
    public String mostrarRegistroUsuario(HttpSession session, Model model) {
        /* validamos que el usuario haya llenado primero el fromulario de cliente */
        /* lo que definimos antes en la funcion anterior */
        if (session.getAttribute("clienteEnRegistro") == null) {
            /*
             * si el registro anterior no se lleno y solo dio click en siguiente le
             * regresamos a la pantalla de registro_cliente
             */
            return "redirect:/registrar_cliente";
        }
        return "registrar_usuario";
    }

    /* procesamos el nombre de usuario y la contraseña */
    @PostMapping("/registrar_usuario")
    public String porcesarRegistroUsuario(@RequestParam String nombre_usuario, @RequestParam String contraseña_usuario,
            HttpSession session, Model model) {

        /* obtenemos al usuario que lleno el registro anterior */
        Clientes cliente = (Clientes) session.getAttribute("clienteEnRegistro");
        /* validamos que el cliente tenga lleno el formulario anterior */
        if (cliente == null) {
            /* le rediriginmos al formulario anterior */
            return "redirefct:/registrar_cliente";
        }
        /* en caso contrario ahora verificamos que el nombre de usuario no exista */
        if (credencialesRepository.findBynombre_usuario(nombre_usuario).isPresent()) {
            model.addAttribute("error", "El nombre de usuario ya esta en uso");
            return "registrar_usuario";
        }

        /* encriptacion de la contraseña */
        String contraseñaEncriptada = passwordEncoder.encode(contraseña_usuario);

        /* comenzamos a guardar los datos de usuario */

        Credenciales credenciales = new Credenciales();
        /* guardamos el nombre del usuario */
        credenciales.set_nombre_usuario(nombre_usuario);
        /* guardamos la contraseña encriptada */
        credenciales.set_contraseña_usuario(contraseñaEncriptada);
        /* le damos el rol de usuario por default cliente */
        credenciales.set_rol_usuario(RolUsuario.cliente);
        /* gardamos a este nuevo cliente */
        credenciales.set_cliente(cliente);

        /* enviamos los datos al repositorio para que guarde en la base de datos */
        credencialesRepository.save(credenciales);

        /*
         * eliminamos al cliente que estaba en registro ya q ya se registro ahora es
         * usuario
         */
        session.removeAttribute("clienteEnRegistro");

        /* enviamos un mensaje de exito al nuevo usuario */
        model.addAttribute("mensaje", "¡Registro completado con éxito!");
        return "login";
    }

    /* cierre de la session */
    /*
     * no necesitamos una agina de logout solo es un metodo que le añadiremos a
     * nuetsro boton o navbar
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
