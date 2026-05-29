package com.example.Mary.s.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Productos;
import com.example.Mary.s.Model.Servicios;

@Repository
public interface ServicioRepository extends JpaRepository<Servicios, Long> {

}
