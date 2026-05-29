/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

/*importamos las librerias para el jpa repositorio */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Mary.s.Model.Credenciales;

/*le indicamos a java que no es una clase sino una interfas */
@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {

}
