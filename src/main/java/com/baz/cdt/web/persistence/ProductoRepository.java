package com.baz.cdt.web.persistence;

import com.baz.cdt.web.model.Producto;
import com.baz.cdt.web.model.Usuario;
import com.baz.cdt.web.persistence.crud.ProductoCrudRepository;
import com.baz.cdt.web.persistence.crud.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return productoCrudRepository.findAll();
    }
    public Producto getUsuarioBySKU(String sku ) {
        return productoCrudRepository.findBySku(sku);
    }

    public List<Producto> getUsuarioDescipcion(String descipcion ) {
        return productoCrudRepository.findAllByDescripcionLike("%"+descipcion+"%");
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }
    public Optional<Producto> getProducoById(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }


}
