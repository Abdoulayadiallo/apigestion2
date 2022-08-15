package com.odc.apigestionregion.service.implementation;


import com.odc.apigestionregion.modele.Pays;
import com.odc.apigestionregion.repository.PaysRepository;
import com.odc.apigestionregion.service.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaysServiceImpl implements PaysService {
    @Autowired
    PaysRepository paysRepository;
    @Override
    public Pays ajouter(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public List<Pays> Lister() {
        return paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long id, Pays pays) {
        return paysRepository.findById(id)
                .map(p -> {
                    p.setNom(pays.getNom());
                    return paysRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Region non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        paysRepository.deleteById(id);
        return "Pays supprimé avec succès";
    }

    @Override
    public Iterable<Object[]> lireFIND_PAYS_REGION_POPULATION_ANNEE_NBHABITANT(String pays) {
        return paysRepository.FIND_PAYS_REGION_POPULATION_ANNEE_NBHABITANT(pays);
    }


}
