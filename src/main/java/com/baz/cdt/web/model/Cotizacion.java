package com.baz.cdt.web.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cotizacion_id")
    private Integer id;
    @Column(name = "plazo_id")
    private Integer plazoId;
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "nombre_cotizacion")
    private String nombreCotizacion  ;


    @Column(name = "abono_normal")
    private Double abonoNormal;

    @Column(name = "abono_puntual")
    private Double abonoPuntual;


    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "status")
    private boolean status;

    @Column(name = "product_id")
    private Integer productoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlazoId() {
        return plazoId;
    }

    public void setPlazoId(Integer plazoId) {
        this.plazoId = plazoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCotizacion() {
        return nombreCotizacion;
    }

    public void setNombreCotizacion(String nombreCotizacion) {
        this.nombreCotizacion = nombreCotizacion;
    }

    public Double getAbonoNormal() {
        return abonoNormal;
    }

    public void setAbonoNormal(Double abonoNormal) {
        this.abonoNormal = abonoNormal;
    }

    public Double getAbonoPuntual() {
        return abonoPuntual;
    }

    public void setAbonoPuntual(Double abonoPuntual) {
        this.abonoPuntual = abonoPuntual;
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

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
