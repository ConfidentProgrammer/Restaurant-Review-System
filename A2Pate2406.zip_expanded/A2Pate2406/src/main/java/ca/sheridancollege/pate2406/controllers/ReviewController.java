package ca.sheridancollege.pate2406.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate2406.beans.Restaurant;
import ca.sheridancollege.pate2406.database.DatabaseAccess;

@Controller
public class ReviewController {
	@Autowired
	private DatabaseAccess da;
	
	
	@GetMapping("/add")
	public String index(Restaurant res, Model model) {
		model.addAttribute("res", res);
		return "index";
	}
	@PostMapping("/")
	public String addreview(@ModelAttribute Restaurant res, Model model) {
		model.addAttribute("res", res);
		da.insertReview(res);
		return "index";
	}
	
	@GetMapping("/")
	public String getAllReviews(Model model) {
		ArrayList<Restaurant> review = da.getAllReviews();
		model.addAttribute("res", review);
		return "view";
	}
	
}
