package minera.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import minera.server.model.Reporte;

public interface ReporteRepository extends CrudRepository<Reporte, Integer> {

    List<Reporte> findByIdVehiculo(Integer idVehiculo);

    List<Reporte> findByTipoMaterial(String tipoMaterial);

    Reporte findFirstByIdReporte(Integer idReporte);

}
