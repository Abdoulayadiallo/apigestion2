package com.odc.apigestionregion.service;

import com.odc.apigestionregion.modele.Region;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

public interface RegionService {
    Region ajouter(Region region);

    List<Region> Lister();

    Region modifier(Long id, Region region);

    String supprimer(Long id);

    Iterable<Object> RegionSansPays();

    Iterable<Object> RegionAvecPays();
}
