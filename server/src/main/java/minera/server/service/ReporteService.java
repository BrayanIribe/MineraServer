package minera.server.service;

import java.util.List;

import minera.server.model.Reporte;

public interface ReporteService {

    public List<Reporte> find();

    public Reporte findFirstById(Integer id) throws Exception;

    public Integer create(Reporte reporte) throws Exception;

    public Boolean update(Reporte reporte) throws Exception;

    public Boolean delete(Integer id) throws Exception;
}
