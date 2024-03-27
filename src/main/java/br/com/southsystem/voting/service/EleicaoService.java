package br.com.southsystem.voting.service;

import br.com.southsystem.voting.dto.EleicaoDTO;
import br.com.southsystem.voting.model.Pauta;
import br.com.southsystem.voting.model.Eleicao;
import br.com.southsystem.voting.repository.EleicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EleicaoService {

    private final EleicaoRepository eleicaoRepository;

    public EleicaoDTO create(EleicaoDTO dto) {
        return eleicaoRepository.save(Eleicao.builder()
                .pauta(Pauta.builder().id(dto.pauta().id()).build())
                .tempo(dto.tempo())
                .build())
                .toDTO();
    }
}
