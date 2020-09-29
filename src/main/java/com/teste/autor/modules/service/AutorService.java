package com.teste.autor.modules.service;

import com.teste.autor.modules.dto.autor.AutorRequest;
import com.teste.autor.modules.dto.autor.AutorResponse;
import com.teste.autor.modules.model.app.Autor;
import com.teste.autor.modules.repository.app.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorResponse sava(AutorRequest request) {
        request.velidarPais();
        Autor autor = autorRepository.save(AutorRequest.of(request));
        return  AutorResponse.convertFrom(autor);
    }
}
