INSERT INTO `authorities` (id,user_type) VALUES (1, 'ROLE_ADMIN'), (2,'ROLE_REGISTEREDUSER');

INSERT INTO `users` (dtype, id, username, password) VALUES 
('Admin', 1, 'admin', '$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO');

INSERT INTO `users` (dtype, id, username, password, knowledge, first_name, last_name) VALUES 
('RegisteredUser', 2, 'user', '$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO', 'ADVANCED', 'Pera', 'Peric');

INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1), (2, 2);

INSERT INTO `recipe` (id, complexity, name, prepared, price, time_prep, rec_type, imgURL) VALUES
	(1, 'EASY', 'Recipe1', 7, 2, 15, 'SALAD', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg'),
	(2, 'MEDIUM', 'Recipe2', 10, 2, 15, 'SIDE_DISH', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg'),
	(3, 'HARD', 'Recipe3', 10, 2, 15, 'DESSERT', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg'),
	(4, 'EASY', 'Recipe4', 8, 2, 15, 'MAIN', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg'),
	(5, 'EASY', 'Recipe5', 9, 2, 15, 'MAIN', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg'),
	(6, 'EASY', 'Recipe6', 1, 2, 15, 'SIDE_DISH', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg'),
	(7, 'EASY', 'Recipe7', 0, 2, 15, 'SIDE_DISH', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg'),
	(8, 'MEDIUM', 'Recipe8', 0, 2, 15, 'SALAD', 'https://storcpdkenticomedia.blob.core.windows.net/media/recipemanagementsystem/media/recipe-media-files/recipes/retail/x17/2019_df_retail_triple-chocolate-truffle-bars_20430_cropped_760x580.jpg?ext=.jpg');
	
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
	(1, 'step 3'),
	(1, 'step 4'),
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
INSERT INTO `grade` (id, grade, recipe_id, user_id) VALUES
	(1, 5, 3, 2);