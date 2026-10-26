package vcubeSpringboot.FoundItJ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vcubeSpringboot.FoundItJ.model.ItemReport;
import vcubeSpringboot.FoundItJ.repo.ItemReportRepo;

@Service
public class ItemReportServiceImpl implements ItemReportService {
	
	@Autowired
	 private final ItemReportRepo repo;
	
	public ItemReportServiceImpl(ItemReportRepo repo) {
        this.repo = repo;
    }
	
	@Override
	public ItemReport saveReport(ItemReport report) {
		return repo.save(report);
	}

	@Override
	// Get all item reports
    public List<ItemReport> getAllReports() {
        return repo.findAll();
    }
	
	 @Override
	    public ItemReport getReportById(Long id) {
	        return repo.findById(id)
	                .orElseThrow(() ->
	                    new RuntimeException("Report not found with ID: " + id));
	    }
	 
	// Update
	    @Override
	    public ItemReport updateReport(Long id, ItemReport report) {

	        ItemReport existingReport = repo.findById(id)
	                .orElseThrow(() ->
	                    new RuntimeException("Report not found with ID: " + id));

	        existingReport.setTitle(report.getTitle());
	        existingReport.setDescription(report.getDescription());
	        existingReport.setCategory(report.getCategory());
	        existingReport.setLocation(report.getLocation());
	        existingReport.setItemDate(report.getItemDate());
	        existingReport.setReportType(report.getReportType());
	        existingReport.setStatus(report.getStatus());

	        return repo.save(existingReport);
	    }
	    
	 // Delete
	    @Override
	    public void deleteReport(Long id) {

	        if (!repo.existsById(id)) {
	            throw new RuntimeException("Report not found with ID: " + id);
	        }

	        repo.deleteById(id);
	    }

	 
}
