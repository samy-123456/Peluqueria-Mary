/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos las livreiras necesarias de jakarta
  que permite hacer el sql programando en java */

import jakarta.persistence.*;

/*el @entity señala que esto es una entidad sql no una clase */
@Entity

/* es para crear la tabla y colocamos el nombre de la tabla */
@Table(name = "clientes")
public class Clientes {

    /* identificamos la clave primaria */
    @Id

    /* generamos los campos de la tabla */

    /* generamos el primer campo de la clave priamria */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    /* creamos las columnas faltantes */
    /* nombre del cliente */
    @Column(nullable = false)
    private String nombre_cliente;
    /* apellido del cliente */
    @Column(nullable = false)
    private String apellido_cliente;
    /* telefono del cliente con limite de 15 caracteres */
    @Column(length = 15)
    private String telefono_cliente;
    /* correo del cliente */
    @Column(unique = true, nullable = false)
    private String correo_cliente;
    /* direccion del cliente */
    @Column(length = 200)
    private String direccion_cliente;
    /* fecha de registro del cliente a a la plataforma */
    /*
     * usamos el updatable para q cunado se actualice la tabla ese dato no se pueda
     * modificar
     * y usamos el columnDefinition para poner el tipo de dato de sql para que jpa
     * le diga sql
     * que use ese tipo de dato
     */
    /* colocamos el java.time.LocalDateTime para q guarde la hora y el dia */
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.time.LocalDateTime fecha_registro_cliente;

    /* constructor vacio */
    public Clientes() {

    }

    /* constructor con los aprametros de los atributos */
    public Clientes(String nombre_cliente, String apellido_cliente, String telefono_cliente,
            String correo_cliente, String direccion_cliente, java.time.LocalDateTime fecha_registro_cliente) {
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.telefono_cliente = telefono_cliente;
        this.correo_cliente = correo_cliente;
        this.direccion_cliente = direccion_cliente;
        this.fecha_registro_cliente = fecha_registro_cliente;
    }

    /* METODOS GET Y SET DE LOS ATRIBUTOS */

    /* get id de cliente */
    public Long get_id_cliente() {
        return id_cliente;
    }

    /* set id cliente */
    public void set_id_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    /* get del nombre del cliente */
    public String get_nombre_cliente() {
        return nombre_cliente;
    }

    /* set nombre del cliente */
    public void set_nombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    /* get apellido del cliente */
    public String get_apellido_cliente() {
        return apellido_cliente;
    }

    /* set apellido del cliente */
    public void set_apellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    /* get telefono del cliente */
    public String get_telefono_cliente() {
        return telefono_cliente;
    }

    /* set telefono del cliente */
    public void set_telefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    /* get correo del cliente */
    public String get_correo_cliente() {
        return correo_cliente;
    }

    /* set correo del cliente */
    public void set_correo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    /* get direccion del cliente */
    public String get_direccion_cliente() {
        return direccion_cliente;
    }

    /* set direccion del cliente */
    public void set_direccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    /* get fecha de registro del cliente */
    public java.time.LocalDateTime get_fecha_registro_cliente() {
        return fecha_registro_cliente;
    }

    /* set fecha de registro del cliente */
    public void set_fecha_registro_cliente(java.time.LocalDateTime fecha_registro_cliente) {
        this.fecha_registro_cliente = fecha_registro_cliente;
    }
}
