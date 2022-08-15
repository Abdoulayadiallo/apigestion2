package com.odc.apigestionregion.modele;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_population;
    private String chiffre;
    private String annee;



}
