/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Galeria;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Long>{
    
    // Trae solo los activos ordenados por el campo "orden"
    List<Galeria> findByActivoTrueOrderByOrdenAsc();
}
