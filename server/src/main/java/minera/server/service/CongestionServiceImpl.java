package minera.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minera.server.model.Congestion;
import minera.server.repository.CongestionRepository;

@Service
public class CongestionServiceImpl implements CongestionService {

    @Autowired
    private CongestionRepository repository;

    @Override
    public List<Congestion> find() {
        List<Congestion> list = new ArrayList<Congestion>();
        for (Congestion item : repository.findAll()) {
            list.add(item);
        }
        return list;

    }

    @Override
    public Congestion findFirstById(Integer id) {
        return repository.findFirstByIdCongestion(id);
    }

    @Override
    public Integer create(Congestion congestion) throws Exception {
        congestion.idCongestion = 0;
        Congestion s = repository.save(congestion);
        return s.idCongestion;
    }

    @Override
    public Boolean update(Congestion congestion) throws Exception {
        if (!repository.existsById(congestion.idCongestion))
            return false;
        repository.save(congestion);
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
