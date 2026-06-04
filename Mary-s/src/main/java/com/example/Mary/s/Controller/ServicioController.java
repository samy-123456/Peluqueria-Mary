package com.example.Mary.s.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Mary.s.Repository.ServicioRepository;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicios";
    }

    /* mapeamos la ruta par la categoria */
    @GetMapping("/categorias")
    public String vercategorias() {
        return "categorias";
    }

    /* mapeamos y colocamos la logica para redirigir a las categorias */
    @GetMapping("/servicios")
    public String listarProductos(@RequestParam(name = "categoria", required = false) String categoria, Model model) {
        if (categoria != null && !categoria.isEmpty()) {
            model.addAttribute("servicios", servicioRepository.findByCategoriaignoreCase(categoria));
        } else {
            model.addAttribute("servicio", servicioRepository.findAll());
        }
        /* retornamos al index */
        return "index";
    }
}
