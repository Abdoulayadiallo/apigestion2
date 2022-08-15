package com.odc.apigestionregion.controller;

import com.odc.apigestionregion.modele.Population;
import com.odc.apigestionregion.service.PopulationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "hello", description = "Gestion de la population")
@RestController
@RequestMapping("/apigestion/population")
@Data
public class controllerPopulation {
@Autowired
PopulationService populationService;

    @ApiOperation(value = "Ajouter une population")
    @PostMapping("/Ajouter")
    public Population ajouter(@RequestBody Population population){
        return this.populationService.ajouter(population);

    }
    @ApiOperation(value = "Modifier le nombre de la population")
    @PutMapping("/Modifier/{id_population}")
    public Population modifier(@RequestBody Population population,@PathVariable Long id_population){
        return populationService.modifier(id_population, population);
    }
    @ApiOperation(value = "Supprimer une population")
    @DeleteMapping("/Supprimer/{id}")
    public String Supprimer(@PathVariable Long id){
        this.populationService.supprimer(id);
        return "Supprimer avec succès";
    }
}
