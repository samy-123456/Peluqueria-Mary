/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Servicios;

@Repository
public interface ServicioRepository extends JpaRepository<Servicios, Long> {
    List<Servicios> findByNombre_servicioignoreCase(String nombre_servicio);
}
