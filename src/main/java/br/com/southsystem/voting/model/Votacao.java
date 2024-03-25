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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"sessao_votacao_id", "associado_id"}) })
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sessao_votacao_id")
    private SessaoVotacao sessaoVotacao;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;
}
