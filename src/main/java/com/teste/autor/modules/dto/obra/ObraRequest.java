package com.teste.autor.modules.dto.obra;

import com.teste.autor.modules.dto.autor.AutorRequest;
import com.teste.autor.modules.model.app.Autor;
import com.teste.autor.modules.model.app.Obra;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ObraRequest {

    @NotNull
    private String nome;
    @NotNull
    private String descricao;
    @NotNull
    private String imagem;
    @NotNull
    private String dataPublicacao;
    @NotNull
    private String dataExposicao;

    public static Obra of(ObraRequest request){
        Obra obra = new Obra();
        BeanUtils.copyProperties(request, obra);
        return obra;
    }
}
