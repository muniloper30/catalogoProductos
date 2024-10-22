package vl.catalogoProductos.servicio;

import vl.catalogoProductos.model.Producto;

import java.util.List;

public interface IProductoServicio {

    public List<Producto> listarProductos(); //Recuperamos todos los objetos de tipo Producto

    public Producto buscarProductoPorId(Integer idProducto);

    public void guardarProducto(Producto producto); //Si es igual a null va a realizar una inserción / Diferente de null actualizará el producto

    public void eliminarProducto(Producto producto);


}
