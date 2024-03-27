package br.com.southsystem.voting.model;

import br.com.southsystem.voting.dto.VotacaoDTO;
import br.com.southsystem.voting.dto.VotoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Votacao {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long tempo;

    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private Pauta pauta;

    @OneToMany(mappedBy = "votacao", cascade = CascadeType.ALL)
    private Set<Voto> votos;

    @PrePersist
    public void prePersist() {
        // defaults to 60 seconds
        tempo = Optional.ofNullable(tempo).orElse(60L);
    }

    public VotacaoDTO toDTO() {
        var builder = VotacaoDTO
                .builder()
                .id(id)
                .tempo(tempo);

        if (pauta != null) {
            builder.pauta(pauta.toDTO());
        }

        if (votos != null) {
            builder.votos(votos.stream().map(v -> VotoDTO.builder().build()).collect(Collectors.toSet()));
        }

        return builder.build();
    }
}
