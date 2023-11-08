CREATE TABLE Book (
                      book_id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      author_id INT,
                      FOREIGN KEY (author_id) REFERENCES Author(author_id)

);