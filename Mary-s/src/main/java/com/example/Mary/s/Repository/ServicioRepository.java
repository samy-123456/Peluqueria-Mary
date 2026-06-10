/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Mary.s.Model.Servicios;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ServicioRepository extends JpaRepository<Servicios, Long> {
   @Query("SELECT s FROM Servicios s WHERE LOWER(s.nombre_servicio) = LOWER(:nombre_servicio)")
List<Servicios> findByNombreServicioPersonalizado(String nombre_servicio);
}
