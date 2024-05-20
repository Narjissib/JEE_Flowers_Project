package ma.xproce.flowerspro.web;

import ma.xproce.flowerspro.dao.entities.Commande;
import ma.xproce.flowerspro.dao.entities.Livraison;
import ma.xproce.flowerspro.dao.entities.Livreur;

import ma.xproce.flowerspro.service.CommandeManager;
import ma.xproce.flowerspro.service.LivraisonManager;
import ma.xproce.flowerspro.service.LivreurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LivraisonController {

    @Autowired
    private LivraisonManager livraisonManager;

    @Autowired
    private LivreurManager livreurManager;

    @Autowired
    private CommandeManager commandeManager;

    @GetMapping("/livraison/{commandeId}")
    public String showLivraisonForm(@PathVariable Integer commandeId, Model model) {
        Livraison livraison = new Livraison();
        Commande commande = commandeManager.getCommandeById(commandeId);
        livraison.setCommande(commande);
        List<Livreur> livreurs = livreurManager.getAllLivreurs();
        model.addAttribute("livraison", livraison);
        model.addAttribute("livreurs", livreurs);
        return "livraison-form";
    }

    @PostMapping("/livraison")
    public String createLivraison(@ModelAttribute Livraison livraison) {
        livraisonManager.saveLivraison(livraison);
        return "redirect:/livraisons";
    }

    @GetMapping("/livraisons")
    public String listLivraisons(Model model) {
        List<Livraison> livraisons = livraisonManager.findAllLivraisons();
        model.addAttribute("livraisons", livraisons);
        return "livraison-list";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("livreurs", livreurManager.getAllLivreurs());
    }

}
