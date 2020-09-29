package com.teste.autor.modules.dto.autor;

import com.teste.autor.modules.model.app.Autor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorResponse {

    private Integer id;
    private String nome;
    private String sexo;
    private String email;
    private String dataNascimento;
    private String paisOrigem;
    private String cpf;

    public static AutorResponse convertFrom(Autor autor){
        AutorResponse response = new AutorResponse();
        BeanUtils.copyProperties(autor, response);
        return response;
    }
}
