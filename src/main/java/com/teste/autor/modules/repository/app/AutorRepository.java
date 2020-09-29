package com.teste.autor.modules.repository.app;

import com.teste.autor.modules.model.app.Autor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AutorRepository extends PagingAndSortingRepository<Autor, Integer> {
}
