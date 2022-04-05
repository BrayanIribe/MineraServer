package minera.server.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Congestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idCongestion;
    public Integer idPosicion;
    public Date fecha;
    public String horaInicio;
    public String horaFin;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    public Date createdAt;
}
