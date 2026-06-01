/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos las librerias necesarias para la comunicacion con la DB */
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*indicamos que esto es una entidad sql */
@Entity
/*colocamoes le nombre de la tabla */
@Table(name = "servicios")
public class Servicios{

    /*declaranmso la llave primaria */
    @Id
    /*generamos el atributo de la llave primaria */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;

    /*creamos las demas columnas faltantes */
    /*nombre del servicio */
    @Column(nullable = false)
    private String nombre_servicio;
    /*descripcion del servicio */
    @Column(nullable = false, columnDefinition="TEXT")
    private String descripcion_servicio;
    /*precio del servicio */
    @Column(nullable = false)
    private Double precio_servicio;
    /*tiempo del servicio */
    @Column(nullable = false)
    private Integer duracion_minutos;
    /*imagen de los seervicios */
    @Column(nullable = false)
    private String imagen_servicio;
    /*llave forane acon la categoria */
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_categoria", unique = true, nullable = false)
    private CategoriaServicios id_categoria;

    /*creamos el contrictor vacio */
    public Servicios(){

    }

    /*constructor con parametros */
    public Servicios(String nombre_servicio, String  descripcion_servicio, Double precio_servicio,
    Integer duracion_minutos,String imagen_servicio, CategoriaServicios id_categoria){
        this.nombre_servicio = nombre_servicio;
        this.descripcion_servicio = descripcion_servicio;
        this.precio_servicio = precio_servicio;
        this.duracion_minutos = duracion_minutos;
        this.imagen_servicio = imagen_servicio;
        this.id_categoria = id_categoria;
    }

    /*METODOS GET Y SET */
    /*get del id_servicio */
    public Long get_id_servicio() {
        return id_servicio;
    }

    /*set del id_servicio */
    public void set_id_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    /* get del nombre_servicio */
    public String get_nombre_servicio() {
        return nombre_servicio;
    }

    /* set del nombre_servicio */
    public void set_nombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    /* get del descripcion_servicio */
    public String get_descripcion_servicio() {
        return descripcion_servicio;
    }

    /* set del descripcion_servicio */
    public void set_descripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    /* get del precio_servicio */
    public Double get_precio_servicio() {
        return precio_servicio;
    }

    /* set del precio_servicio */
    public void set_precio_servicio(Double precio_servicio) {
        this.precio_servicio = precio_servicio;
    }

    /* get del duracion_minutos */
    public Integer get_duracion_minutos() {
        return duracion_minutos;
    }

    /* set del duracion_minutos */
    public void set_duracion_minutos(Integer duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    /* get del imagen_servicio */
    public String get_imagen_servicio() {
        return imagen_servicio;
    }

    /* set del imagen_servicio */
    public void set_imagen_servicio(String imagen_servicio) {
        this.imagen_servicio = imagen_servicio;
    }

    /* get del id_categoria */
    public CategoriaServicios get_id_categoria() {
        return id_categoria;
    }

    /* set del id_categoria */
    public void set_id_categoria(CategoriaServicios id_categoria) {
        this.id_categoria = id_categoria;
    }
}