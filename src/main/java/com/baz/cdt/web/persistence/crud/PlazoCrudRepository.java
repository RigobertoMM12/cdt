package com.baz.cdt.web.persistence.crud;

import com.baz.cdt.web.model.Plazo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlazoCrudRepository extends CrudRepository<Plazo,Integer> {
    List<Plazo> findAll();
    List<Plazo> findAllByProductoId(int productoId);
}
