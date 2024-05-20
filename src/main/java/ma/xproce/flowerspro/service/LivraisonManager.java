package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Livraison;

import java.util.List;

public interface LivraisonManager {
    void saveLivraison(Livraison livraison);

    List<Livraison> findAllLivraisons();
}
