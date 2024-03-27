package br.com.southsystem.voting.controller.payload.voto;

import lombok.Builder;

@Builder
public record CriarResponsePayload(Long id, Long eleicaoId, String valor, Long associadoId) {
}
