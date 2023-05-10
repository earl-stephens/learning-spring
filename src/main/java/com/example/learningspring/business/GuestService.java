package com.example.learningspring.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Iterable<Guest> findAllGuests() {
		return guestRepository.findAll();
	}
}
