/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

/* CRUD AUTOMATICO */
package com.example.Mary.s.Repository;
/*ESTO NO ES UNA CLASE ES UNA INTERFAS*/

/*importamos librerias */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mary.s.Model.Productos;

/*muestra q es un repositorio */
/*en caso de algun error se guarda en el repositorio */
@Repository
/* es una interfas no una clase aqui se aplcia la logica de la clase */
/* por esto se lo deja vacio */
/* le dice que el LOng llave la llave primaria @ id pueda referenciarla */
public interface ProductoRepository extends JpaRepository<Productos, Long> {
}
