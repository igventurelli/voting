package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Associado;

public record AssociadoDTO (Long id, String nome) {

    public Associado toModel() {
        return Associado.builder().nome(nome).build();
    }
}
