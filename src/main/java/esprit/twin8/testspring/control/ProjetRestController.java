package esprit.twin8.testspring.control;

import esprit.twin8.testspring.entity.Projet;
import esprit.twin8.testspring.service.IProjetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//http://localhost:8089/testSpring/swagger-ui/index.html#/ : Pour tester avec sawgger


@RestController
@AllArgsConstructor
@Tag(name=" gestion de projet")
@RequestMapping("/Projet")
public class ProjetRestController {
    IProjetService projetService;
    // http://localhost:8089/testSpring/Projet/getAll
    @GetMapping("/getAll")
    public List<Projet> retrieveAllProjet(){
        List<Projet> Projets = projetService.retrieveAllProjets();
        return Projets;
    }
    // http://localhost:8089/testSpring/Projet/getProjet/{Projet-id}
    @GetMapping("/getProjet/{Projet-id}")
    public Projet retrieveProjet(@PathVariable("Projet-id") Long  ProjetId){
        Projet Projet = projetService.retrieveProjet(ProjetId);
        return Projet;
        // http://localhost:8089/testSpring/Projet/addProjet
    }@PostMapping("/addProjet")
    public Projet addProjet(@RequestBody Projet b){
        Projet Projet = projetService.addProjet(b);
        return Projet;
    }
    //http://localhost:8089/testSpring/Projet/delete-Projet/3
    @DeleteMapping("/delete-Projet/{Projet-id}")
    public void removeProjet(@PathVariable("Projet-id") Long  ProjetId){
        projetService.removeProjet(ProjetId);

    }
    //http://localhost:8089/testSpring/Projet/modifier-Projet
    @PutMapping("/modifier-Projet")
    public Projet modifyProjet( @RequestBody Projet b){
        Projet Projet =projetService.modifyProjet(b);
        return Projet;

    }

    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet p) {
        Projet projet = projetService.addProjetAndProjetDetailAndAssign(p);
        return projet;
    }
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecgterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId,
                                            @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetService.assignProjetDetailToProjet(proejtId, proejtDetailsId);}
@PostMapping("/creer-projet-et-affecterProjet-detail-a-projet/{projetDetailId}")
    public Projet addProjetAndAssignProjetToProjetDetail( @RequestBody Projet projet, @PathVariable Long projetDetailId) {
    Projet projet1 = projetService.addProjetAndAssignProjetToProjetDetail(projet, projetDetailId);
    return projet1;
}
@PutMapping("/desaffecterProjetDetailFromProjet/{projet-id}")
    public Projet DesaffecterProjetDetailFromProjet(@PathVariable("projet-id") Long projetId) {
       Projet p = projetService.DesaffecterProjetDetailFromProjet(projetId);
       return p;

}


    }
