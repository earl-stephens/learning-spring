package com.example.learningspring.data;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RESERVATION_ID")
	private long reservationId;
	
	@Column(name="ROOM_ID")
	private long roomId;
	
	@Column(name="GUEST_ID")
	private long guestId;
	
	@Column(name="RES_DATE")
	private Date reservationDate;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public Date getResDate() {
		return reservationDate;
	}

	public void setResDate(Date resDate) {
		this.reservationDate = resDate;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + 
				", roomId=" + roomId + 
				", guestId=" + guestId + 
				", resDate=" + reservationDate + "]";
	}
}
