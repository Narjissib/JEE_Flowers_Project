package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.entities.Produit;

import java.util.List;

public interface PanierManager {
    public Panier ajouteraupanier(Integer productId);
    public List<Panier> getProduitsDansLePanier();

    boolean removeProduitFromPanier(Integer produitId);

    void viderPanier();
}
