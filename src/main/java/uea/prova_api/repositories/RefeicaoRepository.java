package uea.prova_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.prova_api.models.Refeicao;
@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {

}
