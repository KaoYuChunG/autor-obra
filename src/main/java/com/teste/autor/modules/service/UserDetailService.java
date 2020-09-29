package com.teste.autor.modules.service;

import com.teste.autor.config.UserAuth;
import com.teste.autor.modules.model.auth.Usuario;
import com.teste.autor.modules.repository.auth.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.swing.text.Utilities;
import java.util.Objects;

@Service
public class UserDetailService  implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userNome) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(userNome);

        if(Objects.isNull(userNome)) {
            throw new UsernameNotFoundException("User or password invalid");
        }

        return new UserAuth(usuario);
    }
}
