package com.teste.autor.modules.model.auth;

import lombok.*;

import javax.persistence.Id;
import java.util.List;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private String id;

    private String nome;

    private List<Perfil> perfils;

    private Integer idade;

    private String email;

    private String senha;

    public Usuario(Usuario user) {
    }
}
