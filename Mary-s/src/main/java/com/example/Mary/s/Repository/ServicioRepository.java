package com.example.Mary.s.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Mary.s.Model.Servicios;
import java.util.List;
@Repository
public interface ServicioRepository extends JpaRepository<Servicios, Long> {
List<Servicios> findByNombre_servicio(String nombre_servicio);
}
