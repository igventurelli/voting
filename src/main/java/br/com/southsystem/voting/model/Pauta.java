package br.com.southsystem.voting.model;

import br.com.southsystem.voting.dto.PautaDTO;
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
public class Pauta {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @OneToOne(mappedBy = "pauta")
    private Eleicao eleicao;

    public PautaDTO toDTO() {
        return PautaDTO.builder().id(id).titulo(titulo).build();
    }
}
