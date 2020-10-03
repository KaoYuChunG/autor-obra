package com.teste.autor.modules.controller;

import com.teste.autor.modules.dto.autor.AutorRequest;
import com.teste.autor.modules.dto.autor.AutorResponse;
import com.teste.autor.modules.dto.obra.ObraResponse;
import com.teste.autor.modules.filtros.AutorFiltros;
import com.teste.autor.modules.filtros.ObraFiltros;
import com.teste.autor.modules.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AutorController
 *
 * @author Kao Yu Chun
 *
 */
@RestController
@RequestMapping(value = "api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public Page<AutorResponse> getAutores(PageRequest pageRequest, @Validated AutorFiltros filtros) {
        return autorService.getAll(pageRequest,filtros);
    }

    @PostMapping
    public AutorResponse save(@RequestBody @Validated AutorRequest request) {
        return autorService.sava(request);
    }

    @GetMapping("{id}")
    public AutorResponse getAutorById(@PathVariable("id") Integer id) {
        return autorService.findOne(id);
    }

    @PutMapping
    public Integer update(@RequestBody @Validated AutorRequest request) {
        return autorService.update(request);
    }

    @DeleteMapping
    public void deleteAutor(@RequestBody AutorRequest request) {
        autorService.deleteAutor(request);
    }

}
