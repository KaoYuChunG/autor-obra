package com.teste.autor.modules.model.app;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "OBRA")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Obra {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_OBRA", sequenceName = "SEQ_OBRA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OBRA")
    private Integer id;

    @NotNull
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotNull
    @Size(max = 240)
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "IMAGEM", nullable = false)
    private String imagem;

    @NotNull
    @Column(name = "DATA_PUBLICACAO", nullable = false)
    private String dataPublicacao;

    @NotNull
    @Column(name = "DATA_EXPOSICAO", nullable = false)
    private String dataExposicao;
}
