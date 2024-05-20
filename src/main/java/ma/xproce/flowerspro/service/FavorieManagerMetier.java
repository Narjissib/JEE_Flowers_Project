package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Favori;
import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.entities.Produit;
import ma.xproce.flowerspro.dao.repositories.FavoriRepository;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavorieManagerMetier implements FavorieManager{
    @Autowired
    private FavoriRepository favorieRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public FavorieManagerMetier(FavoriRepository favorieRepository, ProduitRepository produitRepository) {
        this.favorieRepository = favorieRepository;
        this.produitRepository = produitRepository;
    }


   @Override
    public Favori ajouteraafavorie(Integer productId) {
        Produit produit=produitRepository.findById(productId).get();
        if(produit!=null){
            Favori favorie=new Favori(produit);
            return favorieRepository.save(favorie);
        }
        return null;

    }
    @Override
    public List<Favori> getProduitsDansLeFavorie() {
        return favorieRepository.findAll();
    }
    @Override
    public boolean removeProduitFromFavorie(Integer produitId) {
        Optional<Favori> FavoriOptional = favorieRepository.findByProduitId(produitId);
        if (FavoriOptional.isPresent()) {
            favorieRepository.delete(FavoriOptional.get());
            return true;
        } else {
            return false; // Le produit n'était pas dans le panier
        }
    }
    @Override
    public void viderFavori() {
        favorieRepository.deleteAll();
    }

}

