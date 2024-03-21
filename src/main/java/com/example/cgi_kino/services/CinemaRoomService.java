package com.example.cgi_kino.services;

import com.example.cgi_kino.dto.CinemaRoomDto;
import com.example.cgi_kino.dto.SeatDto;

import java.util.List;

public interface CinemaRoomService {

    CinemaRoomDto addCinemaRoom(CinemaRoomDto cinemaRoomDto);

    CinemaRoomDto getCinemaRoom(Long id);

    List<CinemaRoomDto> getAllCinemaRooms();

    CinemaRoomDto updateCinemaRoom(CinemaRoomDto cinemaRoomDto, Long id);

    void deleteCinemaRoom(Long id);

    CinemaRoomDto getCinemaRoomWithSeats(Long id);

    CinemaRoomDto markSeatsAsTaken(Long cinemaRoomId, List<Long> seatIds);

    SeatDto getSeatByRowAndNumber(Long roomId, int row, int seatNumber);

}
