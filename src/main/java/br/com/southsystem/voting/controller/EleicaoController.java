package br.com.southsystem.voting.controller;

import br.com.southsystem.voting.controller.payload.eleicao.criar.CriarEleicaoRequestPayload;
import br.com.southsystem.voting.controller.payload.eleicao.criar.CriarEleicaoResponsePayload;
import br.com.southsystem.voting.controller.payload.eleicao.resultados.ResultadosEleicaoResponsePayload;
import br.com.southsystem.voting.dto.PautaDTO;
import br.com.southsystem.voting.dto.EleicaoDTO;
import br.com.southsystem.voting.service.EleicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/resultados")
    public ResponseEntity<ResultadosEleicaoResponsePayload> getResults(@PathVariable("id") Long id) {
        var resultados = eleicaoService.getResults(id);
        var votosSim = resultados.votos().stream().filter(v -> "Sim".equalsIgnoreCase(v.valor())).count();
        var votosNao = resultados.votos().stream().filter(v -> "Nao".equalsIgnoreCase(v.valor())).count();

        return ResponseEntity.ok(ResultadosEleicaoResponsePayload.builder()
                .pauta(resultados.pauta())
                .votosSim(votosSim)
                .votosNao(votosNao)
                .eleito(votosSim > votosNao)
                .build());
    }
}
