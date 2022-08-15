package com.odc.apigestionregion.repository;

import com.odc.apigestionregion.modele.Pays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaysRepository extends JpaRepository<Pays, Long> {
    @Query(value = "SELECT pays.nom as pays, region.nom, population.annee, population.chiffre FROM pays,region,population WHERE region.id =pays.id AND population.id_population = region.id AND pays.nom =:pays", nativeQuery = true )
    public Iterable<Object[]> FIND_PAYS_REGION_POPULATION_ANNEE_NBHABITANT(String pays);

}
