package ma.xproce.flowerspro.web;

import ma.xproce.flowerspro.dao.entities.Fleur;
import ma.xproce.flowerspro.dao.entities.Livreur;
import ma.xproce.flowerspro.service.FleurManager;
import ma.xproce.flowerspro.service.LivreurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LivreurController {
    @Autowired
    LivreurManager livreurManager;

    @GetMapping("/livreur")
    public String listlivreurs(Model model){
        model.addAttribute("listLivreures", livreurManager.getAllLivreurs());
        return "livreuraff";
    }
    @GetMapping("/ajouter-livreur")
    public String addLivreurForm(Model model) {

        return "addlivreur";
    }
    @PostMapping("/ajouter-livreur")
    public String ajouterLivreurAction(Model model,
                                     @RequestParam(name = "nom") String nom,
                                     @RequestParam(name = "email") String email)
    {

        Livreur livreur = new Livreur();
        livreur.setNom(nom);
        livreur.setEmail(email);


        livreurManager.addLivreur(livreur);

        return "redirect:/livreur";
    }
}
