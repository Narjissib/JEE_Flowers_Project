package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison,Integer> {
}
