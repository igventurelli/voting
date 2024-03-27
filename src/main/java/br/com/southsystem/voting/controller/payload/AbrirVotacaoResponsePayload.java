package br.com.southsystem.voting.controller.payload;

import lombok.Builder;

@Builder
public record AbrirVotacaoResponsePayload (Long id, Long pautaId, Long tempo) {
}
