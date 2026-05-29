/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Controller;

/*importamos las librerias que vamos a usar para el controller */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*importamos nuestra interfas del repsitorio */
import com.example.Mary.s.Repository.CategoriaServicioRepository;

/*establecemos el controlador */
@Controller
public class CategoriaServicioController {

    /*
     * inyecta dependencia el programa se conecta conel rpositorio de la categoria
     */
    @Autowired /* llmamaos al repositorio com ocunado creamos un objeto */
    private CategoriaServicioRepository categoriaServicioRepository;

    /* mapeamos la ruta principal de la pagina */
    @GetMapping("/categorias")
    /* establecemos el metodo para listar y filtrar las categorias */
    public String categorias(@RequestParam(name = "nombre_categoria", required = false) String nombre_categoria,
            Model model) {
        /* 1. verificamos si el suuario envio el parametro de busqueda */
        if (nombre_categoria != null && !nombre_categoria.isEmpty()) {
            /* buscamos solo las que coinciden con ese nombre */
            model.addAttribute("categorias", categoriaServicioRepository.findByCategoria(nombre_categoria));
        } else {
            /*
             * 2. si no viene ningun parametro buscamos la lista completa de las categorias
             */
            model.addAttribute("categorias", categoriaServicioRepository.findAll());
        }
        /* retornamos la vista de las categorias.html */
        return "categorias";
    }
}
