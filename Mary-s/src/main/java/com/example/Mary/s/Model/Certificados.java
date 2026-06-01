/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/
package com.example.Mary.s.Model;

import jakarta.persistence.*;

public class Certificados {
    @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id_certificado;
@Column(nullable=false)
private String nombre_certificado;
@Column(nullable=false)
private String Institucion_certificado;
@Column(nullable=false)
private String fecha_emicion_certificado;
@Column(nullable=false)
private String fecha_vencimiento_certificado;

// se agreaga la clave foranea  una a muchos 
// se pone la palabra cascada para que
// al eliminarce el empleado tambien se elimina el sertificado
// se utiliza para borrar l registro de la tabla relacionada para q no qd dts huerfanos 
@ManyToOne(cascade=CascadeType.REMOVE)
// join colum : indica q es una llave foranea , entre la relacion de tablas 
@JoinColumn(name = "id_empleado" , unique=true, nullable=false )
private Empleados  id_empleado;;

/*contrusctor vacion*/
public Certificados(){

}
// constructor con parametros
public Certificados(String nombre_certificado, String Institucion_certificado, 
String fecha_emicion_certificado, String fecha_vencimiento_certificado, Empleados id_empleado) {
    this.nombre_certificado = nombre_certificado;
    this.Institucion_certificado = Institucion_certificado;
    this.fecha_emicion_certificado = fecha_emicion_certificado;
    this.fecha_vencimiento_certificado = fecha_vencimiento_certificado;
    this.id_empleado = id_empleado;
}
/* metodos get y set de los parametros*/
public Long getId_certificado() {
    return id_certificado;
}
public void setId_certificado(Long id_certificado) {
    this.id_certificado = id_certificado;
}
public String getNombre_certificado() {
    return nombre_certificado;
}
public void setNombre_certificado(String nombre_certificado) {
    this.nombre_certificado = nombre_certificado;
}
public String getInstitucion_certificado() {
    return Institucion_certificado;
}
public void setInstitucion_certificado(String institucion_certificado) {
    Institucion_certificado = institucion_certificado;
}
public String getFecha_emicion_certificado() {
    return fecha_emicion_certificado;
}
public void setFecha_emicion_certificado(String fecha_emicion_certificado) {
    this.fecha_emicion_certificado = fecha_emicion_certificado;
}
public String getFecha_vencimiento_certificado() {
    return fecha_vencimiento_certificado;
}
public void setFecha_vencimiento_certificado(String fecha_vencimiento_certificado) {
    this.fecha_vencimiento_certificado = fecha_vencimiento_certificado;
}
public Empleados getId_empleado() {
    return id_empleado;
}
public void setId_empleado(Empleados id_empleado) {
    this.id_empleado = id_empleado;
}
}