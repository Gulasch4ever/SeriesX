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
	
	
	
	@RequestMapping(value = { "listSeries" })
	public String showAllSeries(Model model) {
		
		
		
		
		
		
		return "listSeries";
	}
	
}
