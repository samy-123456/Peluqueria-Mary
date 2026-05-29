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

import com.example.Mary.s.Repository.ProductoRepository;
/*ertablecemos el controlador */
@Controller

/*dice que esta clase manejara las rutas web mvc */
public class ProductoController {

    /*inyecta dependencias java conecta con el producto repository aqui*/
    @Autowired
    /*llamamos al repositorio */
    private ProductoRepository productoRepository;
    

    /*mapeamos a la ruta */
    @GetMapping("/")
    /*establecemos un metodo */
    public String index(Model model){
        /*1. Buscamos la lista de todos los productos en la base de datos*/
        /*2. la guardamos en el model con el nombre "productos" para enviarla a la vista*/
        model.addAttribute("productos",productoRepository.findAll());

        return "index";
    }
}
