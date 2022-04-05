package minera.server.service;

import java.util.List;

import minera.server.model.Vehiculo;

public interface VehiculoService {

    public List<Vehiculo> find();

    public Vehiculo findFirstById(Integer id) throws Exception;

    public Vehiculo findFirstByMatricula(String matricula) throws Exception;

    public Integer create(Vehiculo usuario) throws Exception;

    public Boolean update(Vehiculo usuario) throws Exception;

    public Boolean delete(Integer id) throws Exception;

}
