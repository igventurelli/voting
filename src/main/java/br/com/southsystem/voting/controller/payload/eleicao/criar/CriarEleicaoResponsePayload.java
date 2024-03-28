package br.com.southsystem.voting.controller.payload.eleicao.criar;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CriarEleicaoResponsePayload(Long id, Long pautaId, Long tempo, LocalDateTime dataAbertura) {
}
