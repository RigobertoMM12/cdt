package com.baz.cdt.web.persistence.crud;

import com.baz.cdt.web.model.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotizacionCrudRepository extends JpaRepository<Cotizacion,Integer> {
}
