CREATE TABLE User_account (
                      user_id SERIAL PRIMARY KEY,
                      email VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      role VARCHAR(10) NOT NULL
);