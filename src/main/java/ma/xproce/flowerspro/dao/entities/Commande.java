package ma.xproce.flowerspro.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateCommande;
    private double montantTotal;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Produit> produits;
    @ManyToOne
    private Adresse adresseLivraison;
    @OneToMany(mappedBy = "commande")
    private List<Livraison> livraisons;
}
