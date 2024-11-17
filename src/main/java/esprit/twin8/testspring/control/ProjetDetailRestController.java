package esprit.twin8.testspring.control;

import esprit.twin8.testspring.entity.ProjetDetail;
import esprit.twin8.testspring.service.IProjetDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ProjetDetail")
@AllArgsConstructor
@Tag(name="Gestion details projets")
public class ProjetDetailRestController {
    IProjetDetailService ProjetDetailService;
    // http://localhost:8089/testSpring/ProjetDetail/getAll
    @GetMapping("/getAll")
    public List<ProjetDetail> retrieveAllProjetDetail(){
        List<ProjetDetail> ProjetDetails = ProjetDetailService.retrieveAllProjetDetails();
        return ProjetDetails;
    }
    // http://localhost:8089/testSpring/ProjetDetail/getProjetDetail/{ProjetDetail-id}
    @GetMapping("/getProjetDetail/{ProjetDetail-id}")
    public ProjetDetail retrieveProjetDetail(@PathVariable("ProjetDetail-id") Long ProjetDetailId){
        ProjetDetail ProjetDetail = ProjetDetailService.retrieveProjetDetail(ProjetDetailId);
        return ProjetDetail;
        // http://localhost:8089/testSpring/ProjetDetail/addProjetDetail
    }@PostMapping("/addProjetDetail")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail b){
        ProjetDetail ProjetDetail = ProjetDetailService.addProjetDetail(b);
        return ProjetDetail;
    }
    //http://localhost:8089/testSpring/ProjetDetail/delete-ProjetDetail/3
    @DeleteMapping("/delete-ProjetDetail/{ProjetDetail-id}")
    public void removeProjetDetail(@PathVariable("ProjetDetail-id") Long ProjetDetailId){
        ProjetDetailService.removeProjetDetail(ProjetDetailId);

    }
    //http://localhost:8089/testSpring/ProjetDetail/modifier-ProjetDetail
    @PutMapping("/modifier-ProjetDetail")
    public ProjetDetail modifyProjetDetail( @RequestBody ProjetDetail b){
        ProjetDetail ProjetDetail =ProjetDetailService.modifyProjetDetail(b);
        return ProjetDetail;

    }
}
