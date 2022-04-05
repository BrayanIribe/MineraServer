package minera.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minera.server.model.Posicion;
import minera.server.model.Vehiculo;
import minera.server.repository.PosicionRepository;

@Service
public class PosicionServiceImpl implements PosicionService {

    @Autowired
    private PosicionRepository repository;

    @Override
    public List<Posicion> find() {
        List<Posicion> list = new ArrayList<Posicion>();
        for (Posicion item : repository.findAll()) {
            list.add(item);
        }
        return list;

    }

    @Override
    public List<Posicion> findByVehiculo(Vehiculo v) {
        List<Posicion> list = new ArrayList<Posicion>();
        for (Posicion item : repository.findByIdVehiculo(v.idVehiculo)) {
            list.add(item);
        }
        return list;

    }

    @Override
    public Posicion findFirstById(Integer id) {
        return repository.findFirstByIdPosicion(id);
    }

    @Override
    public Integer create(Posicion posicion) throws Exception {
        posicion.idPosicion = 0;
        Posicion s = repository.save(posicion);
        return s.idPosicion;
    }

    @Override
    public Boolean update(Posicion posicion) throws Exception {
        if (!repository.existsById(posicion.idPosicion))
            return false;
        repository.save(posicion);
        return true;
    }

    @Override
    public Boolean delete(Integer id) throws Exception {
        if (!repository.existsById(id))
            return false;
        repository.deleteById(id);
        return true;
    }
}
