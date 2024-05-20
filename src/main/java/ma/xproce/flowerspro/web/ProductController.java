package ma.xproce.flowerspro.web;

import ma.xproce.flowerspro.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductManager productManager;

    @GetMapping("/homePage")
    public String start() {
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        return "login"; // Votre page de connexion
    }


}
