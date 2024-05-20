package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.dao.entities.Produit;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArbreManager {
    public Arbre addArbre(Arbre arbre);
    public Page<Arbre> getAllArbrs(int page, int taille);
    public Page<Arbre> searchArbres(String keyword, int page, int taille);
    public List<Arbre> getByKeyword(String keyword);
    public Arbre getArbreById(Integer id);
    public Arbre updateArbre(Arbre arbre);
    public boolean deleteArbre(Integer id);

    public List<Arbre> getAllArbrs();
}
