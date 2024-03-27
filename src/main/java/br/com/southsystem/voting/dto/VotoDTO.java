package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Voto;

public record VotoDTO (Long id, AssociadoDTO associado) {

    public Voto toModel() {
        return Voto.builder().associado(associado.toModel()).build();
    }
}
