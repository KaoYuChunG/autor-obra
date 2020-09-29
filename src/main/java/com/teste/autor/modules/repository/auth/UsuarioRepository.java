package com.teste.autor.modules.repository.auth;

import com.teste.autor.modules.model.auth.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    public Usuario findByEmail(String userNome);
}
