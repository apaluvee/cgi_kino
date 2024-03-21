package com.example.cgi_kino.services.impl;

import com.example.cgi_kino.dto.CinemaRoomDto;
import com.example.cgi_kino.dto.SeatDto;
import com.example.cgi_kino.models.CinemaRoom;
import com.example.cgi_kino.models.Seat;
import com.example.cgi_kino.repositories.CinemaRoomRepository;
import com.example.cgi_kino.services.CinemaRoomService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CinemaRoomServiceImpl implements CinemaRoomService {

    private CinemaRoomRepository cinemaRoomRepository;

    private ModelMapper modelMapper;

    @Override
    public CinemaRoomDto addCinemaRoom(CinemaRoomDto cinemaRoomDto) {

        CinemaRoom cinemaRoom = modelMapper.map(cinemaRoomDto, CinemaRoom.class);

        List<Seat> cinemaRoomSeats = new ArrayList<>();
        for (int row = 1; row <= 8; row++) {
            for (int seatNumber = 1; seatNumber <= 15; seatNumber++) {
                Seat seat = new Seat();
                seat.setRow(row);
                seat.setNumber(seatNumber);
                seat.setTaken(false);
                seat.setCinemaRoom(cinemaRoom);
                cinemaRoomSeats.add(seat);
            }
        }

        cinemaRoom.setSeats(cinemaRoomSeats);

        CinemaRoom savedCinemaRoom = cinemaRoomRepository.save(cinemaRoom);

        return modelMapper.map(savedCinemaRoom, CinemaRoomDto.class);
    }

    @Override
    public CinemaRoomDto getCinemaRoom(Long id) {

        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        return modelMapper.map(cinemaRoom, CinemaRoomDto.class);
    }

    @Override
    public List<CinemaRoomDto> getAllCinemaRooms() {

        List<CinemaRoom> cinemaRooms = cinemaRoomRepository.findAll();

        return cinemaRooms.stream().map((cinemaRoom) -> modelMapper.map(cinemaRoom, CinemaRoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CinemaRoomDto updateCinemaRoom(CinemaRoomDto cinemaRoomDto, Long id) {

        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        cinemaRoom.setTitle(cinemaRoomDto.getTitle());

        if (cinemaRoomDto.getSeats() != null) {
            for (SeatDto seatDto : cinemaRoomDto.getSeats()) {

                Optional<Seat> optionalSeat = cinemaRoom.getSeats().stream()
                        .filter(seat -> seat.getId().equals(seatDto.getId()))
                        .findFirst();
                if (optionalSeat.isPresent()) {
                    Seat seat = optionalSeat.get();
                    seat.setTaken(seatDto.isTaken());
                    seat.setRow(seatDto.getRow());
                    seat.setNumber(seatDto.getNumber());
                }
            }
        }

        CinemaRoom updateCinemaRoom = cinemaRoomRepository.save(cinemaRoom);

        return modelMapper.map(updateCinemaRoom, CinemaRoomDto.class);
    }


    @Override
    public void deleteCinemaRoom(Long id) {

        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        cinemaRoomRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public CinemaRoomDto getCinemaRoomWithSeats(Long id) {

        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        CinemaRoom updatedCinemaRoom = cinemaRoomRepository.save(cinemaRoom);

        return modelMapper.map(updatedCinemaRoom, CinemaRoomDto.class);
    }


    @Override
    public CinemaRoomDto markSeatsAsTaken(Long id, List<Long> seatIds) {

        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Not found: " + id));

        for (Long seatId : seatIds) {
            Optional<Seat> optionalSeat = cinemaRoom.getSeats().stream()
                    .filter(seat -> seat.getId().equals(seatId))
                    .findFirst();
            if (optionalSeat.isPresent()) {
                Seat seat = optionalSeat.get();
                seat.setTaken(true);
            }
        }

        CinemaRoom updatedCinemaRoom = cinemaRoomRepository.save(cinemaRoom);

        return modelMapper.map(updatedCinemaRoom, CinemaRoomDto.class);
    }

    @Override
    public SeatDto getSeatByRowAndNumber(Long roomId, int row, int seatNumber) {
        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(Math.toIntExact(roomId))
                .orElseThrow(() -> new RuntimeException("Cinema room not found: " + roomId));

        List<Seat> seats = cinemaRoom.getSeats();

        Optional<Seat> optionalSeat = seats.stream()
                .filter(seat -> seat.getRow() == row && seat.getNumber() == seatNumber)
                .findFirst();

        if (optionalSeat.isPresent()) {
            return modelMapper.map(optionalSeat.get(), SeatDto.class);
        } else {
            return null;
        }
    }

}