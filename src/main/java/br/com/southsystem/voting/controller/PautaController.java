package br.com.southsystem.voting.controller;

import br.com.southsystem.voting.dto.PautaDTO;
import br.com.southsystem.voting.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    @PostMapping("/")
    public ResponseEntity<PautaDTO> create(@RequestBody PautaDTO payload) {
        var pauta = pautaService.create(payload);
        return ResponseEntity.created(URI.create("/pautas/" + pauta.id())).body(pauta);
    }
}
