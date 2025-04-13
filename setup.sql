CREATE DATABASE natsdb;

\c natsdb

CREATE TABLE messages (
    id SERIAL PRIMARY KEY,
    content TEXT NOT NULL,
);