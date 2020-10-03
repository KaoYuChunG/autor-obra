package com.teste.autor.modules.model.app;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "AUTORES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_AUTORES", sequenceName = "SEQ_AUTORES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTORES")
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
    private LocalDateTime dataNascimento;

    @NotNull
    @Column(name = "PAIS_ORIGEM", nullable = false)
    private String paisOrigem;

    @Column(name = "CPF")
    private String cpf;

}
