package br.com.southsystem.voting.dto;

import br.com.southsystem.voting.model.Eleicao;
import br.com.southsystem.voting.model.Voto;
import lombok.Builder;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
public record EleicaoDTO(Long id, PautaDTO pauta, Long tempo, Set<VotoDTO> votos) {

    public Eleicao toModel() {
        return Eleicao.builder()
                .pauta(pauta.toModel())
                .tempo(tempo)
                .votos(votos.stream()
                        .map(v -> Voto.builder().associado(v.associado().toModel()).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
