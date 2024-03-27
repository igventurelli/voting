package br.com.southsystem.voting.repository;

import br.com.southsystem.voting.model.Eleicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleicaoRepository extends JpaRepository<Eleicao, Long> {
}
