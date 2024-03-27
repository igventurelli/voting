package br.com.southsystem.voting.controller.payload.votacao;

import lombok.Builder;

@Builder
public record AbrirVotacaoResponsePayload (Long id, Long pautaId, Long tempo) {
}
