package br.com.southsystem.voting.service;

import br.com.southsystem.voting.dto.EleicaoDTO;
import br.com.southsystem.voting.exception.ResourceNotFoundException;
import br.com.southsystem.voting.model.Eleicao;
import br.com.southsystem.voting.model.Pauta;
import br.com.southsystem.voting.repository.EleicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public EleicaoDTO getResults(Long id) {
        return eleicaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Eleicao.class)).toDTO();
    }

    public boolean isElectionOpen(Long id) {
        var eleicao = eleicaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Eleicao.class));
        return LocalDateTime.now().isBefore(eleicao.getDataAbertura().plusSeconds(eleicao.getTempo()));
    }
}
