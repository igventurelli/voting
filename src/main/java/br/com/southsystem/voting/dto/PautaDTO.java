package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Pauta;
import lombok.Builder;

@Builder
public record PautaDTO (Long id, String titulo) {

    public Pauta toModel() {
        return Pauta.builder().titulo(titulo).build();
    }
}
