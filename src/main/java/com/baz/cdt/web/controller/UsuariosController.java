package com.baz.cdt.web.controller;

import com.baz.cdt.web.model.Usuario;
import com.baz.cdt.web.service.UsuariosService;
import com.baz.cdt.web.service.impl.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosServiceImpl usuariosService;


    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getAll(){
        return  new ResponseEntity<>(usuariosService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<?> getbyName(@PathVariable("name") String name){
        Usuario user= usuariosService.getUsuarioByName(name);
    if(user == null){
        return  new ResponseEntity<>("Registro no encontrado", HttpStatus.NO_CONTENT);
    }
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("/authenticate/{username}/{pass}")
    public ResponseEntity<?> getAuthenticate(@PathVariable("username") String username,@PathVariable("pass") String pass){
        Usuario user=usuariosService.getAuthenticate(username,pass);
        if(user == null){
            return  new ResponseEntity<>("Registro no encontrado", HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody Usuario user){
        user.setStatus(true);
        LocalDateTime now = LocalDateTime.now();
        user.setFechaCreacion(now);
        try {
            return  new ResponseEntity<>(usuariosService.save(user), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>( HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<?> deleteUser(@PathVariable("idUser") int idUser){
        if(usuariosService.delete(idUser)){
            return  new ResponseEntity(HttpStatus.OK);
        }else
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
