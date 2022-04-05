package minera.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import minera.server.model.Congestion;

public interface CongestionRepository extends CrudRepository<Congestion, Integer> {

    List<Congestion> findByIdPosicion(Integer idPosicion);

    Congestion findFirstByIdCongestion(Integer idCongestion);

}
