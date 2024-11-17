package esprit.twin8.testspring.service;

import esprit.twin8.testspring.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> retrieveAllEquipes();
    public Equipe retrieveEquipe(Long EquipeId);
    public Equipe addEquipe(Equipe c);
    public void removeEquipe(Long EquipeId);
    public Equipe modifyEquipe(Equipe Equipe);
    public void assignProjetToEquipe(Long projetId, Long equipeId);
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId);


    }
