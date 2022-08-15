package com.odc.apigestionregion.service.implementation;

import com.odc.apigestionregion.modele.Population;
import com.odc.apigestionregion.repository.PopulationRepository;
import com.odc.apigestionregion.service.PopulationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PopulationServiceImpl implements PopulationService {
@Autowired
PopulationRepository populationRepository;
    @Override
    public Population ajouter(Population population) {
        return populationRepository.save(population);
    }

    @Override
    public Population modifier(Long id_population, Population population) {
        return populationRepository.findById(id_population)
                .map(pp->{
                    pp.setChiffre(population.getChiffre());
                    return populationRepository.save(pp);
                }).orElseThrow(() -> new RuntimeException("Population n'existe pas"));
    }

    @Override
    public String supprimer(Long id_population) {
        populationRepository.deleteById(id_population);
        return "Population supprimé";

    }
}
