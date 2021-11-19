package com.baz.cdt.web.service;

import com.baz.cdt.web.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsuariosService {
    List<Usuario> getAll();
    Usuario getUsuarioByName(String name);
    Usuario getAuthenticate(String name,String pass);
    Usuario save(Usuario usuario);
    boolean delete(int idUsuario);
}
