package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductManager {
    public Produit addProduit(Produit produit);
    public Page<Produit> getAllProduits(int page, int taille);
    public Page<Produit> searchProduits(String keyword, int page, int taille);
    public List<Produit> getByKeyword(String keyword);
    public Produit getProduitById(Integer id);
    public Produit updateProduit(Produit produit);
    public boolean deleteProduit(Integer id);
}
