package br.com.southsystem.voting.controller;

import br.com.southsystem.voting.dto.AssociadoDTO;
import br.com.southsystem.voting.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/associados")
public class AssociadoController {

    private final AssociadoService associadoService;

    @PostMapping("/")
    public ResponseEntity<AssociadoDTO> create(@RequestBody AssociadoDTO payload) {
        var associado = associadoService.create(payload);
        return ResponseEntity.created(URI.create("/associados/" + associado.id())).body(associado);
    }
}
