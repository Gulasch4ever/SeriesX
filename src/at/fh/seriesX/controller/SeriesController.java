package at.fh.seriesX.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class SeriesController {

	
	@RequestMapping(value = { "/", "list" })
	public String index(Model model) {
		
		return "index";
	}
	
	
}
