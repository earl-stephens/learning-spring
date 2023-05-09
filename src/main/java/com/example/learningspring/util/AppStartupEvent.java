package com.example.learningspring.util;

import java.util.Date;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.learningspring.business.ReservationService;
import com.example.learningspring.business.RoomReservation;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
	//use this to make sure the application and db are set up
	//before querying the db

	private ReservationService reservationService;
	private DateUtils dateUtils;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Date date = this.dateUtils.createDateFromDateString("2022-01-01");
		List<RoomReservation> reservations = this.reservationService.getRoomReservationForDate(date);
		
		reservations.forEach(System.out::println);
	}

}
