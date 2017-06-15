package at.fh.seriesX.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.seriesX.dao.SeriesRepository;

@Controller 
public class SeriesController {

	@Autowired
	SeriesRepository seriesRepository;
	
	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {
		
		return "index";
	}
	// more to come!
	
	@RequestMapping("/fillSeriesList")
	public String fillSeriesList() {
		
		String dec1 = "dfsiuhsadhufoasdhfdsahofidshafdsih";
 
		
		
		//SeriesModel hIMYMother = new SeriesModel("How I Met Your Mother",""
		
		
		return "forward:/listSeries";
	}
	
	@RequestMapping(value = { "listSeries" })
	public String showAllSeries(Model model) {
		
		return "listSeries";
	}
	
}
