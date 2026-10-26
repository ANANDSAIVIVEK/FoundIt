package vcubeSpringboot.FoundItJ.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vcubeSpringboot.FoundItJ.model.ItemReport;

@Repository
public interface ItemReportRepo extends JpaRepository<ItemReport, Long>{

	
}
