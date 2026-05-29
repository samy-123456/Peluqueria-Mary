/*Samuel Sánchez
Desarrollo de Software
Segundo Nivel
Proyect Mary's BarberShop*/

package com.example.Mary.s.Model;

/*creamos esta clase aparte para poder hacer los enum que son solo 
estados o que solo son datos como una seleccion de ellos para 
y no pueden alterarlos y la base de datos solo aceptara esos datos */

/*
 * colocamos la palabara enum en ves de class para hacer referencia
 * a ese tipo de dato de sql
 */
public enum EstadoCita {
    pendiente,
    confirmada,
    finalizada,
    cancelada
}
