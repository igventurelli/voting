package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Votacao;
import br.com.southsystem.voting.model.Voto;
import lombok.Builder;

@Builder
public record VotoDTO (Long id, VotacaoDTO votacaoDTO, String valor, AssociadoDTO associado) {

    public Voto toModel() {
        return Voto.builder()
                .votacao(Votacao.builder().id(votacaoDTO().id()).build())
                .valor(valor)
                .associado(associado.toModel())
                .build();
    }
}
