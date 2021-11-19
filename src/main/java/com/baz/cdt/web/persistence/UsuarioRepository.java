package com.baz.cdt.web.persistence;

import com.baz.cdt.web.model.Usuario;
import com.baz.cdt.web.persistence.crud.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;


    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    public Usuario getUsuarioByName(String name ) {
        return usuarioCrudRepository.findByNombreOrderById(name);
    }
    public Usuario getAutenticateuser(String username ,String pass) {
        return usuarioCrudRepository.findByUsuarioAndPass(username,pass);
    }
    public Usuario save(Usuario usuario) {
        return usuarioCrudRepository.save(usuario);
    }
    public void delete(int idUser) {
        usuarioCrudRepository.deleteById(idUser);
    }
    public Optional<Usuario> getUserById(int idUser) {
        return usuarioCrudRepository.findById(idUser);
    }
}
