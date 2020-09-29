package com.teste.autor.modules.controller;

import com.teste.autor.modules.dto.autor.AutorRequest;
import com.teste.autor.modules.dto.autor.AutorResponse;
import com.teste.autor.modules.dto.obra.ObraResponse;
import com.teste.autor.modules.filtros.ObraFiltros;
import com.teste.autor.modules.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ObraResponse> getObras(PageRequest pageRequest, @Validated ObraFiltros filtros) {
        return null;
    }

    @PostMapping
    public AutorResponse save(@RequestBody AutorRequest request) {
        return autorService.sava(request);
    }
}
