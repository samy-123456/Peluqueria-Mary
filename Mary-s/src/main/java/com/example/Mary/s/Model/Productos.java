/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos el jakarta que permite jacer el sql pero programando en java */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*el @entity señala que no es una clase de java sino una entidad sql */
@Entity

/* el arroba table es paracrear la tabla y colocamos el nombre de la tabla */
@Table(name = "productos")

public class Productos {

    /* identifica q este es la clave primaria de la tabla */
    @Id

    /* generamos los campos de la tabla */
    /* generar el primer campo la clve primaria no podemos usarle el @Column */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /* el nombre del campo patra la primary key */
    private Long id_producto;

    /* establecemos la columna de la yabla que es para el nombre */
    @Column(nullable = false)
    /*
     * establecemos la variable private del tipo String para q sql identifique q va
     * a ser un String
     */
    private String nombre_producto;

    /* creamos la columna del precio */
    @Column(nullable = false)

    /*
     * establecemos la variable private del tipo double para q sql identifique q va
     * a ser un double
     */
    private double precio_producto;

    /* creamos la columna de la cantidad */
    @Column(nullable = false)

    /*
     * establecemos la variable private del tipo int para q sql identifique q va a
     * ser un int
     */
    int cantidad_producto;

    /* creamos la columna de la descripcion */
    @Column(length = 2000)

    /*
     * establecemos la variable private del tipo String para q sql identifique q va
     * a ser un String
     */
    private String descripcion_producto;

    /* creamos la columna de la imagen */
    private String imagenUrl_producto;

    /* creamos el constructor vacio */
    public Productos() {
    }

    /* creamos el constructor con parametros */
    public Productos(String nombre_producto, double precio_producto, int cantidad_producto, String descripcion_producto,
            String imagenUrl_producto) {
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.cantidad_producto = cantidad_producto;
        this.descripcion_producto = descripcion_producto;
        this.imagenUrl_producto = imagenUrl_producto;
    }
    /* damos los metodos get y set de todos los parametros */

    /* get del id del producto */
    public Long getId_producto() {
        return id_producto;
    }

    /* set del id del producto */
    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    /* get del nombre del producto */
    public String getNombre_producto() {
        return nombre_producto;
    }

    /* set del nombre del producto */
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    /* get del precio del producto */
    public double getPrecio_producto() {
        return precio_producto;
    }

    /* set del precio del producto */
    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    /* get de la cantidad del producto */
    public int getCantidad_producto() {
        return cantidad_producto;
    }

    /* set de la cantidad del producto */
    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    /* get de la descripcion del producto */
    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    /* set de la descripcion del producto */
    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getImagenUrl_producto() {
        return imagenUrl_producto;
    }

    public void setImagenUrl_producto(String imagenUrl_producto) {
        this.imagenUrl_producto = imagenUrl_producto;
    }

}
