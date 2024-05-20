package ma.xproce.flowerspro.service;

import jakarta.transaction.Transactional;
import ma.xproce.flowerspro.dao.entities.Adresse;
import ma.xproce.flowerspro.dao.entities.Commande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommandeManager {
    @Transactional
    void creerCommande(Commande commande);

    Commande getCommandeById(Integer commandeId);

    List<Commande> getAllCommandes();
}
