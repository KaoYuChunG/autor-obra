package com.teste.autor.modules.service;

import com.teste.autor.modules.dto.obra.ObraRequest;
import com.teste.autor.modules.dto.obra.ObraResponse;
import com.teste.autor.modules.model.app.Obra;
import com.teste.autor.modules.repository.app.AutorRepository;
import com.teste.autor.modules.repository.app.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObraService {

    @Autowired
    private ObraRepository obraRepository;

    public ObraResponse sava(ObraRequest request) {
        Obra obra = obraRepository.save(ObraRequest.of(request));
        return ObraResponse.convertFrom(obra);
    }
}
