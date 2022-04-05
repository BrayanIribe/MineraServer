package minera.server.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idVehiculo;

    public String nombre;

    @Column(unique = true, nullable = false)
    public String matricula;

    @Column(nullable = true)
    public Integer idPosicion;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    public Date createdAt;
}
