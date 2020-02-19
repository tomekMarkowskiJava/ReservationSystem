package reservingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import reservingSystem.entity.Reservation;
import reservingSystem.repository.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	private ReservationRepository reservationRepository;
	private MailController mailController;

	@Autowired
	public HomeController(ReservationRepository reservationRepository, MailController mailController) {
		this.reservationRepository = reservationRepository;
		this.mailController = mailController;
	}

	@GetMapping(value = {"/", "/index"})
	public String openHomePage(Model model) {
		
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("allReservations", (List<Reservation>)reservationRepository.findAll());
		return "index";
	}
	
	@PostMapping(value = {"/", "/index"})
	public String makeReservation(@ModelAttribute("reservation") Reservation reservation
			, Model model) {
		
		reservationRepository.save(reservation);
		
		model.addAttribute("allReservations", (List<Reservation>)reservationRepository.findAll());
		mailController.send(reservation.getName(), reservation.getEmail());

		return "redirect:/index"; //
	}

}
