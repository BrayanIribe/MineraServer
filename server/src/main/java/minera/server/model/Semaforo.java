package minera.server.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Semaforo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idSemaforo;
    public Double longitud;
    public Double latitud;
    public Double radio;
    public String estado;
    public Float duracion;
}
