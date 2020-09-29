package com.teste.autor.modules.dto.obra;

import com.teste.autor.modules.dto.autor.AutorResponse;
import com.teste.autor.modules.model.app.Autor;
import com.teste.autor.modules.model.app.Obra;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraResponse {


    private String nome;
    private String descricao;
    private String imagem;
    private String dataPublicacao;
    private String dataExposicao;

    public static ObraResponse convertFrom(Obra obra){
        ObraResponse response = new ObraResponse();
        BeanUtils.copyProperties(obra, response);
        return response;
    }
}
