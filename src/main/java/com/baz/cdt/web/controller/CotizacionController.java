package com.baz.cdt.web.controller;

import com.baz.cdt.web.model.Cotizacion;
import com.baz.cdt.web.model.Plazo;
import com.baz.cdt.web.model.Usuario;
import com.baz.cdt.web.service.impl.CotizacionServiceImpl;
import com.baz.cdt.web.service.impl.UsuariosServiceImpl;
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
@RequestMapping("/cotizacion")
public class CotizacionController {

    @Autowired
    private CotizacionServiceImpl cotizacionService;


    @PostMapping("/")
    public ResponseEntity<?> createProducto(@RequestBody Cotizacion cotizacion){
        cotizacion.setStatus(true);
        LocalDateTime now = LocalDateTime.now();
        cotizacion.setFechaCreacion(now);

        try {
            return  new ResponseEntity<>(cotizacionService.save(cotizacion), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>( HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/")
    @ApiOperation("Consultar todos las cotizaciones")
    @ApiResponses({
            @ApiResponse(code = 200,message = "Ok"),
            @ApiResponse(code = 500,message = "Not Found")
    })
    public ResponseEntity<List<Cotizacion>> getAll(){
        return  new ResponseEntity<>(cotizacionService.getAll(), HttpStatus.OK);
    }

}
