package br.com.southsystem.voting.model;

import br.com.southsystem.voting.dto.AssociadoDTO;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "associado", cascade = CascadeType.MERGE)
    private Set<Voto> votos;

    public AssociadoDTO toDTO() {
        return AssociadoDTO.builder().id(id).nome(nome).build();
    }
}
