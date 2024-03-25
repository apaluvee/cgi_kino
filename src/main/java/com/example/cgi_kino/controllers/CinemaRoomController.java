package com.example.cgi_kino.controllers;

import com.example.cgi_kino.dto.CinemaRoomDto;
import com.example.cgi_kino.services.CinemaRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cinema-room")
@AllArgsConstructor
public class CinemaRoomController {

    private CinemaRoomService cinemaRoomService;

    @PostMapping
    public ResponseEntity<CinemaRoomDto> addCinemaRoom(@RequestBody CinemaRoomDto cinemaRoomDto) {

        CinemaRoomDto savedCinemaRoom = cinemaRoomService.addCinemaRoom(cinemaRoomDto);

        return new ResponseEntity<>(savedCinemaRoom, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CinemaRoomDto> getCinemaRoom(@PathVariable("id") Long cinemaRoomId){
        CinemaRoomDto cinemaRoomDto = cinemaRoomService.getCinemaRoom(cinemaRoomId);
        return new ResponseEntity<>(cinemaRoomDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CinemaRoomDto>> getAllCinemaRooms() {
        List<CinemaRoomDto> cinemaRooms = cinemaRoomService.getAllCinemaRooms();
        return ResponseEntity.ok(cinemaRooms);
    }

    @PostMapping("{id}")
    public ResponseEntity<CinemaRoomDto> updateCinemaRoom(@RequestBody CinemaRoomDto cinemaRoomDto,@PathVariable("id") Long cinemaRoomId){
        CinemaRoomDto updatedCinemaRoom = cinemaRoomService.updateCinemaRoom(cinemaRoomDto, cinemaRoomId);
        return ResponseEntity.ok(updatedCinemaRoom);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCinemaRoom(@PathVariable("id") Long cinemaRoomId) {
        cinemaRoomService.deleteCinemaRoom(cinemaRoomId);
        return ResponseEntity.ok("Cinema room deleted!");
    }

    @GetMapping("{id}/seats")
    public ResponseEntity<CinemaRoomDto> getCinemaRoomWithSeats(@PathVariable("id") Long cinemaRoomId) {
        CinemaRoomDto cinemaRoomDto = cinemaRoomService.getCinemaRoomWithSeats(cinemaRoomId);
        return ResponseEntity.ok(cinemaRoomDto);
    }

    @PatchMapping("{id}/seats")
    public ResponseEntity<Void> markSeatsAsTaken(@PathVariable("id") Long cinemaRoomId, @RequestBody List<Long> seatIds) {
        cinemaRoomService.markSeatsAsTaken(cinemaRoomId, seatIds);
        return ResponseEntity.noContent().build();
    }



}
