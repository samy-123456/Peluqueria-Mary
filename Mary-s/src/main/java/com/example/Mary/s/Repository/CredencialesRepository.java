/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Repository;

/*importamos las librerias para el jpa repositorio */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Credenciales;

import java.util.Optional;

/*le indicamos a java que no es una clase sino una interfas */
@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {

    Optional<Credenciales> findBynombre_usuarioAndcontraseña_usuario(String nombre_usuario, String contraseña_usuario);

    Optional<Credenciales> findBynombre_usuario(String nombre_usuario);
}
