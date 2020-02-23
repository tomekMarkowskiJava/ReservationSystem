package reservingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import reservingSystem.entity.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		model.addAttribute("reservation", reservation);
		reservation.reset();
		return "index";
	}

	@GetMapping("/confirmation")
	public String openConfirmationPage(Model model){
		model.addAttribute("reservation", reservation);
		return "confirmation";
	}
	
	@PostMapping(value = {"/confirmation"})
	public String makeReservation(Model model) {

		model.addAttribute("reservation", reservation);
//		reservation.setName(newReservation.getName());
//		reservation.setEmail(newReservation.getEmail());
//		reservation.setBed(newReservation.getBed());
		mailController.send(reservation);
		return "confirmation";
	}

}
