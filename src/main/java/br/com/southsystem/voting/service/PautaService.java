package br.com.southsystem.voting.service;

import br.com.southsystem.voting.dto.PautaDTO;
import br.com.southsystem.voting.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PautaService {

    private final PautaRepository pautaRepository;

    public PautaDTO create(PautaDTO dto) {
        return pautaRepository.save(dto.toModel()).toDTO();
    }
}
