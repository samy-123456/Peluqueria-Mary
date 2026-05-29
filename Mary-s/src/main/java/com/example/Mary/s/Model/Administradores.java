/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos la persistencia de jakarta */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*establecemos esto como una entidad sql */
@Entity
/*colocamos el nombre de la tabla para mysql */
@Table(name="administradores")
public class Administradores {
    
    /*establecemos la clave primaria de la tabla */
    @Id
    /*generamos el atributo de la clave primaria */
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_administrador;

    /*continuamos con los demas atributos */
    /*nombre del administrador */
    @Column(nullable = false)
    private String nombre_administrador;
    /*apellido del administrador */
    @Column(nullable = false)
    private String apellido_administrador;
    /*correo del administrador */
    @Column(unique=true, nullable = false)
    private String correo_administrador;
    /*telefono del administrador */
    @Column(length=15, nullable = false)
    private String telefono_administrador;

    /*contructor vacio */
    public Administradores(){

    }

    /*constructor con parametros */
    public Administradores(String nombre_administrador, String apellido_administrador,
    String correo_administrador, String telefono_administrador){
        this.nombre_administrador = nombre_administrador;
        this.apellido_administrador = apellido_administrador;
        this.correo_administrador = correo_administrador;
        this.telefono_administrador = telefono_administrador;
    }

    /*METODOS GET Y SET */
    /*get del id_administrador */
    public Long get_id_administrador() {
        return id_administrador;
    }

    /*set del id_administrador */
    public void set_id_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
    }

    /* get del nombre_administrador */
    public String get_nombre_administrador() {
        return nombre_administrador;
    }

    /* set del nombre_administrador */
    public void set_nombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }

    /* get del apellido_administrador */
    public String get_apellido_administrador() {
        return apellido_administrador;
    }

    /* set del apellido_administrador */
    public void set_apellido_administrador(String apellido_administrador) {
        this.apellido_administrador = apellido_administrador;
    }

    /* get del correo_administrador */
    public String get_correo_administrador() {
        return correo_administrador;
    }

    /* set del correo_administrador */
    public void set_correo_administrador(String correo_administrador) {
        this.correo_administrador = correo_administrador;
    }

    /* get del telefono_administrador */
    public String get_telefono_administrador() {
        return telefono_administrador;
    }

    /* set del telefono_administrador */
    public void set_telefono_administrador(String telefono_administrador) {
        this.telefono_administrador = telefono_administrador;
    }
}
