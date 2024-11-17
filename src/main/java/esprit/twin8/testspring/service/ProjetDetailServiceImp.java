package esprit.twin8.testspring.service;

import esprit.twin8.testspring.entity.ProjetDetail;
import esprit.twin8.testspring.repository.ProjetDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProjetDetailServiceImp implements IProjetDetailService{
    ProjetDetailRepository pdrepository;
    public List<ProjetDetail> retrieveAllProjetDetails() {
        return pdrepository.findAll();
    }

    public ProjetDetail retrieveProjetDetail(Long ProjetDetailId) {
        return pdrepository.findById(ProjetDetailId).get();
    }

    public ProjetDetail addProjetDetail(ProjetDetail c) {
        return pdrepository.save(c);
    }

    public void removeProjetDetail(Long ProjetDetailId) {
        pdrepository.deleteById(ProjetDetailId);

    }

    public ProjetDetail modifyProjetDetail(ProjetDetail ProjetDetail) {
        return pdrepository.save(ProjetDetail);
    }
}
