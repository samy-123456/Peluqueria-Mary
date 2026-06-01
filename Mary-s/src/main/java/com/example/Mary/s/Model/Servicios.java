/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos las librerias necesarias para la comunicacion con la DB */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicios {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_servicio;

    @Column(nullable = false)
    private String nombre_servicio;
    private String descripcion_servicio;
    private String tiempo_servicio;
    private String imagenUrl_servicio;
    

    @Column(nullable = false)
    private double precio_servicio;

     @ManyToOne(cascade=CascadeType.REMOVE)
     @JoinColumn(name="id_categoria",unique=true,nullable=false)
     private CategoriaServicios idcatservi;

    /*constructor vacio */
    public Servicios(){

    }

    /*constructor con parametros */
    public Servicios(String nombre_servicio, String descripcion_servicio, String tiempo_servicio, String imagenUrl_servicio, double precio_servicio ,CategoriaServicios idcatservi) {
        this.nombre_servicio = nombre_servicio;
        this.descripcion_servicio = descripcion_servicio;
        this.tiempo_servicio = tiempo_servicio;
        this.imagenUrl_servicio = imagenUrl_servicio;
        this.precio_servicio = precio_servicio;
        this.idcatservi=idcatservi;
    }

    /*metodos get y set*/

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    public String getTiempo_servicio() {
        return tiempo_servicio;
    }

    public void setTiempo_servicio(String tiempo_servicio) {
        this.tiempo_servicio = tiempo_servicio;
    }

    public String getImagenUrl_servicio() {
        return imagenUrl_servicio;
    }

    public void setImagenUrl_servicio(String imagenUrl_servicio) {
        this.imagenUrl_servicio = imagenUrl_servicio;
    }

    public double getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(double precio_servicio) {
        this.precio_servicio = precio_servicio;
    }
    public CategoriaServicios getidcatservi(){
        return idcatservi;
    }
    public void setidcatservi(CategoriaServicios idcatservi){
        this.idcatservi=idcatservi;

    }
}
