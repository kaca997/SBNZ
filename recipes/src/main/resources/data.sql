INSERT INTO `authorities` (id,user_type) VALUES (1, 'ROLE_ADMIN'), (2,'ROLE_REGISTEREDUSER');

INSERT INTO `users` (dtype, id, username, password) VALUES 
('Admin', 1, 'admin', '$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO');

INSERT INTO `users` (dtype, id, username, password, knowledge) VALUES 
('RegisteredUser', 2, 'user', '$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO', 'ADVANCED');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1), (2, 2);

INSERT INTO `recipe` (id, complexity, name, prepared, price, time_prep, rec_type) VALUES
	(1, 'EASY', 'Recipe1', 10, 2, 15, 'SALAD'),
	(2, 'MEDIUM', 'Recipe2', 10, 2, 15, 'SIDE_DISH'),
	(3, 'HARD', 'Recipe3', 10, 2, 15, 'DESSERT'),
	(4, 'EASY', 'Recipe4', 10, 2, 15, 'MAIN'),
	(5, 'EASY', 'Recipe5', 10, 2, 15, 'MAIN'),
	(6, 'EASY', 'Recipe6', 10, 2, 15, 'SIDE_DISH'),
	(7, 'EASY', 'Recipe7', 10, 2, 15, 'SIDE_DISH'),
	(8, 'MEDIUM', 'Recipe8', 10, 2, 15, 'SALAD');
	
INSERT INTO `ingredients` (recipe_id, ingredients) VALUES
	(1, 'krastavac'),
	(1, 'pavlaka'),
	(1, 'majonez'),
	(1, 'beli luk'),
	(2, 'krastavac'),
	(3, 'krastavac'),
	(4, 'krastavac'),
	(5, 'krastavac'),
	(6, 'krastavac'),
	(7, 'krastavac'),
	(8, 'krastavac');
	
INSERT INTO `steps` (recipe_id, steps) VALUES
	(1, 'step1'),
	(1, 'step 2'),
	(1, 'step 4'),
	(1, 'step 3'),
	(2, 'step'),
	(3, 'step'),
	(4, 'step'),
	(5, 'step'),
	(6, 'step'),
	(7, 'step'),
	(8, 'step');
	
INSERT INTO `likes` (registered_user_id, likes) VALUES
	(2, 'krastavac'),
	(2, 'pavlaka');
	
INSERT INTO `hates` (registered_user_id, hates) VALUES
	(2, 'paprika');	