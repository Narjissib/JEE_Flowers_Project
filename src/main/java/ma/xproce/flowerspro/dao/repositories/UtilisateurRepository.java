package ma.xproce.flowerspro.dao.repositories;

import ma.xproce.flowerspro.dao.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByNom(String nom);

}
