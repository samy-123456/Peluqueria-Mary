/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

/*importamos las librerias que necesitamos */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Citas;

/*estoe s una interfa para hablar con mysql */

/*Repositorio */
@Repository
public interface CitasRepository extends JpaRepository<Citas,Long>{
    
}
