package ma.xproce.flowerspro.web;

import ma.xproce.flowerspro.dao.entities.*;
import ma.xproce.flowerspro.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


import ma.xproce.flowerspro.dao.entities.*;
import ma.xproce.flowerspro.service.CommandeManager;
import ma.xproce.flowerspro.service.PanierManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommandeController {

    @Autowired
    private PanierManager panierManager;

    @Autowired
    private CommandeManager commandeManager;
    @Autowired
    private AdresseManager adresseManager;

    @GetMapping("/afficher-commande")
    public String afficherCommande(Model model) {
        List<Panier> listeDesProduitsDansLePanier = panierManager.getProduitsDansLePanier();
        double prixTotal = listeDesProduitsDansLePanier.stream()
                .mapToDouble(panier -> panier.getProduit().getPrix())
                .sum();
        model.addAttribute("listeDesProduitsDansLePanier", listeDesProduitsDansLePanier);
        model.addAttribute("prixTotal", prixTotal);
        model.addAttribute("commande", new Commande());
        model.addAttribute("adresse", new Adresse());
        return "commandepage"; // Assurez-vous que le nom de la vue est correct
    }
    @PostMapping("/ajouter-adresse")
    public String ajouterAdresse(Model model,
                                 @RequestParam(name = "rue") String rue,
                                 @RequestParam(name = "ville") String ville,
                                 @RequestParam(name = "pays") String pays,
                                 @RequestParam(name = "commandeId") Integer commandeId) {
        // Créer une nouvelle adresse
        Adresse adresse = new Adresse();
        adresse.setRue(rue);
        adresse.setVille(ville);
        adresse.setPays(pays);

        // Récupérer la commande associée
        Commande commande = commandeManager.getCommandeById(commandeId);

        // Lier l'adresse à la commande
        commande.setAdresseLivraison(adresse);

        // Enregistrer l'adresse
        adresseManager.addAdresse(adresse);

        // Passer la commande mise à jour à la vue de confirmation
        model.addAttribute("commande", commande);

        return "redirect:/confirmation?commandeId=" + commande.getId(); // Rediriger vers la page de confirmation
    }

    @GetMapping("/passer-commande")
    public String afficherFormulaire(Model model) {
        model.addAttribute("commande", new Commande());
        model.addAttribute("adresse", new Adresse());
        return "commandepage"; // Assurez-vous que ce nom de vue correspond à votre fichier HTML
    }

    @PostMapping("/passer-commande")
    public String passerCommande(@ModelAttribute Commande commande, @ModelAttribute Adresse adresse) {
        commande.setAdresseLivraison(adresse); // Associez l'adresse à la commande
        commandeManager.creerCommande(commande); // Créez la commande avec l'adresse associée
        return "redirect:/confirmation?commandeId=" + commande.getId(); // Redirige vers la page de confirmation
    }

    @GetMapping("/confirmation")
    public String afficherConfirmation(@RequestParam("commandeId") Integer commandeId, Model model) {
        Commande commande = commandeManager.getCommandeById(commandeId);
        model.addAttribute("commande", commande);

        panierManager.viderPanier();

        return "confirmation";
    }
    @GetMapping("/liste-commandes")
    public String afficherListeCommandes(Model model) {
        List<Commande> listeCommandes = commandeManager.getAllCommandes();
        model.addAttribute("listeCommandes", listeCommandes);
        return "liste-commandes"; // Assurez-vous que ce nom de vue correspond à votre fichier HTML
    }

}
