package br.com.southsystem.voting.controller;

import br.com.southsystem.voting.controller.payload.voto.VotarRequestPayload;
import br.com.southsystem.voting.controller.payload.voto.VotarResponsePayload;
import br.com.southsystem.voting.dto.AssociadoDTO;
import br.com.southsystem.voting.dto.VotacaoDTO;
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
    public ResponseEntity<VotarResponsePayload> create(@RequestBody VotarRequestPayload payload) {
        var dto = VotoDTO.builder()
                .votacaoDTO(VotacaoDTO.builder().id(payload.votacaoId()).build())
                .valor(payload.valor())
                .associado(AssociadoDTO.builder().id(payload.associadoId()).build())
                .build();

        var voto = votoService.create(dto);

        return ResponseEntity.created(URI.create("/votos/" + voto.id())).body(VotarResponsePayload
                .builder()
                .id(voto.id())
                .votacaoId(voto.votacaoDTO().id())
                .valor(voto.valor())
                .associadoId(voto.associado().id())
                .build());
    }
}
