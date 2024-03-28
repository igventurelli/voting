package br.com.southsystem.voting.controller.payload.eleicao.resultados;

import br.com.southsystem.voting.dto.PautaDTO;
import lombok.Builder;

@Builder
public record ResultadosEleicaoResponsePayload (PautaDTO pauta, Long votosSim, Long votosNao, Boolean eleito) {
}
