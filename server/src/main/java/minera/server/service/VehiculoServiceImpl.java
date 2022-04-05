package minera.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minera.server.model.Vehiculo;
import minera.server.repository.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository repository;

    @Override
    public List<Vehiculo> find() {
        List<Vehiculo> list = new ArrayList<Vehiculo>();
        for (Vehiculo item : repository.findAll()) {
            list.add(item);
        }
        return list;

    }

    @Override
    public Vehiculo findFirstById(Integer id) {
        return repository.findFirstByIdVehiculo(id);
    }

    @Override
    public Integer create(Vehiculo vehiculo) throws Exception {
        vehiculo.idVehiculo = 0;
        Vehiculo s = repository.save(vehiculo);
        return s.idVehiculo;
    }

    @Override
    public Boolean update(Vehiculo vehiculo) throws Exception {
        if (!repository.existsById(vehiculo.idVehiculo))
            return false;
        repository.save(vehiculo);
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
