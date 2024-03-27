package br.com.southsystem.voting.controller;

import br.com.southsystem.voting.controller.payload.voto.CriarVotoRequestPayload;
import br.com.southsystem.voting.controller.payload.voto.CriarResponsePayload;
import br.com.southsystem.voting.dto.AssociadoDTO;
import br.com.southsystem.voting.dto.EleicaoDTO;
import br.com.southsystem.voting.dto.VotoDTO;
import br.com.southsystem.voting.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/votos")
public class VotoController {

    private final VotoService votoService;

    @PostMapping("/")
    public ResponseEntity<CriarResponsePayload> create(@RequestBody CriarVotoRequestPayload payload) {
        var dto = VotoDTO.builder()
                .eleicaoDTO(EleicaoDTO.builder().id(payload.eleicaoId()).build())
                .valor(payload.valor())
                .associado(AssociadoDTO.builder().id(payload.associadoId()).build())
                .build();

        var voto = votoService.create(dto);

        return ResponseEntity.created(URI.create("/votos/" + voto.id())).body(CriarResponsePayload
                .builder()
                .id(voto.id())
                .eleicaoId(voto.eleicaoDTO().id())
                .valor(voto.valor())
                .associadoId(voto.associado().id())
                .build());
    }
}
