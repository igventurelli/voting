package br.com.southsystem.voting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessaoVotacao {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // tempo em segundos
    @Column(columnDefinition = "integer default 60")
    private Long tempo;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Pauta pauta;

    @OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL)
    private Set<Votacao> votacoes;
}
