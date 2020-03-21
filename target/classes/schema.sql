CREATE TABLE book (
    id serial PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    publication_date DATE NOT NULL DEFAULT CURRENT_DATE,
    language VARCHAR(50),
    thumbnail_image VARCHAR(355),
    price numeric NOT NULL
);
