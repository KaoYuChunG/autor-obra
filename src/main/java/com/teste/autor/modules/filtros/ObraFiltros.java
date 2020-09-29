package com.teste.autor.modules.filtros;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.BooleanBuilder;
import lombok.Data;

@Data
public class ObraFiltros {

    private String nome;
    private String descricao;

    @JsonIgnore
    public BooleanBuilder toPredicate() {
        return new ObraPredicate()
//                .comDescricao(this.descricao)
                .build();
    }
}
