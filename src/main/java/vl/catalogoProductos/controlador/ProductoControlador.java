package vl.catalogoProductos.controlador;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vl.catalogoProductos.model.Producto;
import vl.catalogoProductos.servicio.ProductoServicio;

import java.util.List;

@Controller //De esta manera se usará como controlador de spring
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);//Enviamos información desde la calse ProductoControlador (enviar información de logs de nuestra app a la consola)


    @Autowired
    ProductoServicio productoServicio; //De esta forma tenemos acceso con el servicio y la base de datos

    @GetMapping("/") //Procesamos la url que queremos procesar
    public String iniciar(ModelMap model){
        List<Producto> productos = productoServicio.listarProductos();
        productos.forEach((producto) -> logger.info(producto.toString()));
        model.put("productos", productos);
        return "index"; //index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar"; //agregar.html
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("productForm") Producto producto){
        logger.info("Producto a agregar: " + producto);
        productoServicio.guardarProducto(producto);
        return "redirect:/"; //Redirigimos al controlador el path "/"
    }

    @GetMapping("/editar/{id}")  //VAMOS A EDITAR EL PRODUCTO
    public String mostrarEditar(@PathVariable(value = "id") int idProducto,
                                ModelMap model){
        Producto producto = productoServicio.buscarProductoPorId(idProducto);
        logger.info("Producto a editar (mostrar): " + producto);
        model.put("producto", producto);
        return "editar"; //editar.html
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("producto") Producto producto){
        logger.info("Producto a editar: " + producto);
        productoServicio.guardarProducto(producto);
        return "redirect:/"; //Redirigimos al controlador el path "/"
    }

}
