package uea.prova_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.prova_api.models.Consumidor;
@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Long>{

}
