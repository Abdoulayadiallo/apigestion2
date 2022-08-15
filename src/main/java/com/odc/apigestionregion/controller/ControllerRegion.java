package com.odc.apigestionregion.controller;

import com.odc.apigestionregion.modele.Region;
import com.odc.apigestionregion.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@RestController
@RequestMapping("/apigestion/region")
@Data
@Api(value = "Gestion", description = "Une api pour la gestion des regions")
public class ControllerRegion {
    @Autowired
    RegionService regionService;

    @ApiOperation(value = "ajouter une region")
    @PostMapping("/Ajouter")
    public Region ajouter(@RequestBody Region region){
        return this.regionService.ajouter(region);

    }


    @ApiOperation(value = "Lister tous les regions")
    @GetMapping(value = "/Lister")
    public List<Region> lister(){
        return regionService.Lister();

    }

    @ApiOperation(value = "Modifier une region par son id")
    @PutMapping("/Modifier/{id}")
    public Region modifier(@PathVariable Long id,@RequestBody Region region){
        return regionService.modifier(id,region);
    }

    @ApiOperation(value = "Supprimer un region par son id")
    @DeleteMapping("/Supprimer/{id}")
    public String Supprimer(@PathVariable Long id){
        this.regionService.supprimer(id);
        return "Supprimer avec succès";
    }

    @ApiOperation(value = "La liste des regions sans pays")
    @GetMapping("/RegionSansPays")
    public Iterable<Object> RegionSansPays() {
        return regionService.RegionSansPays();
    }

    @ApiOperation(value = "La liste des regions avec leurs pays")
    @GetMapping("/RegionAvecPays")
    public Iterable<Object> RegionAvecPays() {
        return regionService.RegionAvecPays();
    }


}
