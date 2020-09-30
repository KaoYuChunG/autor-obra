package com.teste.autor.modules.filtros;

import com.querydsl.core.BooleanBuilder;
import org.springframework.util.StringUtils;

public class ObraPredicate {

//    private QObra obra = QObra.motivoTelefonia;

    private BooleanBuilder builder;

    public ObraPredicate() {
        this.builder = new BooleanBuilder();
    }

    public ObraPredicate(BooleanBuilder builder) {
        this.builder = builder;
    }

    public ObraPredicate comDescricao(String descricao) {
        if (!StringUtils.isEmpty(descricao)) {
//            builder.and(obra.descricao.likeIgnoreCase("%" + descricao + "%"));
        }
        return this;
    }

    public ObraPredicate comNome(String nome) {
        if (!StringUtils.isEmpty(nome)) {
//            builder.and(obra.nome.likeIgnoreCase("%" + nome + "%"));
        }
        return this;
    }

    public BooleanBuilder build() {
        return this.builder;
    }
}
