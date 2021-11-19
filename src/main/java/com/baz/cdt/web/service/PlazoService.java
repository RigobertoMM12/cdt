package com.baz.cdt.web.service;

import com.baz.cdt.web.model.Plazo;
import com.baz.cdt.web.model.Producto;

import java.util.List;

public interface PlazoService {
    List<Plazo> getAll();
    List<Plazo> getByProduct(int  idProducto);
    Plazo save(Plazo plazo);
    boolean delete(int idPlazo);
}
