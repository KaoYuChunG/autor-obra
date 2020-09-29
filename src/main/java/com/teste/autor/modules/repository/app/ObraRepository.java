package com.teste.autor.modules.repository.app;

import com.teste.autor.modules.model.app.Obra;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ObraRepository extends PagingAndSortingRepository<Obra, Integer> {
}
