package ma.xproce.flowerspro.service;

import ma.xproce.flowerspro.dao.entities.Adresse;
import ma.xproce.flowerspro.dao.entities.Arbre;
import ma.xproce.flowerspro.dao.entities.Panier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdresseManager {
    public Adresse addAdresse(Adresse adresse);
    public List<Adresse> getAllAdresses();
}
