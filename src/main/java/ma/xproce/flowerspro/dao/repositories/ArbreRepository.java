package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Arbre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbreRepository extends JpaRepository<Arbre,Integer> {
    Page<Arbre> findByNomContains(String keyword, Pageable pageable);

}
