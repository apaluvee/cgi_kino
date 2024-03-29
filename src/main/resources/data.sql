INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('R', 'Drama', 'English', '1994-10-14 19:00:00', 'The Shawshank Redemption');

-- Insert cinema room and get the generated id
INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('R', 'Drama', 'English', '1994-10-14 19:00:00', 'The Shawshank Redemption');

-- Insert 8 rows of seats for the cinema room
INSERT INTO Seat (row, number, taken, cinema_room_id)
SELECT row_idx, seat_idx, FALSE, (SELECT id FROM cinema_room WHERE id = 1)
FROM (
    SELECT row_idx, seat_idx
    FROM generate_series(1, 8) AS row_idx
    CROSS JOIN generate_series(1, 15) AS seat_idx
) AS seat_data;

INSERT INTO movie(age_rating, genre, language, start_time, title)
VALUES ('R', 'Crime', 'English', '1972-03-24 18:30:00', 'The Godfather');

-- Insert cinema room and get the generated id
INSERT INTO cinema_room(age_rating, genre, language, start_time, title)
VALUES ('R', 'Crime', 'English', '1972-03-24 18:30:00', 'The Godfather');

-- Insert 8 rows of seats for the cinema room
INSERT INTO Seat (row, number, taken, cinema_room_id)
SELECT row_idx, seat_idx, FALSE, (SELECT id FROM cinema_room WHERE id = 2)
FROM (
    SELECT row_idx, seat_idx
    FROM generate_series(1, 8) AS row_idx
    CROSS JOIN generate_series(1, 15) AS seat_idx
) AS seat_data;