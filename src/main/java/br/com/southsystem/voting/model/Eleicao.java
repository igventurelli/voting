package br.com.southsystem.voting.model;

import br.com.southsystem.voting.dto.EleicaoDTO;
import br.com.southsystem.voting.dto.VotoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Eleicao {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long tempo;

    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private Pauta pauta;

    @OneToMany(mappedBy = "eleicao", cascade = CascadeType.ALL)
    private Set<Voto> votos;

    @PrePersist
    public void prePersist() {
        // defaults to 60 seconds
        tempo = Optional.ofNullable(tempo).orElse(60L);
    }

    public EleicaoDTO toDTO() {
        var builder = EleicaoDTO
                .builder()
                .id(id)
                .tempo(tempo);

        if (pauta != null) {
            builder.pauta(pauta.toDTO());
        }

        if (votos != null) {
            builder.votos(votos.stream().map(v -> VotoDTO.builder()
                    .valor(v.getValor())
                    .build()).collect(Collectors.toSet()));
        }

        return builder.build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }

    public Set<Voto> getVotos() {
        return votos;
    }

    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
    }
}
