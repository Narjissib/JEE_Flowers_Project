package ma.xproce.flowerspro.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.xproce.flowerspro.dao.entities.Panier;
import ma.xproce.flowerspro.dao.entities.Produit;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String motDePasse;
/*
    @OneToMany(mappedBy = "utilisateur")
    private Collection<Panier> paniers;

    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
    private Collection<Favori> favoris;
    @OneToMany(mappedBy = "utilisateur")
    private Collection<Commande> commandes;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Collection<Adresse> adresses;
*/

}