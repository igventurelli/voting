package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Associado;
import lombok.Builder;

@Builder
public record AssociadoDTO (Long id, String nome) {

    public Associado toModel() {
        return Associado.builder().id(id).nome(nome).build();
    }
}
