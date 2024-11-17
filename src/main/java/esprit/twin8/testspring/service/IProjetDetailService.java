package esprit.twin8.testspring.service;



import esprit.twin8.testspring.entity.ProjetDetail;

import java.util.List;

public interface IProjetDetailService {
    public List<ProjetDetail> retrieveAllProjetDetails();
    public ProjetDetail retrieveProjetDetail(Long ProjetDetailId);
    public ProjetDetail addProjetDetail(ProjetDetail c);
    public void removeProjetDetail(Long ProjetDetailId);
    public ProjetDetail modifyProjetDetail(ProjetDetail ProjetDetail);

}
