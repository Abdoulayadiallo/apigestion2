package com.odc.apigestionregion.repository;

import com.odc.apigestionregion.modele.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegionRepository extends JpaRepository<Region,Long> {

    @Query(value = "SELECT region.nom FROM region,pays WHERE pays.id = region.pays_id",nativeQuery = true)
    Iterable<Object> RegionSansPays();

    @Query(value = "SELECT DISTINCT pays.nom,region.nom AS region FROM region,pays WHERE pays.id = region.pays_id",nativeQuery = true)
    Iterable<Object> RegionAvecPays();
}
