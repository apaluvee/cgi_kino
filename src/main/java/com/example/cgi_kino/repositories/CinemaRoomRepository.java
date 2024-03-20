package com.example.cgi_kino.repositories;

import com.example.cgi_kino.models.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {
}
