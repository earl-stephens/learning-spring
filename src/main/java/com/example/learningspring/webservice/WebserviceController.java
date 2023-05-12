package com.example.learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningspring.business.GuestService;
import com.example.learningspring.business.ReservationService;
import com.example.learningspring.business.RoomReservation;
import com.example.learningspring.business.RoomService;
import com.example.learningspring.data.Guest;
import com.example.learningspring.data.Room;
import com.example.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	private final GuestService guestService;
	private final RoomService roomService;
	
	public WebserviceController(DateUtils dateUtils, 
			ReservationService reservationService, 
			GuestService guestService, 
			RoomService roomService) {
		super();
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
		this.guestService = guestService;
		this.roomService = roomService;
	}
	
	@RequestMapping(path = "/reservations", method=RequestMethod.GET)
	public List<RoomReservation> getReservations(@RequestParam(value="date", required=false) String dateString) {
		Date date = dateUtils.createDateFromDateString(dateString);
		
		return reservationService.getRoomReservationForDate(date);
	}
	
	@RequestMapping(path="/guests", method=RequestMethod.GET)
	public List<Guest> getGuests() {
		return guestService.getHotelGuests();
	}
	
	@RequestMapping(path="/rooms", method=RequestMethod.GET)
	public List<Room> getRooms() {
		return roomService.getRooms();
	}
	
	@PostMapping("/guests")
	@ResponseStatus(HttpStatus.CREATED)
	public void addGuest(@RequestBody Guest guest) {
		guestService.addGuest(guest);
	}
}
