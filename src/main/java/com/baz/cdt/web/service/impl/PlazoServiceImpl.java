package com.baz.cdt.web.service.impl;

import com.baz.cdt.web.model.Plazo;
import com.baz.cdt.web.persistence.PlazoRepository;
import com.baz.cdt.web.persistence.ProductoRepository;
import com.baz.cdt.web.service.PlazoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlazoServiceImpl implements PlazoService {

    @Autowired
    private PlazoRepository plazoRepository;
    @Override
    public List<Plazo> getAll() {
        return plazoRepository.getAll();
    }

    @Override
    public List<Plazo> getByProduct(int idProducto) {
        return plazoRepository.getByProduct(idProducto);
    }

    @Override
    public Plazo save(Plazo plazo) {
        return plazoRepository.save(plazo);
    }

    @Override
    public boolean delete(int idPlazo) {
        return  plazoRepository.getPlazoById(idPlazo).map(plazo -> {
            plazoRepository.delete(plazo.getId());
            return true;
        }).orElse(false);
    }
}
