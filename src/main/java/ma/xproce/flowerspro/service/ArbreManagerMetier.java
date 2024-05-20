package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.dao.repositories.ArbreRepository;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbreManagerMetier implements ArbreManager{
    private final ArbreRepository arbreRepository;
    private final ProduitRepository produitRepository;

    public ArbreManagerMetier(ArbreRepository arbreRepository, ProduitRepository produitRepository) {
        this.arbreRepository = arbreRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public Arbre addArbre(Arbre arbre) {
        return produitRepository.save(arbre);
    }

    @Override
    public Page<Arbre> getAllArbrs(int page, int taille) {
        return arbreRepository.findAll(PageRequest.of(page, taille));
    }
    @Override

    public List<Arbre> getAllArbrs() {
        return arbreRepository.findAll();
    }


    @Override
    public Page<Arbre> searchArbres(String keyword, int page, int taille)
    {
        return arbreRepository.findByNomContains(keyword, PageRequest.of(page, taille));
    }

    @Override
    public List<Arbre> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public Arbre getArbreById(Integer id) {
        return arbreRepository.findById(id).get();
    }

    @Override
    public Arbre updateArbre(Arbre arbre) {
        return produitRepository.save(arbre);
    }

    @Override
    public boolean deleteArbre(Integer id) {
        try {
            produitRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }    }
}
