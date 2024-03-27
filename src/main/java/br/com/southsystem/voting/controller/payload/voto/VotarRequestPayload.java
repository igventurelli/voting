package br.com.southsystem.voting.controller.payload.voto;

import lombok.Builder;

@Builder
public record VotarRequestPayload (Long votacaoId, String valor, Long associadoId) {
}
