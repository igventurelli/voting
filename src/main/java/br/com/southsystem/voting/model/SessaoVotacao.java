package br.com.southsystem.voting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessaoVotacao {

    @Id
    @Column
    private Long id;

    // tempo em segundos
    @Column(columnDefinition = "integer default 60")
    private Long tempo;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Pauta pauta;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;
}
