package br.com.southsystem.voting.service;

import br.com.southsystem.voting.dto.VotoDTO;
import br.com.southsystem.voting.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;

    public VotoDTO create(VotoDTO dto) {
        return votoRepository.save(dto.toModel()).toDTO();
    }
}
