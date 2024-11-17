package esprit.twin8.testspring.repository;

import esprit.twin8.testspring.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long > {
}
