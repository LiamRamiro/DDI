CREATE TABLE IF NOT EXISTS REGION (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      nombre VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS ENTRENADOR (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(50),
                                       active BOOLEAN
);

CREATE TABLE IF NOT EXISTS POKEMON (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(50),
                                       region INT,
                                       entrenador INT,
                                       FOREIGN KEY (region) REFERENCES REGION(id),
                                       FOREIGN KEY (entrenador) REFERENCES ENTRENADOR(id)
);