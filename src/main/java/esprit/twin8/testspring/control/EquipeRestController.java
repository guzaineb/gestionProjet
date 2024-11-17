package esprit.twin8.testspring.control;

import esprit.twin8.testspring.entity.Equipe;
import esprit.twin8.testspring.service.IEquipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor

@RequestMapping("/Equipe")
@Tag(name="Gestion d'équipe")

public class EquipeRestController {
    IEquipeService equipeService;
    // http://localhost:8089/testSpring/Equipe/getAll
    @Operation(description = "tous les équipe")
    @GetMapping("/getAll")
    public List<Equipe> retrieveAllEquipe(){
        List<Equipe> Equipes = equipeService.retrieveAllEquipes();
        return Equipes;
    }
    // http://localhost:8089/testSpring/Equipe/getEquipe/{Equipe-id}
    @GetMapping("/getEquipe/{Equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("Equipe-id") Long EquipeId){
        Equipe Equipe = equipeService.retrieveEquipe(EquipeId);
        return Equipe;
        // http://localhost:8089/testSpring/Equipe/addEquipe
    }@PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe b){
        Equipe Equipe = equipeService.addEquipe(b);
        return Equipe;
    }
    //http://localhost:8089/testSpring/Equipe/delete-Equipe/3
    @DeleteMapping("/delete-Equipe/{Equipe-id}")
    public void removeEquipe(@PathVariable("Equipe-id") Long EquipeId){
        equipeService.removeEquipe(EquipeId);

    }
    //http://localhost:8089/testSpring/Equipe/modifier-Equipe
    @PutMapping("/modifier-Equipe")
    public Equipe modifyEquipe( @RequestBody Equipe b){
        Equipe Equipe =equipeService.modifyEquipe(b);
        return Equipe;

    }
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{equipe-id}")
    public void assignProjetToEquipe(@PathVariable("projet-id") Long proejtId,
                                            @PathVariable("equipe-id") Long equipeId) {
        equipeService.assignProjetToEquipe(proejtId, equipeId);
    }
    @PutMapping("/desaffecterProjetFromEquipe/{projet-id}/{equipe-id}")

    public void desaffecterProjetFromEquipe(
           @PathVariable("projetId") Long projetId,@PathVariable Long equipeId) {
        equipeService.desaffecterProjetFromEquipe(projetId, equipeId);
    }

    }
