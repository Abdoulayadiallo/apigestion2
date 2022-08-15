package com.odc.apigestionregion.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String coderegion;
    private String nom;
    private String domaine_activite;
    private String superficie;
    private String langue;

    @ManyToMany
    List<Population> population;

    @ManyToOne
    private Pays pays;



}
