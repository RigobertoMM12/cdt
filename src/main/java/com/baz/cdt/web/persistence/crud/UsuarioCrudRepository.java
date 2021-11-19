package com.baz.cdt.web.persistence.crud;

import com.baz.cdt.web.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioCrudRepository  extends CrudRepository<Usuario, Integer> {
    List<Usuario> findAll();

    Usuario findByNombreOrderById(String nombre);

    Usuario findByUsuarioAndPass(String username,String pass);
}
