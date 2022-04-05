package minera.server.service;

import java.util.List;

import minera.server.model.Semaforo;

public interface SemaforoService {

    public List<Semaforo> find();

    public Semaforo findFirstById(Integer id) throws Exception;

    public Integer create(Semaforo semaforo) throws Exception;

    public Boolean update(Semaforo semaforo) throws Exception;

    public Boolean delete(Integer id) throws Exception;

}
