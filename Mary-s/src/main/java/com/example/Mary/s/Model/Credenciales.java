/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos las librerias de jakarta
    que permite hacer el sql programando en java */

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*indicamos que es una entidad de sql */
@Entity
/* colocamos el nombre de nuestra tabla */
@Table(name = "credenciales")
public class Credenciales {

    /* Identificamos la llave primaria */
    @Id
    /* generamos el atributo del allave primaria */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_credencial;

    /* generamos las columnas faltantes */
    /* nomrbe usuario */
    @Column(unique = true, nullable = false)
    private String nombre_usuario;
    /* contraseña del usuario */
    @Column(unique = true, nullable = false)
    private String contraseña_usuario;
    /* roldel usuario */
    /* mapeamos el archivo que tiene el rol para el atributo enum */
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    /* establecemos que el valor por defecto va a ser cliente */
    private RolUsuario rol_usuario = RolUsuario.cliente;

    /* llave foranea con los clientes */
    /*
     * el OneToOne dice que una relacion de uno a uno
     * cascade = CascadeType.REMOVE dice si borro la credencial borra la relacion
     */
    @OneToOne(cascade = CascadeType.REMOVE)
    /*
     * ya noestablecemos como column sino como join column para especificar que el
     * atributo
     * es una llave foranea
     */
    @JoinColumn(name = "id_cliente", unique = true, nullable = false)
    /*
     * con el OnDelet damos la accionde elliminar y liego especificamos que sea en
     * cascada
     */
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clientes cliente;

    /* constructor vacio */
    public Credenciales() {

    }

    /* constructor con parametros */
    public Credenciales(String nombre_usuario, String contraseña_usuario,
            RolUsuario rol_usuario, Clientes cliente) {
        this.nombre_usuario = nombre_usuario;
        this.contraseña_usuario = contraseña_usuario;
        this.rol_usuario = rol_usuario;
        this.cliente = cliente;
    }

    /* METODOS GET Y SET DELOS ATRIBUTOS */
    /* get del id de credencial */
    public Long get_id_credencial() {
        return id_credencial;
    }

    /* set del did de credencial */
    public void set_id_credencial(Long id_credencial) {
        this.id_credencial = id_credencial;
    }

    /* get del nombre del usuario */
    public String get_nombre_usuario() {
        return nombre_usuario;
    }

    /* set del nombre del usuario */
    public void set_nombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /* get de la contraseña del usuario */
    public String get_contraseña_usuario() {
        return contraseña_usuario;
    }

    /* set de la contraseña del usuario */
    public void set_contraseña_usuario(String contraseña_usuario) {
        this.contraseña_usuario = contraseña_usuario;
    }

    /* get del rol del usuario */
    /* establecemos primero el nombre de la clase donde esta el enum */
    public RolUsuario get_rol_usuario() {
        return rol_usuario;
    }

    /* set del rol del usuario */
    /* colocamos el nombre de la clase donde esta el enum */
    public void set_rol_usuario(RolUsuario rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    /* get del cliente */
    /* colocamos el nombre de la clase donde esta el atributo */
    public Clientes get_cliente() {
        return cliente;
    }

    /* set del cliente */
    /* colocamos el nombre de la clase donde esta el atributo */
    public void set_cliente(Clientes cliente) {
        this.cliente = cliente;
    }

}
