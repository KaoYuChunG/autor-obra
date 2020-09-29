package com.teste.autor.modules.dto.autor;

import com.teste.autor.modules.model.app.Autor;
import com.teste.autor.utils.ValidacaoException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
public class AutorRequest {

    @NotNull
    private String nome;
    private String sexo;
    @NotNull
    private String email;
    @NotNull
    private String dataNascimento;
    @NotNull
    private String paisOrigem;
    private String cpf;

    public static Autor of(AutorRequest request){
        Autor autor = new Autor();
        BeanUtils.copyProperties(request, autor);
        return autor;
    }

    public String tratarCpf() {
        return null;
    }
    public void velidarPais() {
        if (this.paisOrigem.equals("Brasil") && Objects.isNull(this.cpf)){
            tratarCpf();
            throw new ValidacaoException("O campo CPF é obrigatório.");
        }
    }

}
