package br.com.southsystem.voting.controller;

import br.com.southsystem.voting.controller.payload.eleicao.CriarEleicaoRequestPayload;
import br.com.southsystem.voting.controller.payload.eleicao.CriarEleicaoResponsePayload;
import br.com.southsystem.voting.dto.PautaDTO;
import br.com.southsystem.voting.dto.EleicaoDTO;
import br.com.southsystem.voting.service.EleicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eleicoes")
public class EleicaoController {

    private final EleicaoService eleicaoService;

    @PostMapping("/")
    public ResponseEntity<CriarEleicaoResponsePayload> create(@RequestBody CriarEleicaoRequestPayload payload) {
        var dto = EleicaoDTO.builder()
                .pauta(PautaDTO.builder().id(payload.pautaId()).build())
                .tempo(payload.tempo())
                .build();

        var eleicao = eleicaoService.create(dto);

        return ResponseEntity.created(URI.create("/eleicoes/" + eleicao.id())).body(CriarEleicaoResponsePayload.builder()
                .id(eleicao.id())
                .pautaId(eleicao.pauta().id())
                .tempo(eleicao.tempo())
                .build());
    }
}
