package com.baz.cdt.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "plazo")
public class Plazo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plazo_id")
    private Integer id;

    @Column(name = "periodo_id")
    private Integer periodoId;


    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "num_plazo")
    private Integer numPlazo;

    @Column(name = "tasa_normal")
    private Double tasaNormal;


    @Column(name = "tasa_puntal")
    private Double tasaPuntual;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "status")
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(Integer periodoId) {
        this.periodoId = periodoId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getNumPlazo() {
        return numPlazo;
    }

    public void setNumPlazo(Integer numPlazo) {
        this.numPlazo = numPlazo;
    }

    public Double getTasaNormal() {
        return tasaNormal;
    }

    public void setTasaNormal(Double tasaNormal) {
        this.tasaNormal = tasaNormal;
    }

    public Double getTasaPuntual() {
        return tasaPuntual;
    }

    public void setTasaPuntual(Double tasaPuntual) {
        this.tasaPuntual = tasaPuntual;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
