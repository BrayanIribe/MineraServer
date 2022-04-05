package minera.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minera.server.model.Semaforo;
import minera.server.repository.SemaforoRepository;

@Service
public class SemaforoServiceImpl implements SemaforoService {

    @Autowired
    private SemaforoRepository repository;

    @Override
    public List<Semaforo> find() {
        List<Semaforo> list = new ArrayList<Semaforo>();
        for (Semaforo item : repository.findAll()) {
            list.add(item);
        }
        return list;

    }

    @Override
    public Semaforo findFirstById(Integer id) {
        return repository.findFirstByIdSemaforo(id);
    }

    @Override
    public Integer create(Semaforo semaforo) throws Exception {
        semaforo.idSemaforo = 0;
        Semaforo s = repository.save(semaforo);
        return s.idSemaforo;
    }

    @Override
    public Boolean update(Semaforo semaforo) throws Exception {
        if (!repository.existsById(semaforo.idSemaforo))
            return false;
        repository.save(semaforo);
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
