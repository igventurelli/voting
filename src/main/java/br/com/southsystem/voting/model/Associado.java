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
public class Associado {

    @Id
    @Column
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
    private Set<SessaoVotacao> sessoesVotacoes;
}
