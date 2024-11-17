package esprit.twin8.testspring.service;

import esprit.twin8.testspring.entity.Projet;

import java.util.List;

public interface IProjetService {
    public List<Projet> retrieveAllProjets();
    public Projet retrieveProjet(Long  ProjetId);
    public Projet addProjet(Projet c);
    public void removeProjet(Long  ProjetId);
    public Projet modifyProjet(Projet Projet);
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public Projet addProjetAndProjetDetailAndAssign(Projet projet);
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) ;




    }
