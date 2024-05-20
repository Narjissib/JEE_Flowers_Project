package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Fleur;
import ma.xproce.flowerspro.dao.entities.Livreur;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LivreurManager {
    public Livreur addLivreur(Livreur livreur);
    public Livreur getLivreurById(Integer id);
    public Livreur deleteLivreur(Livreur livreur);
    public boolean deleteLivreur(Integer id);
    public List<Livreur> getAllLivreurs();
}
