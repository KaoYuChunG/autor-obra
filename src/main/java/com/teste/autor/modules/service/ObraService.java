package com.teste.autor.modules.service;

import com.teste.autor.modules.dto.autor.AutorRequest;
import com.teste.autor.modules.dto.autor.AutorResponse;
import com.teste.autor.modules.dto.obra.ObraRequest;
import com.teste.autor.modules.dto.obra.ObraResponse;
import com.teste.autor.modules.filtros.AutorFiltros;
import com.teste.autor.modules.filtros.AutorPredicate;
import com.teste.autor.modules.filtros.ObraFiltros;
import com.teste.autor.modules.filtros.ObraPredicate;
import com.teste.autor.modules.model.app.Autor;
import com.teste.autor.modules.model.app.Obra;
import com.teste.autor.modules.repository.app.AutorRepository;
import com.teste.autor.modules.repository.app.ObraRepository;
import com.vaadin.flow.router.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    public ObraResponse sava(ObraRequest request) {
        Obra obra = obraRepository.save(ObraRequest.of(request));
        return ObraResponse.convertFrom(obra);
    }

    public Page<ObraResponse> getAll(PageRequest pageRequest, ObraFiltros filtros) {
        Page<Obra> obras = obraRepository.findAll(getPredicate(filtros).build(), pageRequest);
        return new PageImpl<>(
                obras
                        .stream()
                        .map(ObraResponse::convertFrom)
                        .collect(Collectors.toList()),
                pageRequest,
                obras.getTotalElements());
    }

    private ObraPredicate getPredicate(ObraFiltros filtros) {
        ObraPredicate predicate = new ObraPredicate(filtros.toPredicate());
        return predicate;
    }

    public ObraResponse findOne(Integer id) {
        Obra obra = obraRepository.findById(id).orElseThrow(()->
                new NotFoundException("Obra não encontrado.")
        );
        return ObraResponse.convertFrom(obra);
    }

    public Integer update(ObraRequest request) {
        return obraRepository.save(ObraRequest.of(request)).getId();
    }

    public void deleteAutor(ObraRequest request) {
        obraRepository.delete(ObraRequest.of(request));
    }
}
