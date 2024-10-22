package vl.catalogoProductos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vl.catalogoProductos.model.Producto;
import vl.catalogoProductos.repositorio.ProductoRepositorio;

import java.util.List;


@Service //Esta clase es un bean para utilizar en la fábrica de spring



public class ProductoServicio implements IProductoServico{


    @Autowired //Al momento de ejecutar spring de manera automática va agregar una instancia de la clase repositorio
    private ProductoRepositorio productoRepositorio;


    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public void guardarProducto(Producto producto) {
        productoRepositorio.save(producto);  //Si es igual a null va a realizar una inserción / Diferente de null actualizará el producto
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);
    }
}
