package com.teste.autor.modules.model.app;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "AUTOR")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_AUTOR", sequenceName = "SEQ_AUTOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AUTOR")
    private Integer id;

    @NotNull
    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SEXO")
    private String sexo;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private String dataNascimento;

    @NotNull
    @Column(name = "PAIS_ORIGEM", nullable = false)
    private String paisOrigem;

    @Column(name = "CPF")
    private String cpf;
}
