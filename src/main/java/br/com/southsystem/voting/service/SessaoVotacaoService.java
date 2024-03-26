package br.com.southsystem.voting.service;

import br.com.southsystem.voting.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessaoVotacaoService {

    private final VotacaoRepository votacaoRepository;

}
