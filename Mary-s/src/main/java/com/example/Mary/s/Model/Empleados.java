/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*importamos las librerias necesarias que vamos a usar */
import jakarta.persistence.*;

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
    @Column(nullable=false)
    private String nombre_empleado;
    @Column(nullable = false )
    private String  Apellido_empleado;
    @Column(nullable=false)
    private String Correo_empleado;
    @Column(nullable=false)
    private String Cargo_empleado;
    @Column(nullable=false)
    private Double Salario_empleado;
     @Column(nullable=false , length=15)
   private String Telefono_empleado;
/* se crea el constructor vacio */
public Empleados(){

}
/* constructor con parametros*/
public Empleados (String nombre_empleado,String Apellido_empleado,String Correo_empleado,String Cargo_empleado,Double Salario_empleado,String Telefono_empleado){
    this.nombre_empleado=nombre_empleado;
    this.Apellido_empleado=Apellido_empleado;
    this.Correo_empleado=Correo_empleado;
    this.Cargo_empleado=Cargo_empleado;
    this.Salario_empleado=Salario_empleado;
    this.Telefono_empleado=Telefono_empleado;
}

/* creacion de los metodos get  y set  de los parametros*/
public Long getId_empleado() {
    return id_empleado;


}
/* set id empleado*/
public void setId_empleado(Long id_empleado) {
  this.id_empleado = id_empleado;
}
/*get nombre empleado*/
public String getNombre_empleado(){
  return nombre_empleado;

}
/*set nombre empleado*/
public void setNombre_empleado(String nombre_empleado){
  this.nombre_empleado=nombre_empleado;
}
/* get apellido empleado*/
public String getApellido_empleado(){
return Apellido_empleado;
}
/*set apellido empledo*/
public void setApellido_empleado(String Apellido_empleado){
  this.Apellido_empleado=Apellido_empleado;
}
/* get correo empleado */
public String getCorreo_empledo(){
  return  Correo_empleado;
}
/*set correo empleado*/
public void setCorreo_empledo(String Correo_empledo){
  this.Correo_empleado=Correo_empledo;
}
/* get cargo empleado */
public String getCargo_empleado(){
  return Cargo_empleado;
}
/* set cargo mpledo*/
public void setCargo_empleado(String Cargo_empleado){
  this.Cargo_empleado=Cargo_empleado;
}
/* get salario empleado*/
public Double getSalario_empleado(){
  return Salario_empleado;
}
/* set salario empleado*/
public void setSalario_empleado(Double Salario_empleado){
  this.Salario_empleado=Salario_empleado;
}
/* get telefono empledo*/
public String getTelefono_empleado(){
  return Telefono_empleado;
}
/* set telefono empleado*/
public void setTelefono_empleado(String Telefono_empleado){
  this.Telefono_empleado=Telefono_empleado;

}

}
