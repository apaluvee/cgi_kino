-- Insert movies

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('R', 'Drama', 'English', '2024-04-1 19:00:00', 'The Shawshank Redemption');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('PG-13', 'Action', 'English', '2024-04-1 20:00:00', 'The Dark Knight');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('R', 'Drama', 'English', '2024-04-2 18:30:00', 'Pulp Fiction');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('PG', 'Animation', 'English', '2024-04-3 20:30:00', 'The Lion King');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('R', 'Thriller', 'English', '2024-04-3 22:30:00', 'The Silence of the Lambs');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('PG-13', 'Adventure', 'English', '2024-04-4 20:30:00', 'Indiana Jones and the Temple of Doom');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('R', 'Comedy', 'English', '2024-04-5 22:00:00', 'The Hangover');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('PG-13', 'Science Fiction', 'English', '2024-04-5 22:20:00', 'Interstellar');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('PG', 'Fantasy', 'English', '2024-04-6 19:00:00', 'Harry Potter and the Sorcerers Stone');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('R', 'Horror', 'English', '2024-04-6 21:00:00', 'Halloween');

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('PG', 'Family', 'English', '2024-04-7 22:00:00', 'E.T. the Extra-Terrestrial');

-- Insert cinema_rooms

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('R', 'Drama', 'English', '2024-04-1 19:00:00', 'The Shawshank Redemption');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('PG-13', 'Action', 'English', '2024-04-1 20:00:00', 'The Dark Knight');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('R', 'Drama', 'English', '2024-04-2 18:30:00', 'Pulp Fiction');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('PG', 'Animation', 'English', '2024-04-3 20:30:00', 'The Lion King');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('R', 'Thriller', 'English', '2024-04-3 22:30:00', 'The Silence of the Lambs');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('PG-13', 'Adventure', 'English', '2024-04-4 20:30:00', 'Indiana Jones and the Temple of Doom');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('R', 'Comedy', 'English', '2024-04-5 22:00:00', 'The Hangover');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('PG-13', 'Science Fiction', 'English', '2024-04-5 22:20:00', 'Interstellar');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('PG', 'Fantasy', 'English', '2024-04-6 19:00:00', 'Harry Potter and the Sorcerers Stone');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('R', 'Horror', 'English', '2024-04-6 21:00:00', 'Halloween');

INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('PG', 'Family', 'English', '2024-04-7 22:00:00', 'E.T. the Extra-Terrestrial');


-- Insert seats for all cinema rooms
INSERT INTO Seat (row, number, taken, cinema_room_id)
SELECT row_idx, seat_idx,
       CASE WHEN RANDOM() < 0.2 THEN TRUE ELSE FALSE END AS taken,
       cr.id
FROM (
    SELECT id
    FROM cinema_room
) AS cr
CROSS JOIN (
    SELECT row_idx, seat_idx
    FROM generate_series(1, 8) AS row_idx
    CROSS JOIN generate_series(1, 15) AS seat_idx
) AS seat_data;
