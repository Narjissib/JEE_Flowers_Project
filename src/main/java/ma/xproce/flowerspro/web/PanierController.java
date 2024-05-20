package ma.xproce.flowerspro.web;

import jakarta.servlet.http.HttpServletRequest;
import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.entities.Produit;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import ma.xproce.flowerspro.service.PanierManager;
import ma.xproce.flowerspro.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PanierController {

    @Autowired
    private PanierManager paniermanager;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/ajouter-au-panier/{produitId}")
        public String ajouterAuPanier(@PathVariable Integer produitId, HttpServletRequest request) {
            paniermanager.ajouteraupanier(produitId);
            String referer = request.getHeader("Referer");
            if (referer != null && referer.contains("/fleurpage")) {
                return "redirect:/fleurpage";
            } else if (referer != null && referer.contains("/indexpage")) {
                return "redirect:/indexpage";
            } else {
                return "error";
            }
            }

    @GetMapping("/panier")
    public String afficherPanier(Model model) {
        List<Panier> listeDesProduitsDansLePanier = paniermanager.getProduitsDansLePanier();
        double prixTotal = listeDesProduitsDansLePanier.stream()
                .mapToDouble(panier -> panier.getProduit().getPrix())
                .sum();
        model.addAttribute("listeDesProduitsDansLePanier", listeDesProduitsDansLePanier);
        model.addAttribute("prixTotal", prixTotal);
        return "panierpage"; // Assurez-vous que le nom de la vue est correct
    }
    @GetMapping("/removedupanier/{produitId}")
    public String removeProductFromPanier(@PathVariable Integer produitId) {
        if (paniermanager.removeProduitFromPanier(produitId)) {
            return "redirect:/panier";
        } else {
            return "error";
        }
    }
    @PostMapping("/vider-panier")
    public String viderPanier() {
        paniermanager.viderPanier();
        return "redirect:/panier";
    }




}
