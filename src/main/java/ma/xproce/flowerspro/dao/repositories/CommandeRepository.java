package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
