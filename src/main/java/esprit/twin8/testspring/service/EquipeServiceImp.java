package esprit.twin8.testspring.service;

import esprit.twin8.testspring.entity.Equipe;
import esprit.twin8.testspring.entity.Projet;
import esprit.twin8.testspring.repository.EquipeRepository;
import esprit.twin8.testspring.repository.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeServiceImp  implements IEquipeService{
    private final ProjetRepository projetRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe retrieveEquipe(Long EquipeId) {
        return equipeRepository.findById(EquipeId).get();
    }

    @Override
    public Equipe addEquipe(Equipe c) {
        return equipeRepository.save(c);
    }

    @Override
    public void removeEquipe(Long EquipeId) {
        equipeRepository.deleteById(EquipeId);

    }

    @Override
    public Equipe modifyEquipe(Equipe Equipe) {
        return equipeRepository.save(Equipe);
    }
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
// on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }
    @PutMapping("/{projetId}/{equipeId}")
    public void desaffecterProjetFromEquipe(@PathVariable("projetId") Long projetId, @PathVariable("equipeId") Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
// on enlève le fils du parent :
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }

}
