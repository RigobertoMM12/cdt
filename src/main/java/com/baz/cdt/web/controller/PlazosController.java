package com.baz.cdt.web.controller;

import com.baz.cdt.web.model.Plazo;
import com.baz.cdt.web.model.Producto;
import com.baz.cdt.web.service.PlazoService;
import com.baz.cdt.web.service.ProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/plazo")
public class PlazosController {
    @Autowired
    private PlazoService plazoService;

    @GetMapping("/")
    @ApiOperation("Consultar todos los plazos registrados")
    @ApiResponses({
            @ApiResponse(code = 200,message = "Ok"),
            @ApiResponse(code = 500,message = "Not Found")
    })
    public ResponseEntity<List<Plazo>> getAll(){
        return  new ResponseEntity<>(plazoService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/byProducto/{idProducto}")
    public ResponseEntity<List<Plazo>> getByProduct(@PathVariable("idProducto") int idProducto){
        return  new ResponseEntity<>(plazoService.getByProduct(idProducto), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> createProducto(@RequestBody Plazo plazo){
        plazo.setStatus(true);
        LocalDateTime now = LocalDateTime.now();
        plazo.setFechaCreacion(now);

        try {
            return  new ResponseEntity<>(plazoService.save(plazo), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>( HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{idPlazo}")
    public ResponseEntity<?> deleteUser(@PathVariable("idPlazo") int idPlazo){
        if(plazoService.delete(idPlazo)){
            return  new ResponseEntity(HttpStatus.OK);
        }else
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
