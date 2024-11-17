package esprit.twin8.testspring.repository;

import esprit.twin8.testspring.entity.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetDetailRepository extends
        JpaRepository<ProjetDetail, Long> {
}
