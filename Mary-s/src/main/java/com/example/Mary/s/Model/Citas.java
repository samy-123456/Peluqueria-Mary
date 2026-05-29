/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;
/*importamos las librerias necesarias para la comunicacion con la DB */
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*establecemos esto como una entidad sql */
@Entity
/*colocamos el nombre de la tabla */
@Table(name="citas")
public class Citas {
     /*establecemos la llave primaria de la tabla */
     @Id
     /*generamos el campo de la tabla primaria*/
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id_cita;

     /*declaramos los atributos faltantes */
     /*fecha de la cita */
     @Column(nullable = false)
     private LocalDate fecha_cita;
     /*hora de la cita */
     @Column(nullable = false)
     private LocalTime hora_cita;
     /*estado de la cita*/
     @Enumerated(EnumType.STRING)
     private EstadoCita estado_cita = EstadoCita.pendiente;
     /*llaves foraneas con el cliente, el empleado, el servicio y el administrador*/
     /*llave foranea con el cliente */
     @ManyToOne(cascade = CascadeType.REMOVE)
     @JoinColumn(name = "id_cliente", unique = true, nullable = false)
     private Clientes id_cliente;
     /*llave foranea con el empleado */
     @ManyToOne(cascade = CascadeType.REMOVE)
     @JoinColumn(name = "id_empleado", unique = true, nullable = false)
     private Empleados id_empleado;
     /*llave foranea con el servicio */
     @ManyToOne(cascade = CascadeType.REMOVE)
     @JoinColumn(name = "id_servicio", unique = true, nullable = false)
     private Servicios id_servicio;
     /*llave foranea con el administrador */
     @ManyToOne(cascade = CascadeType.REMOVE)
     @JoinColumn(name = "id_administrador", unique = true, nullable = false)
     private Administradores id_administrador;

     /*constructor vacio */
     public Citas(){

     }

     /*constructor con parametros */
     public Citas(LocalDate fecha_cita, LocalTime hora_cita, EstadoCita estado_cita,
     Clientes id_cliente, Empleados id_empleado, Servicios id_servicio, Administradores id_administrador){
         this.fecha_cita = fecha_cita;
         this.hora_cita = hora_cita;
         this.estado_cita = estado_cita;
         this.id_cliente = id_cliente;
         this.id_empleado = id_empleado;
         this.id_servicio = id_servicio;
         this.id_administrador = id_administrador;
     }

     /*METODOS GET Y SET */
     /*get del id_cita */
     public Long get_id_cita() {
         return id_cita;
     }

     /*set del id_cita */
     public void set_id_cita(Long id_cita) {
         this.id_cita = id_cita;
     }

     /* get del fecha_cita */
     public LocalDate get_fecha_cita() {
         return fecha_cita;
     }

     /* set del fecha_cita */
     public void set_fecha_cita(LocalDate fecha_cita) {
         this.fecha_cita = fecha_cita;
     }

     /* get del hora_cita */
     public LocalTime get_hora_cita() {
         return hora_cita;
     }

     /* set del hora_cita */
     public void set_hora_cita(LocalTime hora_cita) {
         this.hora_cita = hora_cita;
     }

     /* get del estado_cita */
     public EstadoCita get_estado_cita() {
         return estado_cita;
     }

     /* set del estado_cita */
     public void set_estado_cita(EstadoCita estado_cita) {
         this.estado_cita = estado_cita;
     }

     /* get del id_cliente */
     public Clientes get_id_cliente() {
         return id_cliente;
     }

     /* set del id_cliente */
     public void set_id_cliente(Clientes id_cliente) {
         this.id_cliente = id_cliente;
     }

     /* get del id_empleado */
     public Empleados get_id_empleado() {
         return id_empleado;
     }

     /* set del id_empleado */
     public void set_id_empleado(Empleados id_empleado) {
         this.id_empleado = id_empleado;
     }

     /* get del id_servicio */
     public Servicios get_id_servicio() {
         return id_servicio;
     }

     /* set del id_servicio */
     public void set_id_servicio(Servicios id_servicio) {
         this.id_servicio = id_servicio;
     }

     /* get del id_administrador */
     public Administradores get_id_administrador() {
         return id_administrador;
     }

     /* set del id_administrador */
     public void set_id_administrador(Administradores id_administrador) {
         this.id_administrador = id_administrador;
     }
}
