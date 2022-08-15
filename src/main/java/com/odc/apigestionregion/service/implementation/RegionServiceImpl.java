package com.odc.apigestionregion.service.implementation;

import com.odc.apigestionregion.modele.Region;
import com.odc.apigestionregion.repository.RegionRepository;
import com.odc.apigestionregion.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository regionRepository;
    @Override
    public Region ajouter(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> Lister() {
        return regionRepository.findAll();
    }

    @Override
    public Region modifier(Long id, Region region) {
        return regionRepository.findById(id)
                .map(r->{
                    r.setCoderegion(region.getCoderegion());
                    r.setNom(region.getNom());
                    r.setDomaine_activite(region.getDomaine_activite());
                    r.setLangue(region.getLangue());
                    r.setSuperficie(region.getSuperficie());
                    return regionRepository.save(r);
                }).orElseThrow(()-> new RuntimeException("Region non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        regionRepository.deleteById(id);
        return "region supprimé";
    }

    @Override
    public Iterable<Object> RegionSansPays() {
        return regionRepository.RegionSansPays();
    }

    @Override
    public Iterable<Object> RegionAvecPays() {
        return regionRepository.RegionAvecPays();
    }
}
