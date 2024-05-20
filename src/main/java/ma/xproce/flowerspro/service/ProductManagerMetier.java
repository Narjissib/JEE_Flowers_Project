package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Produit;
import ma.xproce.flowerspro.dao.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerMetier implements ProductManager{

    @Autowired
    private ProduitRepository productRepository;

    @Override
    public Produit addProduit(Produit produit) {
        return productRepository.save(produit);
    }

    @Override
    public Page<Produit> getAllProduits(int page, int taille) {
        return null;
    }

    @Override
    public Page<Produit> searchProduits(String keyword, int page, int taille) {
        return null;
    }

    @Override
    public List<Produit> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public Produit getProduitById(Integer id) {
        return null;
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return null;
    }

    @Override
    public boolean deleteProduit(Integer id) {
        return false;
    }
}
