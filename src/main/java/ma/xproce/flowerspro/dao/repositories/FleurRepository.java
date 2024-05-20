package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.dao.entities.Fleur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleurRepository extends JpaRepository<Fleur,Integer> {
    Page<Fleur> findByNomContains(String keyword, Pageable pageable);

}
