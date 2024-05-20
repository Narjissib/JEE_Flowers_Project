package ma.xproce.flowerspro.web;

import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.dao.entities.Fleur;
import ma.xproce.flowerspro.service.ArbreManager;
import ma.xproce.flowerspro.service.FleurManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class FleurControlleur {
    @Autowired
    FleurManager fleurManager;

    @GetMapping("/Fleurs")
    public String listFleurs(Model model){
        model.addAttribute("listFleurs", fleurManager.getAllFlowers());
        return "templateBouqet";}
    @GetMapping("/ajouter-fleur")
    public String addFleurForm(Model model) {

        return "addFleur";
    }
    @PostMapping("/ajouter-fleur")
    public String ajouterFleurAction(Model model,
                                     @RequestParam(name = "nom") String nom,
                                     @RequestParam(name = "description") String description,
                                     @RequestParam(name = "prix") double prix,
                                     @RequestParam(name = "image") String image,
                                     @RequestParam(name = "couleur") String couleur) {

        Fleur fleur = new Fleur();
        fleur.setNom(nom);
        fleur.setDescription(description);
        fleur.setPrix(prix);
        fleur.setImage(image);
        fleur.setCouleur(couleur);

        fleurManager.addFleur(fleur);

        return "redirect:/fleurpage";
    }
    @GetMapping("/editFleur")
    public String editProduit(Model model, @RequestParam(name = "id") Integer id) {
        Fleur fleur = fleurManager.getFlowerById(id);
        if (fleur != null) {
            model.addAttribute("fleurToBeUpdated", fleur);
            return "updatefleur";
        } else {
            return "error";
        }
    }
    @PostMapping("/modifer-fleur")
    public String modifierFleurAction(Model model,
                                      @RequestParam(name="id") Integer id,
                                      @RequestParam(name = "nom") String nom,
                                      @RequestParam(name = "description") String description,
                                      @RequestParam(name = "prix") double prix,
                                      @RequestParam(name = "image") String image,
                                      @RequestParam(name = "couleur") String couleur) {

        // Créer une nouvelle instance de Arbre avec les données fournies
        Fleur fleurToUpdate=fleurManager.getFlowerById(id);
        if(fleurToUpdate!=null){
            fleurToUpdate.setNom(nom);
            fleurToUpdate.setDescription(description);
            fleurToUpdate.setPrix(prix);
            fleurToUpdate.setImage(image);
            fleurToUpdate.setCouleur(couleur);
            fleurManager.updateFlower(fleurToUpdate);
            return "redirect:/fleurpage";

        }

        else{
            return "error";
        }

    }
    @GetMapping("/deleteFleur")
    public String deleteFleur(Model model, @RequestParam(name = "id") Integer id) {
        if (fleurManager.deleteFlower(id)) {
            return "redirect:/fleurpage";
        } else {
            return "error";
        }
    }
    @GetMapping("/fleurpage")
    public String listProduitsAction(Model model,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "taille", defaultValue = "3") int taille,
                                     @RequestParam(name = "search", defaultValue = "") String search) {
        Page<Fleur> fleurs = fleurManager.searchFlowers(search, page, taille);

        model.addAttribute("listFleurs", fleurs.getContent());
        model.addAttribute("pages", new int[fleurs.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", search); // Ajout de l'attribut keyword
        return "templateBouqet";
    }

}
