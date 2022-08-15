package com.odc.apigestionregion.controller;

import com.odc.apigestionregion.modele.Pays;
import com.odc.apigestionregion.service.PaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "hello", description = "API pour la gestion d'un pays")
@RestController
@RequestMapping("/apigestion/pays")
@Data
public class controllerPays {
    @Autowired
    PaysService paysService;
    @ApiOperation(value = "Ajouter un pays")
    @PostMapping("/Ajouter")
    public Pays ajouter(@RequestBody Pays pays){
        return this.paysService.ajouter(pays);
    }
    @ApiOperation(value = "Lister les pays")
    @GetMapping(value = "/Lister")
    public List<Pays> lister(){
        return paysService.Lister();

    }
    @ApiOperation(value = "Modifier un pays")
    @PutMapping("/Modifier/{id}")
    public Pays modifier(@RequestBody Pays pays,@PathVariable Long id){
        return paysService.modifier(id,pays);
    }

    @ApiOperation(value = "Supprimer un pays")
    @DeleteMapping("/Supprimer/{id}")
    public String supprimer(@PathVariable Long id,@RequestBody Pays pays){
        this.paysService.supprimer(id);
        return "Pays supprimé avec succès";
    }
    @ApiOperation(value = "Just to test the sample tet api of My app Service")
    @GetMapping("/Lister/{pays}")
    public Iterable<Object[]> lireFIND_PAYS_REGION_POPULATION_ANNEE_NBHABITANT(@PathVariable String pays) {
        return paysService.lireFIND_PAYS_REGION_POPULATION_ANNEE_NBHABITANT(pays);
    }


}
