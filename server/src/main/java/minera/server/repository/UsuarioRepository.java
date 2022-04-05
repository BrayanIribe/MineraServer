package minera.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import minera.server.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findFirstByUsuario(String usuario);

    Usuario findFirstByIdUsuario(Integer idUsuario);

}
