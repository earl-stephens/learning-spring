package com.example.learningspring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.learningspring.data.Room;
import com.example.learningspring.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{
	//use this to make sure the application and db are set up
	//before querying the db
	
	private final RoomRepository roomRepository;
	
	public AppStartupEvent(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = this.roomRepository.findAll();
		rooms.forEach(System.out::println);
	}

}
