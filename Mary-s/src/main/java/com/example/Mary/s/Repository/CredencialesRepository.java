/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/
package com.example.Mary.s.Repository;

/*importamos las librerias para el jpa repositorio */
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Credenciales;

/*le indicamos a java que no es una clase sino una interfas */
@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Long> {

    // Método para buscar solo por nombre de usuario (el que usa tu AuthController actual)
    @Query("SELECT c FROM Credenciales c WHERE c.nombre_usuario = :nombreUsuario")
    Optional<Credenciales> buscarPorNombreUsuario(@Param("nombreUsuario") String nombreUsuario);

    // Método para buscar por nombre de usuario Y contraseña juntas (por si lo necesitas después)
    @Query("SELECT c FROM Credenciales c WHERE c.nombre_usuario = :nombreUsuario AND c.contraseña_usuario = :contraseñaUsuario")
    Optional<Credenciales> buscarPorUsuarioYContraseña(
            @Param("nombreUsuario") String nombreUsuario,
            @Param("contraseñaUsuario") String contraseñaUsuario
    );
}
