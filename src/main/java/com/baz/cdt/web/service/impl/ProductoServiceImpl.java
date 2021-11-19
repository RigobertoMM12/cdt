package com.baz.cdt.web.service.impl;

import com.baz.cdt.web.model.Producto;
import com.baz.cdt.web.persistence.ProductoRepository;
import com.baz.cdt.web.persistence.UsuarioRepository;
import com.baz.cdt.web.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAll() {
        return productoRepository.getAll();
    }

    @Override
    public Producto getProductoBySKU(String sku) {
        return productoRepository.getUsuarioBySKU(sku);
    }
    @Override
    public List<Producto> getbyDescripcion(String descripcion) {
        return productoRepository.getUsuarioDescipcion(descripcion);
    }


    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean delete(int idProducto) {
        return  productoRepository.getProducoById(idProducto).map(producto -> {
            productoRepository.delete(producto.getId());
            return true;
        }).orElse(false);
    }
}
