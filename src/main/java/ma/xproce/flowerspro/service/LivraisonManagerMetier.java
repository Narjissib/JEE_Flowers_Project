package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Livraison;
import ma.xproce.flowerspro.dao.repositories.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonManagerMetier implements LivraisonManager{
    @Autowired
    private LivraisonRepository livraisonRepository;

    @Override
    public void saveLivraison(Livraison livraison) {
        livraisonRepository.save(livraison);
    }

    @Override
    public List<Livraison> findAllLivraisons() {
        return livraisonRepository.findAll();
    }
}
