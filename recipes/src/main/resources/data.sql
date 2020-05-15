INSERT INTO `authorities` (id,user_type) VALUES (1, 'ROLE_ADMIN'), (2,'ROLE_REGISTEREDUSER');

INSERT INTO `users` (dtype, id, username, password) VALUES ('Admin', 1, 'admin', '$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO'), ('RegisteredUser', 2, 'user', '$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1), (2, 2);