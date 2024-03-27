package br.com.southsystem.voting.service;

import br.com.southsystem.voting.dto.VotacaoDTO;
import br.com.southsystem.voting.model.Pauta;
import br.com.southsystem.voting.model.Votacao;
import br.com.southsystem.voting.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;

    public VotacaoDTO abrirVotacao(VotacaoDTO dto) {
        return votacaoRepository.save(Votacao.builder()
                .pauta(Pauta.builder().id(dto.pauta().id()).build())
                .tempo(dto.tempo())
                .build())
                .toDTO();
    }
}
