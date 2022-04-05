package minera.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import minera.server.model.Posicion;

public interface PosicionRepository extends CrudRepository<Posicion, Integer> {

    List<Posicion> findByIdVehiculo(Integer idVehiculo);

    Posicion findFirstByIdPosicion(Integer idPosicion);

}
