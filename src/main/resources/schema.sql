CREATE TABLE IF NOT EXISTS users (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     role VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        quantity INT NOT NULL,
                                        borrowed INT NOT NULL,
                                        product_type VARCHAR(255) NOT NULL
);