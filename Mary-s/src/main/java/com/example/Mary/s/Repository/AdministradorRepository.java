/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

/*importamos las librerias necesarias */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Administradores;
/*indicamos q esto es una interfas para hablar on la base de datos */
@Repository
public interface AdministradorRepository extends JpaRepository<Administradores,Long>{
    
}
