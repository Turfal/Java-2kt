CREATE TABLE IF NOT EXISTS document (
                          id SERIAL PRIMARY KEY,
                          document_name VARCHAR(255),
                          document_description TEXT,
                          document_content TEXT,
                          created_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    lastname VARCHAR(255),
    number VARCHAR(50),
    address TEXT,
    email VARCHAR(255),
    created_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS payment (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(id),
    created_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS invoice (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(id),
    payment_id INT REFERENCES payment(id),
    created_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(id),
    invoice_id INT REFERENCES invoice(id),
    created_at TIMESTAMP
)
-- SELECT * FROM document
