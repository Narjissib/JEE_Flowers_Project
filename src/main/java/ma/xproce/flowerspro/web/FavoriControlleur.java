package ma.xproce.flowerspro.web;

import jakarta.servlet.http.HttpServletRequest;
import ma.xproce.flowerspro.dao.entities.Favori;
import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import ma.xproce.flowerspro.service.FavorieManager;
import ma.xproce.flowerspro.service.PanierManager;
import ma.xproce.flowerspro.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FavoriControlleur {
    @Autowired
    private FavorieManager favorieManager;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/ajouter-au-favorie/{produitId}")
    public String ajouterAuPanier(@PathVariable Integer produitId, HttpServletRequest request) {
        favorieManager.ajouteraafavorie(produitId);
        String referer = request.getHeader("Referer");
        if (referer != null && referer.contains("/fleurpage")) {
            return "redirect:/fleurpage";
        } else if (referer != null && referer.contains("/indexpage")) {
            return "redirect:/indexpage";
        } else {
            return "error";
        }
    }

    @GetMapping("/favori")
    public String afficherPanier(Model model) {
        List<Favori> listeDesProduitsDansLesFavories = favorieManager.getProduitsDansLeFavorie();
        model.addAttribute("listeDesProduitsDansLefavorie", listeDesProduitsDansLesFavories);
        return "favoriepage"; // Assurez-vous que le nom de la vue est correct
    }
    @GetMapping("/removedufavorie/{produitId}")
    public String removeProductFromPanier(@PathVariable Integer produitId) {
        if (favorieManager.removeProduitFromFavorie(produitId)) {
            return "redirect:/favori";
        } else {
            return "error";
        }
    }
    @PostMapping("/vider-favorie")
    public String viderPanier() {
        favorieManager.viderFavori();
        return "redirect:/favori";
    }




}


