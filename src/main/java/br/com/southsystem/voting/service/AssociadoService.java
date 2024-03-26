package br.com.southsystem.voting.service;

import br.com.southsystem.voting.dto.AssociadoDTO;
import br.com.southsystem.voting.repository.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository associadoRepository;

    public AssociadoDTO create(AssociadoDTO dto) {
        return associadoRepository.save(dto.toModel()).toDTO();
    }
}
