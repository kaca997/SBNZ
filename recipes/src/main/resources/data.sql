-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: recipes
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_REGISTEREDUSER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_authority`
--

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Admin',1,NULL,NULL,'$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO','admin',NULL),('RegisteredUser',2,'Pera','Peric','$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO','user','ADVANCED'),('RegisteredUser',3,'Jova','Jovic','$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO','user2','INTERMEDIATE'),('RegisteredUser',4,'Mara','Maric','$2a$10$dd7baWr6v5Kgd6U0qIKdBOiVSMX.89afQAI3.cQjkTyjrDbY3DElO','user3','BEGINER'),('RegisteredUser',5,'Neda','Nedic','$2a$10$hlkdLnPIP3IeZfwc0zjjre7dlk8jX6cKHWMWZitOFe7NrWU/wKxKC','neda','BEGINER'),('RegisteredUser',6,'Mika','Mikic','$2a$10$XB7BIrLWEmGACzURd.7ikuSzfwpSSIBEePvyXm9sMYjSURsi.Lb7i','mika','ADVANCED');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (1,1),(2,2),(3,2),(4,2),(5,2),(6,2);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'HARD','https://domacirecepti.net/wp-content/uploads/2018/03/gulas-od-svinjskog-vrata.jpg','Gulas',1,200,200,'MAIN'),(2,'EASY','https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Tatarsk%C3%A1_om%C3%A1%C4%8Dka.jpg/220px-Tatarsk%C3%A1_om%C3%A1%C4%8Dka.jpg','tartar sos',2,100,10,'SIDE_DISH'),(3,'MEDIUM','https://cdn.sallysbakingaddiction.com/wp-content/uploads/2019/06/Tiramisu-6-600x900.jpg','tiramisu',0,150,30,'DESSERT'),(4,'EASY','https://1.bp.blogspot.com/-QPLfl8jFVe0/UZHc60G25jI/AAAAAAAADJk/gf3JbZJXAzo/s1600/6246-grcka-salata.jpg','grčka salata',1,200,15,'SALAD'),(5,'EASY','https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Chopska.jpg/300px-Chopska.jpg','sopska salata',2,70,10,'SALAD'),(6,'MEDIUM','https://static.mondo.rs/Picture/877951/jpeg/GettyImages-820497982.jpg','cezar salata',0,300,30,'SALAD'),(7,'EASY','https://scontent.fbeg5-1.fna.fbcdn.net/v/t1.0-9/10923518_10153872848934368_158691422209172890_n.jpg?_nc_cat=106&_nc_sid=2d5d41&_nc_ohc=3M-z7x_KnAYAX_NI-DD&_nc_ht=scontent.fbeg5-1.fna&oh=18ad8a4fb22b860b12c7f339ace9c0ce&oe=5F02ABB6','jagode sa slagom',2,200,15,'DESSERT'),(8,'MEDIUM','https://nitrocdn.com/iRwsMXPEdaMSNBlSqLBkXmjSJwoqRrps/assets/static/optimized/rev-012f94e/wp-content/uploads/2019/01/How-to-Make-Tzatziki-overhead.jpg','tzatziki',2,300,15,'SIDE_DISH'),(9,'MEDIUM','https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSXMX6hQv09qbwT8VZ2U_Qi9hci1eerm4WpQL7SCLELT0Ov0N8W&usqp=CAU','rizoto sa kackavaljem',1,300,30,'SIDE_DISH'),(10,'HARD','https://domacirecepti.net/wp-content/uploads/2012/10/pasulj-sa-suvim-mesom.jpg','pasulj sa suvim mesom',0,400,150,'MAIN'),(11,'HARD','https://kuvar-recepti.info/images/Kuhinja5/piletina_sos.jpg','piletina u belom sosu',1,500,60,'MAIN'),(12,'HARD','https://stil.kurir.rs/data/images/2016/03/07/11/82290_puslica_ls.jpg','puslica',1,600,250,'DESSERT');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hates`
--

LOCK TABLES `hates` WRITE;
/*!40000 ALTER TABLE `hates` DISABLE KEYS */;
INSERT INTO `hates` VALUES (2,'paprika'),(5,'paprika'),(5,'luk'),(5,'vanila'),(6,'riba');
/*!40000 ALTER TABLE `hates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (2,'krastavac'),(2,'pavlaka'),(3,'pavlaka'),(5,'cokolada'),(5,'jagode'),(5,'paradajz'),(6,'pavlaka');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grade`
--

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,'junetina'),(1,'crni luk'),(1,'sargarepa'),(1,'paprika'),(1,'brasno'),(1,'zacini'),(2,'pavlaka'),(2,'majonez'),(2,'kiseli krastavac'),(2,'beli luk'),(2,'limun'),(2,'mirodjija'),(3,'piškote'),(3,'nes kafa'),(3,'jaja'),(3,'secer'),(3,'maskapone'),(4,'feta sir'),(4,'krastavac'),(4,'paradajz'),(4,'crni luk'),(4,'masline'),(4,'paprika'),(4,'origan'),(4,'maslinovo ulje'),(5,'krastavac'),(5,'paradajz'),(5,'paprika'),(5,'luk'),(5,'sir'),(6,'piletina'),(6,'zelena salata'),(6,'paradajz'),(6,'crveni luk'),(6,'hleb'),(6,'senf'),(6,'limun'),(6,'parmezan'),(6,'ulje'),(7,'slag'),(7,'mleko'),(7,'jagode'),(8,'krastavac'),(8,'pavlaka'),(8,'beli luk'),(8,'mirodjija'),(8,'limun'),(9,'pirinac'),(9,'crni luk'),(9,'beli luk'),(9,'kackavalj'),(9,'belo vino'),(9,'kocka za supu'),(9,'sargarepa'),(10,'pasulj'),(10,'crni luk'),(10,'sargarepa'),(10,'suvo meso'),(10,'brasno'),(10,'mlevena paprika'),(10,'lovorov list'),(10,'zacini'),(11,'pavlaka za kuvanje'),(11,'piletina'),(11,'sargarepa'),(11,'tikvice'),(11,'belo vino'),(11,'ulje'),(11,'limun'),(11,'zacini'),(12,'jaja'),(12,'cokolada'),(12,'secer'),(12,'margarin'),(12,'slag');
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping data for table `steps`
--

LOCK TABLES `steps` WRITE;
/*!40000 ALTER TABLE `steps` DISABLE KEYS */;
INSERT INTO `steps` VALUES (1,'iseci luk i sargarepu'),(1,'dodati zacine'),(1,'proprziti'),(1,'dodati meso iseceno na kockice'),(1,'kada meso porumeni naliti vodom i dinstati'),(1,'za zaprsku umutiti brasno i papriku sa mlakom vodom da ne bude grudvica'),(1,'dodati zaprsku kada posle otprilike 2 sata kada meso bude mekano'),(1,'krckati jos 10 minuta uz povremeno mesanje'),(2,'iseckati krastac i beli luk'),(2,'dodati malo limunovog soka'),(2,'pomesati sa ostalim sastojcima'),(3,'razdvojiti belanca od zumanaca'),(3,'umutiti belanca sa 8 kasika secera'),(3,'umutiti zumanca sa 8 kasika secera, a potom dodati maskapone sir i dalje mutiti'),(3,'spojiti smese od belanaca i zumanaca i lagano promesati'),(3,'umakati piskote u prethodno pripremljenu nes kafu i naredjati'),(3,'potom odozgo staviti fil'),(3,'ponoviti ovaj postupak jos jednom'),(4,'iseci luk, krastavac, paradajz i papriku'),(4,'dodati sir i masline i preliti maslinovim uljem'),(4,'dodati preko origano'),(5,'iseci povrce, posoliti i dodati preko sir'),(6,'proprziti piletinu na ulju'),(6,'potom u istom tiganju iseci hleb na kockice i proprziti'),(6,'iseci povrce'),(6,'napraviti dresing od limuna, maslinovog ulja i senfa'),(6,'sve pomesati, dodati preko dresing i parmezan'),(7,'ocistiti jagode'),(7,'umutiti slag'),(7,'pomesati'),(8,'narendati krastavac i ostaviti da se ocedi'),(8,'narendati beli luk'),(8,'dodati lumun'),(8,'posoliti'),(8,'pomesati sa pavlakom'),(8,'dodati mirodjiju preko'),(9,'proprziti luk i sargarepu na ulju'),(9,'dodati pirinac i prziti jos malo'),(9,'dodati vino i prziti dok ne ispari'),(9,'kada ispari, naliti vodom'),(9,'i dodati kocku za supu'),(9,'kada je voda ispari i pirinac je gotov narendati kackavalj'),(9,'promesati'),(10,'ostaviti pasulj preko noci da odstoji u vodi'),(10,'sutradan skuvati u vodi dok ne provri'),(10,'prosuti vodu, i sipati novu toplu vodu'),(10,'dodati crni luk'),(10,'dodati lovorov list'),(10,'dodati suvo meso'),(10,'ukoliko fali vode, dodajte toplu vodu'),(10,'kada je pasulj skuvan, napraviti zaprsku'),(10,'proprzite u tiganju brasno i mlevenu papriku'),(10,'dodati u pasulj'),(10,'dodati zacine po zelji'),(10,'kuvati jos 5 min'),(11,'iseci sargarepu na listice'),(11,'kratko proprziti'),(11,'iseci mesto na kockice'),(11,'dodati u sargarepu i prziti jos malo'),(11,'dodati malo belog vina'),(11,'kada je meso pri kraju, dodati tikvice'),(11,'kada je gotovo, dodati pavlaku za kuvanje'),(11,'dodati u to malo limuna i zacina po zelji'),(11,'mesati dok se sos ne ugusti'),(12,'odvojiti belanca od zumanaca'),(12,'izmutiti belanca'),(12,'staviti u rerni na 100 stepeni 2 sata da se korice isuse'),(12,'pomesati zumanca sa secerom'),(12,'kuvati na pari dok se ne zgusti'),(12,'dodati cokoladu i promesati dok se ne istopi'),(12,'ostaviti da se ohladi'),(12,'kada se ohladi, dodati margarin i umutiti'),(12,'potom umutiti slag'),(12,'redom redjati korice, fil, slag u 3 sloja');
/*!40000 ALTER TABLE `steps` ENABLE KEYS */;
UNLOCK TABLES;



LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,5,2,2),(2,5,2,6),(3,4,4,6),(4,1,5,6),(5,5,7,6),(6,4,8,6),(7,4,9,6),(8,5,11,6),(9,5,1,6),(10,5,12,6);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `users_grades`
--

LOCK TABLES `users_grades` WRITE;
/*!40000 ALTER TABLE `users_grades` DISABLE KEYS */;
INSERT INTO `users_grades` VALUES (2,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7),(6,8),(6,9),(6,10);
/*!40000 ALTER TABLE `users_grades` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-09 13:01:34
