/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/
package com.example.Mary.s.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Mary.s.Model.Empleados;
import org.springframework.data.jpa.repository.Query;

/*ESTO ES UNA INTERFAS NO UNA CLASE DE JAVA ES LA CONECCION CON LA BD */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Long> {

    @Query("SELECT e FROM Empleados e WHERE LOWER(e.nombre_empleado) = LOWER(:nombre_empleado)")
    List<Empleados> findByNombreEmpleado(String nombre_empleado);
}
