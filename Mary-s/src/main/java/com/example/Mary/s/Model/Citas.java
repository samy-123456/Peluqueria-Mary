/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

import java.time.LocalDate;

import jakarta.persistence.*;
@Entity
@Table(name="citas")
public class Citas {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id_cita;
   @Column(nullable=false)
   //LocalDate:decir cada vez que hacemos una modificación se genera un nuevo objeto con los cambios realizados.
   private LocalDate fecha_cita;

    
}
