/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/
package com.example.Mary.s.Repository;

/*importamos laslibrerias necesarias */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Certificados;

/*declaramos que esta interfaz es una interfaz para comunicar con la base de datos */
@Repository
public interface CertificadosRepository extends JpaRepository<Certificados, Long> {

}
