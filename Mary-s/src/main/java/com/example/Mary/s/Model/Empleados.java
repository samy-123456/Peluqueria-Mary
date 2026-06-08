/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos las librerias necesarias que vamos a usar */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*declaramos que esto es una entidad de sql no una clase java */
@Entity
/*colocamos el nombre de la tabla del sql */
@Table(name="empleados")
public class Empleados {

    /*declaramos cuakl es la clave primaria */
    @Id
    /*lgeneramos la columna de la llave primaria */
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_empleado;
    /*declaramos lpos atributos faltantes */
    /*el nombre del empleado */
    @Column(nullable=false)
    private String nombre_empleado;
    /*el apellido del empleado */
    @Column(nullable = false)
    private String apellido_empleado;
    /*telefono del empleado */
    @Column(length = 15)
    private String telefono_empleado;
    @Column(unique = true , nullable = false)
    /*correo del empleado */
    private String correo_empleado;
    /*cargo del empleado */
    @Column (nullable = false)
    private String cargo_empleado;
    /*salario del empleado */
    @Column(nullable = false)
    private Double salario_empleado;
    /*fto del empleado */
    @Column(nullable = false)
    private String imagen_empleado;
    /*descripcion del trabajo del empleado */
    @Column(nullable = false)
    private String descripcion_trabajo_empleado;

    /*creamos el constructor vacio */
    public Empleados(){


    }

    /*constructor con parametrso */
    public Empleados(String nombre_empleado, String apellido_empleado, String telefono_empleado,
    String correo_empleado, String cargo_empleado, Double salario_empleado, String imagen_empleado,
    String nombre_trabajo_empleado, String imagen_trabajo_empleado, String descripcion_trabajo_empleado) {
        this.nombre_empleado=nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado=telefono_empleado;
        this.correo_empleado = correo_empleado;
        this.cargo_empleado = cargo_empleado;
        this.salario_empleado = salario_empleado;
        this.imagen_empleado = imagen_empleado;
        this.nombre_trabajo_empleado = nombre_trabajo_empleado;
        this.imagen_trabajo_empleado = imagen_trabajo_empleado;
        this.descripcion_trabajo_empleado = descripcion_trabajo_empleado;
    }

    /*METODOS GET Y SET */
    /*get del id_empleado */
    public Long get_id_empleado() {
        return id_empleado;
    }

    /*set del id_empleado */
    public void set_id_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    /* get del nombre_empleado */
    public String get_nombre_empleado() {
        return nombre_empleado;
    }

    /* set del nombre_empleado */
    public void set_nombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    /* get del apellido_empleado */
    public String get_apellido_empleado() {
        return apellido_empleado;
    }

    /* set del apellido_empleado */
    public void set_apellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    /* get del telefono_empleado */
    public String get_telefono_empleado() {
        return telefono_empleado;
    }

    /* set del telefono_empleado */
    public void set_telefono_empleado(String telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    /* get del correo_empleado */
    public String get_correo_empleado() {
        return correo_empleado;
    }

    /* set del correo_empleado */
    public void set_correo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    /* get del cargo_empleado */
    public String get_cargo_empleado() {
        return cargo_empleado;
    }

    /* set del cargo_empleado */
    public void set_cargo_empleado(String cargo_empleado) {
        this.cargo_empleado = cargo_empleado;
    }

    /* get del salario_empleado */
    public Double get_salario_empleado() {
        return salario_empleado;
    }

    /* set del salario_empleado */
    public void set_salario_empleado(Double salario_empleado) {
        this.salario_empleado = salario_empleado;
    }

    /* get del imagen_empleado */
    public String get_imagen_empleado() {
        return imagen_empleado;
    }

    /* set del imagen_empleado */
    public void set_imagen_empleado(String imagen_empleado) {
        this.imagen_empleado = imagen_empleado;
    }

    /* get del nombre_trabajo_empleado */
    public String get_nombre_trabajo_empleado() {
        return nombre_trabajo_empleado;
    }

    /* set del nombre_trabajo_empleado */
    public void set_nombre_trabajo_empleado(String nombre_trabajo_empleado) {
        this.nombre_trabajo_empleado = nombre_trabajo_empleado;
    }

    /* get del imagen_trabajo_empleado */
    public String get_imagen_trabajo_empleado() {
        return imagen_trabajo_empleado;
    }

    /* set del imagen_trabajo_empleado */
    public void set_imagen_trabajo_empleado(String imagen_trabajo_empleado) {
        this.imagen_trabajo_empleado = imagen_trabajo_empleado;
    }

    /* get del descripcion_trabajo_empleado */
    public String get_descripcion_trabajo_empleado() {
        return descripcion_trabajo_empleado;
    }

    /* set del descripcion_trabajo_empleado */
    public void set_descripcion_trabajo_empleado(String descripcion_trabajo_empleado) {
        this.descripcion_trabajo_empleado = descripcion_trabajo_empleado;
    }
    
}
