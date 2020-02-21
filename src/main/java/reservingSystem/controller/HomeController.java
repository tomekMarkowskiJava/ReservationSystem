package reservingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import reservingSystem.entity.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	private MailController mailController;
	private Reservation reservation;

	@Autowired
	public HomeController(MailController mailController, Reservation reservation) {
		this.mailController = mailController;
		this.reservation = reservation;
	}

	@GetMapping(value = {"/", "/index"})
	public String openHomePage(Model model) {
		
		model.addAttribute("reservation", new Reservation());
		return "index";
	}
	
	@PostMapping(value = {"/", "/index"})
	public String makeReservation(@ModelAttribute("reservation") Reservation reservation
			, Model model) {
		

		model.addAttribute("userName", reservation.getName());
		model.addAttribute("userMail", reservation.getEmail());
//		model.addAttribute("allReservations", (List<Reservation>)reservationRepository.findAll());
		mailController.send(reservation.getName(), reservation.getEmail());

		return "redirect:/index"; //
	}

}
