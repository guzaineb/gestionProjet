package esprit.twin8.testspring.service;

import esprit.twin8.testspring.entity.Projet;
import esprit.twin8.testspring.entity.ProjetDetail;
import esprit.twin8.testspring.repository.ProjetDetailRepository;
import esprit.twin8.testspring.repository.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProjetServiceImp implements IProjetService{
    private final ProjetDetailRepository projetDetailRepository;
    ProjetRepository projetRepository;
    public List<Projet> retrieveAllProjets() {
        return projetRepository.findAll();
    }


    public Projet retrieveProjet(Long  ProjetId) {
        return projetRepository.findById(ProjetId).get();
    }


    public Projet addProjet(Projet c) {
        return projetRepository.save(c);
    }


    public void removeProjet(Long  ProjetId) {
        projetRepository.deleteById(ProjetId);

    }


    public Projet modifyProjet(Projet Projet) {
        return projetRepository.save(Projet);
    }


    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId){
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);

    }
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }





}
