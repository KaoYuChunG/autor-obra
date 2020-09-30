package com.teste.autor.modules.service;

import com.teste.autor.modules.dto.autor.AutorRequest;
import com.teste.autor.modules.dto.autor.AutorResponse;
import com.teste.autor.modules.filtros.AutorFiltros;
import com.teste.autor.modules.filtros.AutorPredicate;
import com.teste.autor.modules.model.app.Autor;
import com.teste.autor.modules.repository.app.AutorRepository;
import com.vaadin.flow.router.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorResponse sava(AutorRequest request) {
        request.validarPais();
        validaCpf(request.getCpf());
        Autor autor = autorRepository.save(AutorRequest.of(request));
        return  AutorResponse.convertFrom(autor);
    }

    private void validaCpf(String cpf) {
        autorRepository.findAll()
                .forEach(autor -> {
                        if(autor.getCpf().equals(cpf)) {
                            new ValidationException("Esse CPF Já existe.");
                        }
                });
    }

    public Page<AutorResponse> getAll(PageRequest pageRequest, AutorFiltros filtros) {
        Page<Autor> autores = autorRepository.findAll(getPredicate(filtros).build(), pageRequest);
        return new PageImpl<>(
                autores
                    .stream()
                    .map(AutorResponse::convertFrom)
                    .collect(Collectors.toList()),
                pageRequest,
                autores.getTotalElements());
    }

    private AutorPredicate getPredicate(AutorFiltros filtros) {
        AutorPredicate predicate = new AutorPredicate(filtros.toPredicate());
        return predicate;
    }

    public AutorResponse findOne(Integer id) {
        Autor autor = autorRepository.findById(id).orElseThrow(()->
                new NotFoundException("Autor não encontrado.")
        );
        return AutorResponse.convertFrom(autor);
    }

    public void deleteAutor(AutorRequest request) {
        autorRepository.delete(AutorRequest.of(request));
    }

    public Integer update(AutorRequest request) {
        return autorRepository.save(AutorRequest.of(request)).getId();
    }
}
