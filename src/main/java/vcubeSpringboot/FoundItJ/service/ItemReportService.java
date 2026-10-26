package vcubeSpringboot.FoundItJ.service;

import java.util.List;

import vcubeSpringboot.FoundItJ.model.ItemReport;

public interface ItemReportService {

	ItemReport saveReport(ItemReport report);
	
	List<ItemReport> getAllReports();
	
	ItemReport getReportById(Long Id);
	
	ItemReport updateReport(Long Id, ItemReport report);
	
	 void deleteReport(Long id);
	
}
