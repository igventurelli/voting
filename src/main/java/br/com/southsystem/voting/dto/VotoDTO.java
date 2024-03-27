package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Eleicao;
import br.com.southsystem.voting.model.Voto;
import lombok.Builder;

@Builder
public record VotoDTO (Long id, EleicaoDTO eleicaoDTO, String valor, AssociadoDTO associado) {

    public Voto toModel() {
        return Voto.builder()
                .eleicao(Eleicao.builder().id(eleicaoDTO().id()).build())
                .valor(valor)
                .associado(associado.toModel())
                .build();
    }
}
