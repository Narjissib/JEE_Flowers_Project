package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Livraison;
import ma.xproce.flowerspro.dao.entities.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreurRepository extends JpaRepository<Livreur,Integer> {
}
