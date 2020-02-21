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

	@Autowired
	public HomeController(MailController mailController) {
		this.mailController = mailController;
	}

	@GetMapping(value = {"/", "/index"})
	public String openHomePage(Model model) {
		
		model.addAttribute("reservation", new Reservation());
		return "index";
	}

	@GetMapping("/confirmation")
	public String openConfirmationPage(@ModelAttribute ("reservation") Reservation reservation, Model model){
		model.addAttribute("userName", reservation.getName());
		model.addAttribute("userMail", reservation.getEmail());
		return "confirmation";
	}
	
	@PostMapping(value = {"/confirmation"})
	public String makeReservation(@ModelAttribute("reservation") Reservation reservation
			, Model model) {

		mailController.send(reservation.getName(), reservation.getEmail());

		return "confirmation";
	}

}
