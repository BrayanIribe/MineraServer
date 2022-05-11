package minera.server.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idVehiculo;

    public String nombre;

    @Column(unique = true, nullable = false)
    public String matricula;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    public Date createdAt;
}
