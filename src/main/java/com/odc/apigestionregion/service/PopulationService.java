package com.odc.apigestionregion.service;

import com.odc.apigestionregion.modele.Population;

public interface PopulationService {
    Population ajouter(Population population);
    Population modifier(Long id_population, Population population);

    String supprimer(Long id_population);
}
