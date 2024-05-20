package ma.xproce.flowerspro.service;

import jakarta.transaction.Transactional;
import ma.xproce.flowerspro.dao.entities.Adresse;
import ma.xproce.flowerspro.dao.entities.Commande;
import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.repositories.AdresseRepository;
import ma.xproce.flowerspro.dao.repositories.CommandeRepository;
import ma.xproce.flowerspro.dao.repositories.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommandeManagerMetier implements CommandeManager {
    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private AdresseRepository adresseRepository;

    @Override
    @Transactional
    public void creerCommande(Commande commande) {
        List<Panier> produitsDansLePanier = panierRepository.findAll();
        commande.setProduits(produitsDansLePanier.stream()
                .map(Panier::getProduit)
                .toList());

        double montantTotal = produitsDansLePanier.stream()
                .mapToDouble(panier -> panier.getProduit().getPrix())
                .sum();
        commande.setMontantTotal(montantTotal);

        commande.setDateCommande(new Date());

        // Récupérer l'adresse associée à la commande
        Adresse adresse = commande.getAdresseLivraison();
        // Enregistrer l'adresse si elle n'existe pas déjà
        if (adresse != null && adresse.getId() == null) {
            adresseRepository.save(adresse);
        }

        // Associer l'adresse à la commande
        commande.setAdresseLivraison(adresse);

        // Enregistrer la commande
        commandeRepository.save(commande);

        // Vider le panier après avoir passé la commande
    }


    @Override
    public Commande getCommandeById(Integer commandeId) {
        return commandeRepository.findById(commandeId).orElse(null);
    }
    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll(); // Récupère toutes les commandes de la base de données
    }

}
