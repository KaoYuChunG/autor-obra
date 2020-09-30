package com.teste.autor.modules.model.app;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "OBRAS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Obra {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_OBRAS", sequenceName = "SEQ_OBRAS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OBRAS")
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
    private LocalDateTime dataPublicacao;

    @NotNull
    @Column(name = "DATA_EXPOSICAO", nullable = false)
    private LocalDateTime dataExposicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_AUTOR", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_AUTOR_OBRA"))
    private Autor autor;
}
