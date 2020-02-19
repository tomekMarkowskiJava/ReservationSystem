package reservingSystem.controller;

import java.util.List;

import reservingSystem.entity.Reservation;
import reservingSystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping(value = {"/", "/index"})
	public String openHomePage(Model model) {
		
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("allReservations", (List<Reservation>)reservationRepository.findAll());
		return "index";
	}
	
	@PostMapping(value = {"/", "/index"})
	public String addComment(@ModelAttribute("reservation") Reservation reservation
			, Model model) {
		
		reservationRepository.save(reservation);
		
		model.addAttribute("allReservations", (List<Reservation>)reservationRepository.findAll());
		return "redirect:/index"; //
	}

}
