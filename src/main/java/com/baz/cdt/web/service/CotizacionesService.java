package com.baz.cdt.web.service;

import com.baz.cdt.web.model.Cotizacion;

import java.util.List;

public interface CotizacionesService {
    Cotizacion save(Cotizacion cotizacion);
    List<Cotizacion> getAll();
}
