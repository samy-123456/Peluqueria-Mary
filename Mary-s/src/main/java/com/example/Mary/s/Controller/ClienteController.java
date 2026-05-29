/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Controller;

/*importamos las librerias necesarias para el controlador */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*importamos la interfas de los clientes */
import com.example.Mary.s.Repository.ClienteRepository;

/*eestablecemos el controlador */
@Controller
public class ClienteController {

    /*
     * inyecta dependencias
     * el programa se conecta con el repositorio para hacer las busquedas con la
     * base de datos
     */
    @Autowired
    /* llamamos al repositorio del cliente */
    private ClienteRepository clienteRepository;

    /* mapeamos la ruta de la vista a la que van dirigidos estos datos */
    @GetMapping("/clientes")
    public String clientes(Model model) {
        /* 1. Buscamos la lista de todos los clientes en la base de datos */
        /* guardamos con el model con el nombre clientes y lo mandamos a la vista */
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes";
    }
}
