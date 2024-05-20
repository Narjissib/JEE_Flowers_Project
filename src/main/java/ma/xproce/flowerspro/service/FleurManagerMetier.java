package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.dao.entities.Fleur;
import ma.xproce.flowerspro.dao.repositories.ArbreRepository;
import ma.xproce.flowerspro.dao.repositories.FleurRepository;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FleurManagerMetier implements FleurManager{
    private final FleurRepository fleurRepository;
    private final ProduitRepository produitRepository;

    public FleurManagerMetier(FleurRepository fleurRepository, ProduitRepository produitRepository) {
        this.fleurRepository = fleurRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public Fleur addFleur(Fleur fleur) {
        return produitRepository.save(fleur);    }

    @Override
    public Page<Fleur> getAllFlowers(int page, int taille) {
        return fleurRepository.findAll(PageRequest.of(page, taille));
    }

    @Override
    public Page<Fleur> searchFlowers(String keyword, int page, int taille) {
        return fleurRepository.findByNomContains(keyword, PageRequest.of(page, taille));
    }

    @Override
    public List<Fleur> getByKeyword(String keyword) {
        return null;
    }


    @Override
    public Fleur getFlowerById(Integer id) {
        return fleurRepository.findById(id).get();
    }

    @Override
    public Fleur updateFlower(Fleur fleur) {
        return produitRepository.save(fleur);
    }

    @Override
    public boolean deleteFlower(Integer id) {
        try {
            produitRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<Fleur> getAllFlowers() {
        return fleurRepository.findAll();    }


}