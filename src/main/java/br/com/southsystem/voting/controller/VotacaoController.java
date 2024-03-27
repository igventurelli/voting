package br.com.southsystem.voting.controller;

import br.com.southsystem.voting.controller.payload.votacao.AbrirVotacaoRequestPayload;
import br.com.southsystem.voting.controller.payload.votacao.AbrirVotacaoResponsePayload;
import br.com.southsystem.voting.dto.PautaDTO;
import br.com.southsystem.voting.dto.VotacaoDTO;
import br.com.southsystem.voting.service.VotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/votacoes")
public class VotacaoController {

    private final VotacaoService votacaoService;

    @PostMapping("/")
    public ResponseEntity<AbrirVotacaoResponsePayload> create(@RequestBody AbrirVotacaoRequestPayload payload) {
        var dto = VotacaoDTO.builder()
                .pauta(PautaDTO.builder().id(payload.pautaId()).build())
                .tempo(payload.tempo())
                .build();

        var votacao = votacaoService.abrirVotacao(dto);

        return ResponseEntity.created(URI.create("/votacoes/" + votacao.id())).body(AbrirVotacaoResponsePayload.builder()
                .id(votacao.id())
                .pautaId(votacao.pauta().id())
                .tempo(votacao.tempo())
                .build());
    }
}
