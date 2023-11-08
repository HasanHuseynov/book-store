CREATE TABLE Student (
                         student_id SERIAL PRIMARY KEY,
                         user_id INT UNIQUE,
                         name VARCHAR(255) NOT NULL,
                         age INT,
                         book_id INT,
                         FOREIGN KEY (user_id) REFERENCES User_account(user_id),
                         FOREIGN KEY (book_id) REFERENCES Book(book_id)
);
