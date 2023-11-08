CREATE TABLE Subscriptions (
                               subscription_id SERIAL PRIMARY KEY,
                               subscriber_id INT,
                               author_id INT,
                               FOREIGN KEY (subscriber_id) REFERENCES Student(student_id),
                               FOREIGN KEY (author_id) REFERENCES Author(author_id)
);
