package com.teste.autor.modules.repository.app;

import com.querydsl.core.types.Predicate;
import com.teste.autor.modules.model.app.Obra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ObraRepositoryCustom {

    Page<Obra> findAll(Predicate predicate, Pageable pageable);
}
