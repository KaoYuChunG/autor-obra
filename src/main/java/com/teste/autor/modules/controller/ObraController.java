package com.teste.autor.modules.controller;

import com.teste.autor.modules.dto.autor.AutorRequest;
import com.teste.autor.modules.dto.autor.AutorResponse;
import com.teste.autor.modules.dto.obra.ObraRequest;
import com.teste.autor.modules.dto.obra.ObraResponse;
import com.teste.autor.modules.filtros.ObraFiltros;
import com.teste.autor.modules.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/obra")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @GetMapping
    public Page<ObraResponse> getObras(PageRequest pageRequest, @Validated ObraFiltros filtros) {
        return obraService.getAll(pageRequest,filtros);
    }

    @PostMapping
    public ObraResponse save(@RequestBody ObraRequest request) {
        return obraService.sava(request);
    }

    @GetMapping("{id}")
    public ObraResponse getObraById(@PathVariable("id") Integer id) {
        return obraService.findOne(id);
    }

    @PutMapping
    public Integer update(@RequestBody @Validated ObraRequest request) {
        return obraService.update(request);
    }

    @DeleteMapping
    public void deleteObra(@RequestBody ObraRequest request) {
        obraService.deleteAutor(request);
    }
}
