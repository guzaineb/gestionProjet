package esprit.twin8.testspring.repository;

import esprit.twin8.testspring.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
