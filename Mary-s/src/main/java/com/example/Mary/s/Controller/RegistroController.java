/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Controller;

/*importamos las librerias y el repositorio */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Mary.s.Model.Clientes;
import com.example.Mary.s.Repository.ClienteRepository;
import com.example.Mary.s.Model.Credenciales;
import com.example.Mary.s.Repository.CredencialesRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*establecemos el controlador */
@Controller
public class RegistroController {

    /* inyectamos las dependencias */
    /*
     * el programa se conectara ahora con los 2 repositorios para registrar al
     * cliente y al usuario al mismo timepo en un registro unico wow
     */
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CredencialesRepository credencialesRepository;

    /*
     * establecemos el encriptador para poder encriptar la contraseña por seguridad
     */
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /* posteamos el metodo para registrar al usuario */
    @PostMapping("/registrar-usuario")
    public String registrarUsuario(
            // Datos de la tabla de los clientes
            @RequestParam("nombre_cliente") String nombre_cliente,
            @RequestParam("apellido_cliente") String apellido_cliente,
            @RequestParam("telefono_cliente") String telefono_cliente,
            @RequestParam("correo_cliente") String correo_cliente,
            @RequestParam("direccion_cliente") String direccion_cliente,
            @RequestParam("fecha_registro_cliente") java.time.LocalDateTime fecha_registro_cliente,
            // Datos de la tabla de las credenciales
            @RequestParam("nombre_usuario") String nombre_usuario,
            @RequestParam("contraseña_usuario") String contraseña_usuario,
            Model model) {

        /* 1. creamos el objeto cliente y lo guardamos en Mysql */
        Clientes nuevoCliente = new Clientes();
        /* primero ingresaomos los datos del cliente */
        nuevoCliente.set_nombre_cliente(nombre_cliente);
        nuevoCliente.set_apellido_cliente(apellido_cliente);
        nuevoCliente.set_telefono_cliente(telefono_cliente);
        nuevoCliente.set_correo_cliente(correo_cliente);
        nuevoCliente.set_direccion_cliente(direccion_cliente);
        nuevoCliente.set_fecha_registro_cliente(fecha_registro_cliente);

        /* ahora guardamos a nuestro nuevo cliente */
        Clientes clienteGuardado = clienteRepository.save(nuevoCliente);

        /* creamos las credenciales y la conectamos con el cliente */
        Credenciales nuevaCredencial = new Credenciales();
        nuevaCredencial.set_nombre_usuario(nombre_usuario);

        /* encriptamos la contraseña */
        String contraseñaSegura = encoder.encode(contraseña_usuario);
        /* y la guardamos ahora si en la base de datos */
        nuevaCredencial.set_contraseña_usuario(contraseñaSegura);

        /* ahora si conectamos la llave foranea para poder hacer la relacion */
        nuevaCredencial.set_cliente(clienteGuardado);
        /* por ultimo guardamos la credencial enla base de datos */
        credencialesRepository.save(nuevaCredencial);

        /* una vez terminado el registro le devolvemos al Login */
        return "redirect:/login";
    }

}
