package ma.xproce.flowerspro.dao.repositories;
import ma.xproce.flowerspro.dao.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByNom(String nom);


}