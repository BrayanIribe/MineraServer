package minera.server.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idPosicion;
    public Integer idVehiculo;
    public Double longitud;
    public Double latitud;
    public Double radio;
    public Date createdAt;
}
