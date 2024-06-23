CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL
);


CREATE TABLE kitty (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          client_id BIGINT NOT NULL,
                          amount DOUBLE NOT NULL,
                          checkout INT NOT NULL,
                          FOREIGN KEY (client_id) REFERENCES client(id)
);
