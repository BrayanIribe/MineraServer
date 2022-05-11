package minera.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import minera.server.model.Usuario;
import minera.server.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> find() {
        List<Usuario> list = new ArrayList<Usuario>();
        for (Usuario item : repository.findAll()) {
            list.add(item);
        }
        return list;

    }

    @Override
    public Boolean authenticate(String usuario, String password) {
        try {
            Usuario row = repository.findFirstByUsuario(usuario);
            return row != null && row.password.equals(password);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuario findFirstById(Integer id) {
        return repository.findFirstByIdUsuario(id);
    }

    @Override
    public Integer create(Usuario usuario) throws Exception {
        usuario.idUsuario = 0;
        Usuario s = repository.save(usuario);
        return s.idUsuario;
    }

    @Override
    public Boolean update(Usuario usuario) throws Exception {
        if (!repository.existsById(usuario.idUsuario))
            return false;
        repository.save(usuario);
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
