package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Favori;

import java.util.List;

public interface FavorieManager {
    Favori ajouteraafavorie(Integer productId);

    List<Favori> getProduitsDansLeFavorie();

    boolean removeProduitFromFavorie(Integer produitId);

    void viderFavori();
}
