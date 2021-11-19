package com.baz.cdt.web.persistence.crud;

import com.baz.cdt.web.model.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
    List<Producto> findAll();
    Producto findBySku(String sku);
    List<Producto> findAllByDescripcionLike(String descipcion);
}
