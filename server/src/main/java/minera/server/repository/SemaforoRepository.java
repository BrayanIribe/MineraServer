package minera.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import minera.server.model.Semaforo;

public interface SemaforoRepository extends CrudRepository<Semaforo, Integer> {

    List<Semaforo> findByEstado(String estado);

    Semaforo findFirstByIdSemaforo(Integer idSemaforo);

}
