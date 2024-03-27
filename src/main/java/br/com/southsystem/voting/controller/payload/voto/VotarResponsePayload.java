package br.com.southsystem.voting.controller.payload.voto;

import lombok.Builder;

@Builder
public record VotarResponsePayload (Long id, Long votacaoId, String valor, Long associadoId) {
}
