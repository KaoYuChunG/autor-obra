package com.teste.autor.modules.model.auth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Id;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Perfil implements GrantedAuthority {

    @Id
    private String id;

    private String nome;

    @Override
    public String getAuthority() {
        return nome;
    }
}
