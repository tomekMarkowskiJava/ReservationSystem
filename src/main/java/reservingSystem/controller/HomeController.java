package reservingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import reservingSystem.entity.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reservingSystem.entity.ReservationConverter;

@Controller
public class HomeController {

	private MailController mailController;
	private Reservation reservation;
	private ReservationConverter reservationConverter;

	@Autowired
	public HomeController(MailController mailController, Reservation reservation, ReservationConverter reservationConverter) {
		this.mailController = mailController;
		this.reservation = reservation;
		this.reservationConverter = reservationConverter;
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
	public String makeReservation(Reservation newReservation
			, Model model) {

		model.addAttribute("reservation", newReservation);
		reservationConverter.convert(newReservation);
		mailController.sendToClient(reservation);
		mailController.sendToAdmin(reservation);
		return "confirmation";
	}

}
