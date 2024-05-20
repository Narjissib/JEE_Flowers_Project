package ma.xproce.flowerspro;

import ma.xproce.flowerspro.dao.entities.Produit;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlowersProApplication implements CommandLineRunner {
@Autowired
    ProduitRepository produitRepository;
    public static void main(String[] args) {

        SpringApplication.run(FlowersProApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Produit p=new Produit() ;
        p.setNom("Produit1");
        p.setDescription("Description1");
        p.setPrix(2140);
        //produitRepository.save(p);
    }
}
