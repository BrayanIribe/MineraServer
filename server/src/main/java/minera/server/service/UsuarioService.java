package minera.server.service;

import java.util.List;

import minera.server.model.Usuario;

public interface UsuarioService {

    public List<Usuario> find();

    public Usuario authenticate(String usuario, String password) throws Exception;

    public Usuario findFirstById(Integer id) throws Exception;

    public Integer create(Usuario usuario) throws Exception;

    public Boolean update(Usuario usuario) throws Exception;

    public Boolean delete(Integer id) throws Exception;

}
