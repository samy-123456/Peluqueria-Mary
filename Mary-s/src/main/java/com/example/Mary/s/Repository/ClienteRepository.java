/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

/* importamos las librerias que necesitamos */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Mary.s.Model.Clientes;

/* DECLARAMOS QUE ES UNA INTERFAZ PARA CONECTAR CON LA DB (NO ES UNA CLASE) */
@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
