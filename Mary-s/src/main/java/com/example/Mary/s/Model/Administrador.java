package com.example.Mary.s.Model;

import jakarta.persistence.*;
@Entity
@Table(name="administrador")
public class Administrador{
    @Id         
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_administrador;
    @Column(nullable = false )
    private String  Nombre_administrador;
    @Column(nullable=false)
    private String Apellido_administrador;
    @Column(nullable=false)
    private String Correo_administrador;
     @Column(nullable=false , length=15)
    private String Telefono_administrador;

    public Administrador(){

    }
 
    public Administrador(String Nombre_administrador, String Apellido_administrador,String Correo_administrador,String Telefono_administrador){
    this.Nombre_administrador=Nombre_administrador;
    this.Apellido_administrador= Apellido_administrador;
    this.Correo_administrador=Correo_administrador;
    this.Telefono_administrador=Telefono_administrador;
    }
    public Long get_id_Administrador(){
        return id_administrador;
    }
     public void set_id_Administrador(Long id_administrador){
        this.id_administrador = id_administrador;
    }
public String get_Nombre_administrador(){
        return Nombre_administrador;
    }

    public void set_Nombre_administrador(String Nombre_administrador) {
        this.Nombre_administrador = Nombre_administrador;
    }
    public String get_Apellido_administrador(){
        return Apellido_administrador;
    }

    public void set_Apellido_administrador(String Apellido_administrador) {
        this.Apellido_administrador = Apellido_administrador;
    }
     public String get_Correo_administrador(){
        return Apellido_administrador;
    }

    public void set_Correo_administrador(String Correo_administrador) {
        this.Correo_administrador= Correo_administrador;
    }
public String get_Telefono_administrador(){
        return Apellido_administrador;
    }

    public void set_Telefono_administrador(String Telefono_administrador) {
        this.Telefono_administrador= Telefono_administrador;
    }

}