package com.baz.cdt.web.persistence;

import com.baz.cdt.web.model.Plazo;
import com.baz.cdt.web.model.Producto;
import com.baz.cdt.web.model.Usuario;
import com.baz.cdt.web.persistence.crud.PlazoCrudRepository;
import com.baz.cdt.web.persistence.crud.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlazoRepository {

    @Autowired
    private PlazoCrudRepository plazoCrudRepository;
    //@Query(value = "SELECT * FROM Plazo WHERE id_plazo  = ?  ",nativeQuery = true)
    public List<Plazo> getAll() {
        return plazoCrudRepository.findAll();
    }
    public List<Plazo> getByProduct(int idProducto) {
        return plazoCrudRepository.findAllByProductoId(idProducto);
    }
    public Optional<Plazo> getPlazoById(int idPlazo) {
        return plazoCrudRepository.findById(idPlazo);
    }
    public Plazo save(Plazo plazo) {
        return plazoCrudRepository.save(plazo);
    }
    public void delete(int idUser) {
        plazoCrudRepository.deleteById(idUser);
    }


}
