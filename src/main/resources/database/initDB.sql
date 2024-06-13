
CREATE TABLE document (
                          id SERIAL PRIMARY KEY,
                          document_name VARCHAR(255),
                          document_description TEXT,
                          name VARCHAR(255),
                          lastname VARCHAR(255),
                          number VARCHAR(50),
                          address TEXT,
                          email VARCHAR(255),
                          document_content TEXT,
                          created_at TIMESTAMP
);

-- SELECT * FROM document
