package com.example.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.learningspring.data.Room;
import com.example.learningspring.data.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository roomRepository;

	public RoomService(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}
	
	public List<Room> getRooms() {
		Iterable<Room> rooms = roomRepository.findAll();
		List<Room> roomList = new ArrayList<>();
		
		rooms.forEach(room -> {roomList.add(room);});
		
		roomList.sort(new Comparator<Room>() {
			@Override
			public int compare(Room o1, Room o2) {
				if(o1.getName().equals(o2.getName())) {
					return o1.getRoomNumber().compareTo(o2.getRoomNumber());
				}
				return o1.getName().compareTo(o2.getName());
			}
		});
		return roomList;
	}
}
