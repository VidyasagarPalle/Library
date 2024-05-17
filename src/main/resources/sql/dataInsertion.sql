
use testdb;

INSERT INTO Library (library_name, start_time, end_time) VALUES ('Central Library', '08:00:00', '18:00:00');
INSERT INTO Library (library_name, start_time, end_time) VALUES ('Community Library', '09:00:00', '17:00:00');
INSERT INTO Library (library_name, start_time, end_time) VALUES ('University Library', '07:30:00', '22:00:00');
INSERT INTO Library (library_name, start_time, end_time) VALUES ('City Library', '08:30:00', '20:00:00');


INSERT INTO Rack (library_id, row_number, column_number) VALUES (1, 1, 1);
INSERT INTO Rack (library_id, row_number, column_number) VALUES (2, 1, 2);
INSERT INTO Rack (library_id, row_number, column_number) VALUES (3, 2, 1);
INSERT INTO Rack (library_id, row_number, column_number) VALUES (4, 1, 1);
INSERT INTO Rack (library_id, row_number, column_number) VALUES (1, 2, 1);



INSERT INTO Book (rack_id, book_name, description) VALUES (1, 'Introduction to Algorithms', 'A comprehensive guide to algorithms and data structures.');
INSERT INTO Book (rack_id, book_name, description) VALUES (1, 'Clean Code', 'Tips and principles for writing clean, maintainable code.');
