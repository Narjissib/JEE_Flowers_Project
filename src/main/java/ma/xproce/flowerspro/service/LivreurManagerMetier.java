package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Livreur;
import ma.xproce.flowerspro.dao.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreurManagerMetier implements LivreurManager {
    @Autowired
    LivreurRepository livreurRepository;

    @Override
    public Livreur addLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    @Override
    public Livreur getLivreurById(Integer id) {
        return livreurRepository.findById(id).get();
    }



    @Override
    public Livreur deleteLivreur(Livreur livreur) {
        return null;
    }

    @Override
    public boolean deleteLivreur(Integer id) {
        try {
            livreurRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<Livreur> getAllLivreurs() {
        return livreurRepository.findAll();
    }
}
