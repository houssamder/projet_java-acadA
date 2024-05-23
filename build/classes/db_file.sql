-- Table: patient
CREATE TABLE patient (
    nss VARCHAR(20),
    nom VARCHAR(50),
    prenom VARCHAR(50),
    adresse VARCHAR(100),
    telephone VARCHAR(20),
    email VARCHAR(100),
    date_naissance DATE,
    PRIMARY KEY (nss)
);

-- Table: employe
CREATE TABLE employe (
    code_employe INT AUTO_INCREMENT,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    secteur VARCHAR(50),
    specialite VARCHAR(100),
    anciennete INT,
    login VARCHAR(50),
    password VARCHAR(50),
    PRIMARY KEY (code_employe)
);

-- Table: reservation
CREATE TABLE reservation (
    numero_reservation INT AUTO_INCREMENT,
    nss VARCHAR(20),
    date_reservation DATE,
    type VARCHAR(50),
    service VARCHAR(100),
    etat INT,
    PRIMARY KEY (numero_reservation),
    FOREIGN KEY (nss) REFERENCES patient(nss)
);

-- Table: consultation
CREATE TABLE consultation (
    numero_consultation INT AUTO_INCREMENT,
    nss VARCHAR(20),
    date_consultation DATE,
    service VARCHAR(100),
    etat VARCHAR(20),
    PRIMARY KEY (numero_consultation),
    FOREIGN KEY (nss) REFERENCES patient(nss)
);

-- Table: avis
CREATE TABLE avis (
    nss VARCHAR(20),
    commentaire TEXT,
    note INT,
    numero_consultation INT,
    FOREIGN KEY (nss) REFERENCES patient(nss),
    FOREIGN KEY (numero_consultation) REFERENCES consultation(numero_consultation)
);

-- Insert some mocked data

-- Mocked patients
INSERT INTO patient (nss, nom, prenom, adresse, telephone, email, date_naissance) VALUES
('123456789', 'John', 'Doe', '123 Main St', '123-456-7890', 'john@example.com', '1980-01-01'),
('987654321', 'Jane', 'Smith', '456 Elm St', '987-654-3210', 'jane@example.com', '1975-05-10');

-- Mocked employees
INSERT INTO employe (nom, prenom, secteur, specialite, anciennete, login, password) VALUES
('Smith', 'Alice', 'Medical', 'Cardiology', 5, 'alice_smith', 'password123'),
('Johnson', 'Bob', 'Surgical', 'Orthopedic Surgery', 8, 'bob_johnson', 'securepass');

-- Mocked reservations
INSERT INTO reservation (nss, date_reservation, type, service, etat) VALUES
('123456789', '2024-04-25', 'New Patient', 'Cardiology', 1),
('987654321', '2024-04-27', 'Follow-up', 'Orthopedic Surgery', 0);

-- Mocked consultations
INSERT INTO consultation (nss, date_consultation, service, etat) VALUES
('123456789', '2024-04-28', 'Cardiology', 'Completed'),
('987654321', '2024-04-29', 'Orthopedic Surgery', 'Scheduled');

-- Mocked avis
INSERT INTO avis (nss, commentaire, note, numero_consultation) VALUES
('123456789', 'Great service!', 5, 1),
('987654321', 'Could be better.', 3, 2);
