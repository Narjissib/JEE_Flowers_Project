package ma.xproce.flowerspro.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_produit", discriminatorType = DiscriminatorType.STRING)
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String description;
    private double prix;
    @Lob
    private String image;
    @OneToMany(mappedBy = "produit")
    private Collection<Panier> paniers;
    @OneToMany(mappedBy = "produit")
    private Collection<Favori> favoris;




}
