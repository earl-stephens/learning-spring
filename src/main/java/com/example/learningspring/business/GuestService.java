package com.example.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.learningspring.data.Guest;
import com.example.learningspring.data.GuestRepository;

@Service
public class GuestService {
	private final GuestRepository guestRepository;

	public GuestService(GuestRepository guestRepository) {
		super();
		this.guestRepository = guestRepository;
	}
	
	public List<Guest> getHotelGuests() {
		Iterable<Guest> guests = guestRepository.findAll();
		List<Guest> guestList = new ArrayList<>();
		
		guests.forEach(guest -> {guestList.add(guest);});
		
		guestList.sort(new Comparator<Guest>() {
			@Override
			public int compare(Guest o1, Guest o2) {
				if(o1.getLastName().equals(o2.getLastName())) {
					return o1.getFirstName().compareTo(o2.getFirstName());
				} 
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		return guestList;
	}
}
