/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "galeria")
public class Galeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private String tipo;           // "imagen", "video", "imagen_trabajo"

    @Column(nullable = false, length = 1000)
    private String urlArchivo;

    @Column(nullable = false)
    private Integer orden = 1;

    private Boolean activo = true;

    /* Relación opcional con empleado (para fotos de sus trabajos) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = true)
    private Empleados empleado;

    // ==================== CONSTRUCTORES ====================
    public Galeria() {}

    public Galeria(String titulo, String descripcion, String tipo, 
                   String urlArchivo, Integer orden) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.urlArchivo = urlArchivo;
        this.orden = orden;
    }

    // ==================== GETTERS Y SETTERS ====================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getUrlArchivo() { return urlArchivo; }
    public void setUrlArchivo(String urlArchivo) { this.urlArchivo = urlArchivo; }

    public Integer getOrden() { return orden; }
    public void setOrden(Integer orden) { this.orden = orden; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public Empleados getEmpleado() { return empleado; }
    public void setEmpleado(Empleados empleado) { this.empleado = empleado; }
}