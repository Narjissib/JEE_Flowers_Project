package ma.xproce.flowerspro.web;

import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.service.ArbreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArbreControlleur {
@Autowired
    ArbreManager arbreManager;

@GetMapping("/plantes")
public String listArbres(Model model){
    model.addAttribute("listarbres", arbreManager.getAllArbrs());
    return "planteslist";}
    @GetMapping("/ajouter-arbre")
    public String addArbreForm(Model model) {

    return "addArbre";
    }
    @PostMapping("/ajouter-arbre")
    public String ajouterArbreAction(Model model,
                                     @RequestParam(name = "nom") String nom,
                                     @RequestParam(name = "description") String description,
                                     @RequestParam(name = "prix") double prix,
                                     @RequestParam(name = "image") String image,
                                     @RequestParam(name = "typePlante") String typePlante) {

        // Créer une nouvelle instance de Arbre avec les données fournies
        Arbre arbre = new Arbre();
        arbre.setNom(nom);
        arbre.setDescription(description);
        arbre.setPrix(prix);
        arbre.setImage(image);
        arbre.setTypedePlante(typePlante);

        // Appeler la méthode du gestionnaire (ArbreManager) pour ajouter l'arbre à la base de données
        arbreManager.addArbre(arbre);

        // Rediriger l'utilisateur vers la page de liste des arbres après l'ajout réussi
        return "redirect:/indexpage";
    }
    @GetMapping("/editArbre")
    public String editProduit(Model model, @RequestParam(name = "id") Integer id) {
        Arbre arbre = arbreManager.getArbreById(id);
        if (arbre != null) {
            model.addAttribute("arbreToBeUpdated", arbre);
            return "updatearbre";
        } else {
            return "error";
        }
    }
    @PostMapping("/modifer-arbre")
    public String modifierArbreAction(Model model,
                                     @RequestParam(name="id") Integer id,
                                     @RequestParam(name = "nom") String nom,
                                     @RequestParam(name = "description") String description,
                                     @RequestParam(name = "prix") double prix,
                                     @RequestParam(name = "image") String image,
                                     @RequestParam(name = "typePlante") String typePlante) {

        // Créer une nouvelle instance de Arbre avec les données fournies
Arbre arbreToUpdate=arbreManager.getArbreById(id);
if(arbreToUpdate!=null){
    arbreToUpdate.setNom(nom);
    arbreToUpdate.setDescription(description);
    arbreToUpdate.setPrix(prix);
    arbreToUpdate.setImage(image);
    arbreToUpdate.setTypedePlante(typePlante);
    arbreManager.updateArbre(arbreToUpdate);
    return "redirect:/indexpage";

}

else{
    return "error";
}

    }
    @GetMapping("/deleteArbre")
    public String deleteArbre(Model model, @RequestParam(name = "id") Integer id) {
        if (arbreManager.deleteArbre(id)) {
            return "redirect:/indexpage";
        } else {
            return "error";
        }
    }
    @GetMapping("/indexpage")
    public String listProduitsAction(Model model,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "taille", defaultValue = "3") int taille,
                                     @RequestParam(name = "search", defaultValue = "") String search) {
        Page<Arbre> arbres;
        arbres = arbreManager.searchArbres(search, page, taille);

        model.addAttribute("listarbres", arbres.getContent());
        model.addAttribute("pages", new int[arbres.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("search", search);
        return "arbrelayout";
    }
}
