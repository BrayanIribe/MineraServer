package minera.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import minera.server.model.Vehiculo;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {

    List<Vehiculo> findByIdVehiculo(Integer idVehiculo);

    Vehiculo findFirstByIdVehiculo(Integer idVehiculo);

}
