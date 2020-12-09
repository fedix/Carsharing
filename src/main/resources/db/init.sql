create database carsharing;
\c  carsharing;

CREATE TABLE users
(
    id         uuid PRIMARY KEY NOT NULL,
    name       VARCHAR          NOT NULL,
    email      VARCHAR          NOT NULL,
    is_renting Boolean          NOT NULL
);

CREATE TABLE cars
(
    id           uuid PRIMARY KEY NOT NULL,
    name         VARCHAR          NOT NULL,
    color        VARCHAR          NOT NULL,
    plate_number VARCHAR          NOT NULL,
    lat          NUMERIC          NOT NULL,
    lon         NUMERIC          NOT NULL,
    fuel         NUMERIC          NOT NULL,
    is_occupied  Boolean          NOT NULL,
    occupied_by  uuid, -- or occupierId?
    price        NUMERIC          NOT NULL
);

CREATE TABLE actions
(
    action    VARCHAR NOT NULL,--car rented, car left
    userId    uuid    NOT NULL,
    carId     uuid    NOT NULL,
    timestamp TIMESTAMP DEFAULT now()
);

INSERT INTO users
VALUES ('00000000-0000-0000-0000-000000000001',
        'John',
        'john.smith@example.com',
        false);

INSERT INTO cars
VALUES ('00000000-0000-0000-0000-100000000001',
        'kia rio',
        'black',
        'в172ан78',
        50.348923484978173,
        35.348923484978173,
        0.8,
        false,
        null,
        0.0);
