package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Votacao;
import br.com.southsystem.voting.model.Voto;
import lombok.Builder;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
public record VotacaoDTO (Long id, PautaDTO pauta, Long tempo, Set<VotoDTO> votos) {

    public Votacao toModel() {
        return Votacao.builder()
                .pauta(pauta.toModel())
                .tempo(tempo)
                .votos(votos.stream()
                        .map(v -> Voto.builder().associado(v.associado().toModel()).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
