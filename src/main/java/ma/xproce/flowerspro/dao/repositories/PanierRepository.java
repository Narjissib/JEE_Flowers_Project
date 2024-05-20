package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Integer> {
    Optional<Panier> findByProduitId(Integer produitId);
}
