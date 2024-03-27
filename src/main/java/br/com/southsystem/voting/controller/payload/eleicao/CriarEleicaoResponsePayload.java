package br.com.southsystem.voting.controller.payload.eleicao;

import lombok.Builder;

@Builder
public record CriarEleicaoResponsePayload(Long id, Long pautaId, Long tempo) {
}
