package vl.catalogoProductos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import vl.catalogoProductos.model.Producto;

//SPRING DATA
//Poder interactuar con la base de datos y tener acceso a los métodos para modificar,actualizar o eliminar
public interface ProductoRepositorio extends JpaRepository <Producto, Integer> {
}
