package com.odc.apigestionregion.service;
import com.odc.apigestionregion.modele.Pays;



import java.util.List;


public interface PaysService {
    Pays ajouter(Pays pays);
    List<Pays> Lister();
    Pays modifier(Long id, Pays pays);

    String supprimer(Long id);
    Iterable<Object[]>  lireFIND_PAYS_REGION_POPULATION_ANNEE_NBHABITANT(String pays);
}
