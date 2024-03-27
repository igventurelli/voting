package br.com.southsystem.voting.controller.payload.voto;

import lombok.Builder;

@Builder
public record CriarVotoRequestPayload(Long eleicaoId, String valor, Long associadoId) {
}
