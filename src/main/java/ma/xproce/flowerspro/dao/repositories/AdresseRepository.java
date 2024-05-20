package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Admin;
import ma.xproce.flowerspro.dao.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Integer> {

}
