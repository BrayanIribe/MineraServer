package minera.server.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idPosicion;
    public Integer idVehiculo;
    public Double longitud;
    public Double latitud;
    public Double radio;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    public Date createdAt;
}
