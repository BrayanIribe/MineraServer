package minera.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minera.server.model.Reporte;
import minera.server.repository.ReporteRepository;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private ReporteRepository repository;

    @Override
    public List<Reporte> find() {
        List<Reporte> list = new ArrayList<Reporte>();
        for (Reporte item : repository.findAll()) {
            list.add(item);
        }
        return list;

    }

    @Override
    public Reporte findFirstById(Integer id) {
        return repository.findFirstByIdReporte(id);
    }

    @Override
    public Integer create(Reporte reporte) throws Exception {
        reporte.idReporte = 0;
        Reporte s = repository.save(reporte);
        return s.idReporte;
    }

    @Override
    public Boolean update(Reporte reporte) throws Exception {
        if (!repository.existsById(reporte.idReporte))
            return false;
        repository.save(reporte);
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
