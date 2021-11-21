package com.baz.cdt.web.persistence;

import com.baz.cdt.web.model.Cotizacion;
import com.baz.cdt.web.model.Plazo;
import com.baz.cdt.web.persistence.crud.CotizacionCrudRepository;
import com.baz.cdt.web.persistence.crud.PlazoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CotizacionRepository {
    @Autowired
    private CotizacionCrudRepository cotizacionCrudRepository;


    public Cotizacion save(Cotizacion cotizacion) {
        return cotizacionCrudRepository.save(cotizacion);
    }
    public List<Cotizacion> getAll() {
        return cotizacionCrudRepository.findAll();
    }
}
