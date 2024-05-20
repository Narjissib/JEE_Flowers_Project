package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.dao.entities.Fleur;
import ma.xproce.flowerspro.dao.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FleurManager {
    public Fleur addFleur(Fleur fleur);
    public Page<Fleur> getAllFlowers(int page, int taille);
    public Page<Fleur> searchFlowers(String keyword, int page, int taille);
    public List<Fleur> getByKeyword(String keyword);
    public Fleur getFlowerById(Integer id);
    public Fleur updateFlower(Fleur fleur);
    public boolean deleteFlower(Integer id);
    public List<Fleur> getAllFlowers();

}
