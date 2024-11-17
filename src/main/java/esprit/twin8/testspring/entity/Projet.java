package esprit.twin8.testspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity : auto-incrimente
    private Long id;
    private String sujet;
    @ManyToMany(mappedBy ="projets", fetch = FetchType.EAGER)
    private Set<Equipe>equipes;
    @OneToOne(cascade = CascadeType.ALL)
    private ProjetDetail projetDetail;
}
