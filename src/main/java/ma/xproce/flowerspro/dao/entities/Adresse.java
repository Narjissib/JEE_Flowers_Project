package ma.xproce.flowerspro.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rue;
    private String ville;
    private String pays;
    @OneToMany(mappedBy = "adresseLivraison", fetch = FetchType.EAGER)
    private Collection<Commande> commandes;


}
