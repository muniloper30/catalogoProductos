package vl.catalogoProductos.controlador;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

}
