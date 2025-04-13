CREATE TABLE messages (
    id SERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    timestamp TIMESTAMP NOT NULL
);