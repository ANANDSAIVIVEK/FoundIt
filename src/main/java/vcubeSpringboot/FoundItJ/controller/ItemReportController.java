package vcubeSpringboot.FoundItJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vcubeSpringboot.FoundItJ.model.ItemReport;
import vcubeSpringboot.FoundItJ.service.ItemReportService;

@RestController
@RequestMapping("/reports")
public class ItemReportController {
	
	@Autowired
	ItemReportService service;
	
    // Create a new report
	 @PostMapping("/save")
	    public ItemReport createReport(@RequestBody ItemReport report) {
	        return service.saveReport(report);
	    }
	 // Get All Reports
	 @GetMapping("/get")
	 public List<ItemReport> getAllReports(){
		 return service.getAllReports();
	 }
	 
	 @GetMapping("get/{id}")
	 public ItemReport getReportById(@PathVariable Long id) {
		 return service.getReportById(id);
	 }
	 
	 @DeleteMapping("delete/{id}")
		 public String deleteReport(@PathVariable Long id){
			  service.deleteReport(id);
			  return "Report Deleted Successfully";
		 }
	 
	 @PutMapping("update/{id}")
		 public ItemReport updateReport(@PathVariable Long id, @RequestBody ItemReport report) {
			 return service.updateReport(id, report);
		 }
	 
	 
	 
	 

}
