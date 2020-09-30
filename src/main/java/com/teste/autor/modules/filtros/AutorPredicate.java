package com.teste.autor.modules.filtros;

import com.querydsl.core.BooleanBuilder;

public class AutorPredicate {

    private BooleanBuilder builder;

    public AutorPredicate() {
        this.builder = new BooleanBuilder();
    }

    public AutorPredicate(BooleanBuilder builder) {
        this.builder = builder;
    }

    public BooleanBuilder build() {
        return this.builder;
    }

    public AutorPredicate porNome(String nome) {
        if (!isEmptyOrNull(nome)) {
//            builder.and(contato.id.eq(nome));
        }
        return this;
    }


    public AutorPredicate porPaisOrigem(String pais) {
        if (!isEmptyOrNull(pais)) {
//            builder.and(contato.id.eq(pais));
        }
        return this;
    }

    public static boolean isEmptyOrNull(Object object) {
        return object == null || object.toString().trim().equals("") || object.toString().trim().equals("null");
    }
}
