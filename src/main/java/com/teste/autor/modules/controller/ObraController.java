package com.teste.autor.modules.controller;

import com.teste.autor.modules.dto.obra.ObraRequest;
import com.teste.autor.modules.dto.obra.ObraResponse;
import com.teste.autor.modules.filtros.ObraFiltros;
import com.teste.autor.modules.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/obra")
public class ObraController {

    @Autowired
    private ObraService obraService;

    @GetMapping
    public List<ObraResponse> getObras(PageRequest pageRequest, @Validated ObraFiltros filtros) {
        return null;
    }

    @PostMapping
    public ObraResponse save(@RequestBody ObraRequest request) {
        return obraService.sava(request);
    }
}
