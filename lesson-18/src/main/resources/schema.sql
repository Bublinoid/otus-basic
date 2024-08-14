create table users (
id SERIAL PRIMARY KEY,
username VARCHAR(255) UNIQUE NOT NULL,
password_hash VARCHAR(60) NOT NULL,
role VARCHAR(10) NOT NULL
);