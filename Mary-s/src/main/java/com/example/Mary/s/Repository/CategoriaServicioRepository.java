/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

/*importamos las librerias para el repositorio del jpa */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.CategoriaServicios;

/* DECLARAMOS QUE ESTO ES UNA INTERFAS NO UNA CLASE */
@Repository
public interface CategoriaServicioRepository extends JpaRepository<CategoriaServicios, Long> {
    List<CategoriaServicios> findByCategoria(String nombre_categoria);
}
