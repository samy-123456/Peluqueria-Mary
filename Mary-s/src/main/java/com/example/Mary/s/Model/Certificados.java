/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos las librerias necesarias de jakarta */
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*establecemos esto como una entidad sql */
@Entity
/*ponemos el nombre de la tabla */
@Table(name="certificados")
public class Certificados {

/*establecemos los archivos de la clave primaria */
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_certificado;

/*declaramos los atributos faltantes */
/*nombre del certificado */
@Column(nullable = false)
private String nombre_certificado;
/*nombre de la institucion del certificado */
@Column(nullable = false)
private String institucion_certificado;
/*fecha de emicion dell certificado */
@Column(nullable = false , updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
private java.time.LocalDateTime fecha_emicion_certificado;
/*fecha de vencimiento del certificado */
@Column(nullable = false)
private LocalDate fecha_vencimiento_certificado;
/*llave foranea con los empleados */
@ManyToOne(cascade = CascadeType.REMOVE)
@JoinColumn(name = "id_empleado", unique = true, nullable = false)
private Empleados id_empleado;

/*creamos un constructor vacio para recibir los datos */
public Certificados(){

}

/*constructor con parametros */
public Certificados(String nombre_certificado, String institucion_certificado,
java.time.LocalDateTime fecha_emicion_certificado, LocalDate fecha_vencimiento_certificado, Empleados id_empleado){
    this.nombre_certificado = nombre_certificado;
    this.institucion_certificado = institucion_certificado;
    this.fecha_emicion_certificado = fecha_emicion_certificado;
    this.fecha_vencimiento_certificado = fecha_vencimiento_certificado;
    this.id_empleado = id_empleado;
}

/*METODOS GET Y SET */
/*get del id del certificado */
public Long getId_certificado() {
    return id_certificado;
}

/*set del id del certificado */
public void setId_certificado(Long id_certificado) {
    this.id_certificado = id_certificado;
}

/*get del nombre del certificado */
public String getNombre_certificado() {
    return nombre_certificado;
}

/*set del nombre del certificado */
public void setNombre_certificado(String nombre_certificado) {
    this.nombre_certificado = nombre_certificado;
}

/*get del nombre de la institucion del certificado */
public String getInstitucion_certificado() {
    return institucion_certificado;
}

/*set del nombre de la institucion del certificado */
public void setInstitucion_certificado(String institucion_certificado) {
    this.institucion_certificado = institucion_certificado;
}

/*get del fecha de emicion del certificado */
public java.time.LocalDateTime getFecha_emicion_certificado() {
    return fecha_emicion_certificado;
}

/*set del fecha de emicion del certificado */
public void setFecha_emicion_certificado(java.time.LocalDateTime fecha_emicion_certificado) {
    this.fecha_emicion_certificado = fecha_emicion_certificado;
}

/*get del fecha de vencimiento del certificado */
public LocalDate getFecha_vencimiento_certificado() {
    return fecha_vencimiento_certificado;
}

/*set del fecha de vencimiento del certificado */
public void setFecha_vencimiento_certificado(LocalDate fecha_vencimiento_certificado) {
    this.fecha_vencimiento_certificado = fecha_vencimiento_certificado;
}

/*get del id_empleado */
public Empleados get_id_empleado() {
    return id_empleado;
}

/*set del id_empleado */
public void set_id_empleado(Empleados id_empleado) {
    this.id_empleado = id_empleado;
}
}
