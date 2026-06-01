/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos la libreria de jakarta para usar sql en programacion de java */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*@Entity indica q es una entidad sql */
@Entity

/* @Table da le nombre de la tabla para mysql */
@Table(name = "categoria_servicios")

public class CategoriaServicios {
    /* indentificamos q este atributo es la clave primaria */
    @Id

    /* generamos los campos de la tabla */
    /* Generamos el campo de la clave primaria */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* nombre de la primary key */
    private Long id_categoria;

    /* establecemos la columna del nombre de la categoria */
    /* nombre de la categoria */
    @Column(nullable = false)
    private String nombre_categoria;
    /*imagen para mostrar en la vista de la categoria */
    @Column(nullable = false)
    private String imagen_categoria;

    /* creamos el constructor vacio */
    public CategoriaServicios() {

    }

    /* creamos ahora un constructor con parametros */
    public CategoriaServicios(String nombre_categoria, String imagen_categoria) {
        this.nombre_categoria = nombre_categoria;
        this.imagen_categoria = imagen_categoria;
    }

    /* CREAMOS LOS METODOS GET Y SET DE LOS PARAMETROS */

    public Long get_id_categoria() {
        return id_categoria;
    }

    public void set_id_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String get_nombre_categoria() {
        return nombre_categoria;
    }

    public void set_nombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String get_imagen_categoria(){
        return imagen_categoria;
    }

    public void set_imagen_categoria(String imagen_categoria){
        this.imagen_categoria = imagen_categoria;
    }
}
