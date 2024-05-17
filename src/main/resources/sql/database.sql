CREATE TABLE Library (
    id INT AUTO_INCREMENT PRIMARY KEY,
    library_name VARCHAR(255) NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL
);

CREATE TABLE Rack (
    id INT AUTO_INCREMENT PRIMARY KEY,
    library_id INT NOT NULL,
    row_number INT NOT NULL,
    column_number INT NOT NULL,
    FOREIGN KEY (library_id) REFERENCES Library(id)
);

CREATE TABLE Book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rack_id INT NOT NULL,
    book_name VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    FOREIGN KEY (rack_id) REFERENCES Rack(id)
);


