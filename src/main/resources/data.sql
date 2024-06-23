-- Insert clients
INSERT INTO client (id, nom, email) VALUES
(1, 'Alice Dupont', 'alice.dupont@example.com'),
(2, 'Bob Martin', 'bob.martin@example.com'),
(3, 'Charlie Duval', 'charlie.duval@example.com');

-- Insert kitty
INSERT INTO kitty (id, client_id, amount, checkout) VALUES
(1, 1, 15.00, 4), -- Alice Dupont a une cagnotte disponible
(2, 2, 8.00, 3), -- Bob Martin n'a pas encore assez pour être disponible
(3, 3, 5.00, 2); -- Charlie Duval n'a pas encore assez pour être disponible
