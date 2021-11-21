package com.baz.cdt.web.controller;

import com.baz.cdt.web.model.Producto;
import com.baz.cdt.web.model.Usuario;
import com.baz.cdt.web.service.ProductoService;
import com.baz.cdt.web.service.impl.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> getAll(){
        return  new ResponseEntity<>(productoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/bySKU/{sku}")
    public ResponseEntity<?> getbySku(@PathVariable("sku") String sku){
        Producto producto= productoService.getProductoBySKU(sku);
        if(producto == null){
            return  new ResponseEntity<>("Registro no encontrado", HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(producto, HttpStatus.OK);
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getbySku(@PathVariable("id") int id){
        Producto producto= productoService.getProductoById(id);
        if(producto == null){
            return  new ResponseEntity<>("Registro no encontrado", HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(producto, HttpStatus.OK);
    }
    @GetMapping("/byDescripcion/{descripcion}")
    public ResponseEntity<?> getbyDescripcion(@PathVariable("descripcion") String descripcion){
        return  new ResponseEntity<>(productoService.getbyDescripcion(descripcion), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProducto(@RequestBody Producto producto){
        producto.setStatus(true);
        LocalDateTime now = LocalDateTime.now();
        producto.setFechaCreacion(now);
        try {
            return  new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>( HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{idProducto}")
    public ResponseEntity<?> deleteUser(@PathVariable("idProducto") int idProducto){
        if(productoService.delete(idProducto)){
            return  new ResponseEntity(HttpStatus.OK);
        }else
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
    }



}
