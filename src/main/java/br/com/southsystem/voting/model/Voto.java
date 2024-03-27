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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"votacao_id", "associado_id"}) })
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "votacao_id")
    private Votacao votacao;

    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;

    public VotoDTO toDTO() {
        return new VotoDTO(id, associado.toDTO());
    }
}
