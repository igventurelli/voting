package br.com.southsystem.voting.model;

import br.com.southsystem.voting.dto.VotoDTO;
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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"eleicao_id", "associado_id"}) })
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String valor;

    @ManyToOne
    @JoinColumn(name = "eleicao_id")
    private Eleicao eleicao;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;

    public VotoDTO toDTO() {
        return VotoDTO.builder().id(id).eleicaoDTO(eleicao.toDTO()).valor(valor).associado(associado.toDTO()).build();
    }
}
