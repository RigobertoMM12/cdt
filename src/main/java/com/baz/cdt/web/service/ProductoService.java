package com.baz.cdt.web.service;

import com.baz.cdt.web.model.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getAll();
    Producto getProductoBySKU(String sku);
    Producto getProductoById(int id);
    List<Producto> getbyDescripcion(String descipcion);
    Producto save(Producto producto);
    boolean delete(int idProducto);
}
