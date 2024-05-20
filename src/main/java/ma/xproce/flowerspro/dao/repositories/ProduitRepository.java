package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
}
