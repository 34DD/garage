/*-- Insertion de rôles
INSERT INTO roles (id, name) VALUES (1, 'USER');
INSERT INTO roles (id, name) VALUES (2, 'ADMIN');

-- Insertion d'utilisateurs
INSERT INTO users (id, username, password, enabled) VALUES (1, 'admin', '$2a$12$LiWQkYumpRdfGbdB6/GaRucSnRT6DrXvBnLOc7o4ztj.ye8mt7JCe', true);

-- Insertion de relations utilisateur/role si nécessaire
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);*/
