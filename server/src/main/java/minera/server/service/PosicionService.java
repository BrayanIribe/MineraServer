package minera.server.service;

import java.util.List;

import minera.server.model.Posicion;
import minera.server.model.Vehiculo;

public interface PosicionService {

    public List<Posicion> find();

    public List<Posicion> findByVehiculo(Vehiculo v);

    public Posicion findFirstById(Integer id) throws Exception;

    public Integer create(Posicion posicion) throws Exception;

    public Boolean update(Posicion posicion) throws Exception;

    public Boolean delete(Integer id) throws Exception;

}
