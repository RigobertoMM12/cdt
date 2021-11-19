package com.baz.cdt.web.service.impl;

import com.baz.cdt.web.model.Usuario;
import com.baz.cdt.web.persistence.UsuarioRepository;
import com.baz.cdt.web.service.UsuariosService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.getAll();
    }

    @Override
    public Usuario getUsuarioByName(String name) {
        return usuarioRepository.getUsuarioByName(name);
    }

    @Override
    public Usuario getAuthenticate(String username, String pass) {
        return usuarioRepository.getAutenticateuser(username,pass);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean delete(int idUsuario) {
        return  usuarioRepository.getUserById( idUsuario).map(usuario -> {
            usuarioRepository.delete(usuario.getId());
            return true;
        }).orElse(false);
    }


}
