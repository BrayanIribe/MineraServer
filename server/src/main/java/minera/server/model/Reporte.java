package minera.server.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idReporte;
    public Integer idVehiculo;
    public String tipoMaterial;
    public Double cantidadMaterial;
    public Date fecha;
}
