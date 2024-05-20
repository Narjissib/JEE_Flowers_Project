package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Adresse;
import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseManagerMetier implements AdresseManager{
    @Autowired
    AdresseRepository adresseRepository;
    @Override
    public Adresse addAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }
}
