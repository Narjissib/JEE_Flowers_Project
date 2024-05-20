package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.entities.Produit;
import ma.xproce.flowerspro.dao.repositories.PanierRepository;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PanierManagerMetier implements PanierManager{

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private ProduitRepository produitRepository;
    private final List<Panier> panierList = new ArrayList<>();

    public PanierManagerMetier(PanierRepository panierRepository, ProduitRepository produitRepository) {
        this.panierRepository = panierRepository;
        this.produitRepository = produitRepository;
    }


    @Override
    public Panier ajouteraupanier(Integer productId) {
        Produit produit=produitRepository.findById(productId).get();
        if(produit!=null){
            Panier panier=new Panier(produit);
            return panierRepository.save(panier);
        }
        return null;

    }
    @Override
    public List<Panier> getProduitsDansLePanier() {
        return panierRepository.findAll();
    }
    @Override
    public boolean removeProduitFromPanier(Integer produitId) {
        Optional<Panier> panierOptional = panierRepository.findByProduitId(produitId);
        if (panierOptional.isPresent()) {
            panierRepository.delete(panierOptional.get());
            return true;
        } else {
            return false; // Le produit n'était pas dans le panier
        }
    }
    @Override
    public void viderPanier() {
        panierRepository.deleteAll();
    }

}
