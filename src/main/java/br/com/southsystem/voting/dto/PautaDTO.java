package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Pauta;

public record PautaDTO (Long id, String titulo) {

    public Pauta toEntity() {
        return Pauta.builder().titulo(titulo).build();
    }
}
