package br.com.southsystem.voting.model;

import br.com.southsystem.voting.dto.EleicaoDTO;
import br.com.southsystem.voting.dto.VotoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
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

    @Column
    private LocalDateTime dataAbertura;

    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private Pauta pauta;

    @OneToMany(mappedBy = "eleicao", cascade = CascadeType.ALL)
    private Set<Voto> votos;

    @PrePersist
    public void prePersist() {
        // defaults to 60 seconds
        tempo = Optional.ofNullable(tempo).orElse(60L);

        dataAbertura = LocalDateTime.now();
    }

    public EleicaoDTO toDTO() {
        var builder = EleicaoDTO
                .builder()
                .id(id)
                .tempo(tempo)
                .dataAbertura(dataAbertura);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleicao eleicao = (Eleicao) o;
        return Objects.equals(id, eleicao.id) && Objects.equals(tempo, eleicao.tempo) && Objects.equals(dataAbertura, eleicao.dataAbertura) && Objects.equals(votos, eleicao.votos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tempo, dataAbertura, votos);
    }
}
