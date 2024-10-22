package vl.catalogoProductos.model;

//CAPA DE PERSISTENCIA DE DATOS - JPA Y ENTITY

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//Usamos lombok para jakarta para poder usar estas notaciones automáticamente.
@Entity
@Data //Para poder generar los métodos get y set de manera automática
@NoArgsConstructor //Se agrega el constructor vacío
@AllArgsConstructor //Se agrega el constructor con todos los elementos
@ToString // Agregar método toString automáticamente

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProducto; //Llave primaria autoincrementable
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
}
