package com.example.learningspring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.learningspring.business.GuestService;
import com.example.learningspring.data.Guest;

@Controller
@RequestMapping("/guests")
public class GuestController {

	private final GuestService guestService;

	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {
		model.addAttribute("guests", guestService.getHotelGuests());
		
		return "hotel-guests";
	}
}
