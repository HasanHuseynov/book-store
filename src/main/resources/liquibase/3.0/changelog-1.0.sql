CREATE TABLE Author (
                        author_id SERIAL PRIMARY KEY,
                        user_id INT UNIQUE,
                        name VARCHAR(255) NOT NULL,
                        age INT,
                        FOREIGN KEY (user_id) REFERENCES User_account(user_id)
);