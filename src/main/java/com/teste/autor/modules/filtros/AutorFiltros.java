package com.teste.autor.modules.filtros;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.BooleanBuilder;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AutorFiltros {

    private String nome;
    private String paisOrigem;

    @JsonIgnore
    public BooleanBuilder toPredicate() {
        return new AutorPredicate()
                    .porNome(this.nome)
                    .porPaisOrigem(this.paisOrigem)
                    .build();
    }
}
