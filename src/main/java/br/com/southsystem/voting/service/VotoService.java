package br.com.southsystem.voting.service;

import br.com.southsystem.voting.dto.VotoDTO;
import br.com.southsystem.voting.exception.ConflictException;
import br.com.southsystem.voting.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;
    private final EleicaoService eleicaoService;

    public VotoDTO create(VotoDTO dto) {
        if (!eleicaoService.isElectionOpen(dto.eleicaoDTO().id())) {
            throw new ConflictException("Eleição encerrada");
        }
        return votoRepository.save(dto.toModel()).toDTO();
    }
}
