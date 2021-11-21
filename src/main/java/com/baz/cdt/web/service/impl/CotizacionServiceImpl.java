package com.baz.cdt.web.service.impl;

import com.baz.cdt.web.model.Cotizacion;
import com.baz.cdt.web.persistence.CotizacionRepository;
import com.baz.cdt.web.service.CotizacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotizacionServiceImpl implements CotizacionesService {
    @Autowired
    private CotizacionRepository cotizacionRepository;

    @Override
    public Cotizacion save(Cotizacion cotizacion) {
        return cotizacionRepository.save(cotizacion);
    }

    @Override
    public List<Cotizacion> getAll() {
        return cotizacionRepository.getAll();
    }
}
