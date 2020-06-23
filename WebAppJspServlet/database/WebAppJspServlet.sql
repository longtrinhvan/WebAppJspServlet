drop database webappjspservlet;
create  database webappjspservlet;
use webappjspservlet;
SET GLOBAL log_bin_trust_function_creators = 1;
CREATE TABLE role(
  idrole int NOT NULL PRIMARY KEY auto_increment,
  namerole VARCHAR(255) NOT NULL
);
INSERT INTO `WebAppJspServlet`.`role`(`idrole`,`namerole`)VALUES(1,'USER');
INSERT INTO `WebAppJspServlet`.`role`(`idrole`,`namerole`)VALUES(2,'ADMIN');
CREATE TABLE status(
 idstatus int NOT NULL PRIMARY KEY auto_increment,
 namestatus VARCHAR(255) NULL
);
INSERT INTO `WebAppJspServlet`.`status`(`idstatus`,`namestatus`)
VALUES(1,'Còn');
INSERT INTO `WebAppJspServlet`.`status`(`idstatus`,`namestatus`)
VALUES(2,'Không');
CREATE TABLE user (
  iduser int NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname VARCHAR(150) NULL,
  statusid int NOT NULL,
  roleid int NOT NULL
);
INSERT INTO `WebAppJspServlet`.`user`(`iduser`,`username`,`password`,`fullname`,`statusid`,`roleid`)
VALUES(1,'long@','1','',1,'1');
INSERT INTO `WebAppJspServlet`.`user`(`iduser`,`username`,`password`,`fullname`,`statusid`,`roleid`)
VALUES(2,'user','1','Trịnh Văn A',1,'1');
INSERT INTO `WebAppJspServlet`.`user`(`iduser`,`username`,`password`,`fullname`,`statusid`,`roleid`)
VALUES(3,'user','1','Trịnh Văn B',1,'1');
INSERT INTO `WebAppJspServlet`.`user`(`iduser`,`username`,`password`,`fullname`,`statusid`,`roleid`)
VALUES(4,'admin','1','Trịnh Văn Long',1,'2');

CREATE TABLE producer (
  idproducer int NOT NULL PRIMARY KEY auto_increment,
  nameproducer VARCHAR(255) NULL
);
INSERT INTO `webappjspservlet`.`producer`(`idproducer`,`nameproducer`)
VALUES(1,'Lenovo');
INSERT INTO `webappjspservlet`.`producer`
(`idproducer`,`nameproducer`)
VALUES(2,'SamSung');
INSERT INTO `webappjspservlet`.`producer`(`idproducer`,`nameproducer`)
VALUES(3,'Dell');
INSERT INTO `webappjspservlet`.`producer`(`idproducer`,`nameproducer`)
VALUES(4,'Apple');
CREATE TABLE product (
  idproduct int NOT NULL PRIMARY KEY auto_increment,
  nameproduct VARCHAR(255) NULL,
  price int NULL,
  marketprice int NULL,
  statusid int NOT NULL,
  image VARCHAR(255) NULL,
  producerid int NOT NULL,
  total int NOT NULL
);


CREATE TABLE comment(
idcomment int NOT NULL PRIMARY KEY auto_increment,
idproductcomment int,
idusercomment int,
textcomment LONGTEXT NULL, 
datecomment DATETIME
);

INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(1,51,1,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(2,51,1,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(3,51,2,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(4,51,3,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(5,51,1,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(6,51,1,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(7,51,2,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(8,51,3,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`comment`(`idcomment`,`idproductcomment`,`idusercomment`,`textcomment`,`datecomment`)
VALUES(9,51,2,'Shop cho hỏi chíp gen 10 mạnh hơn gen 8 nhiều không ah ?!','2015-12-25 15:30:00');

CREATE TABLE reply(
idreply int NOT NULL PRIMARY KEY auto_increment,
idcommentreply int,
iduserreply int,
textreply LONGTEXT NULL, 
datereply DATETIME
);
INSERT INTO `webappjspservlet`.`reply`(`idreply`,`idcommentreply`,`iduserreply`,`textreply`,`datereply`)
VALUES(1,1,4,'Dạ còn tùy vào từng dòng chip cụ thể nữa anh nhé, anh vui lòng cho em thêm thông tin cụ thể về model(tên) sản phẩm anh đang quan tâm để em có thể hỗ trợ tốt hơn ạ Mong phản hồi từ anh.','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`reply`(`idreply`,`idcommentreply`,`iduserreply`,`textreply`,`datereply`)
VALUES(2,1,4,'Dạ còn tùy vào từng dòng chip cụ thể nữa anh nhé, anh vui lòng cho em thêm thông tin cụ thể về model(tên) sản phẩm anh đang quan tâm để em có thể hỗ trợ tốt hơn ạ Mong phản hồi từ anh.','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`reply`(`idreply`,`idcommentreply`,`iduserreply`,`textreply`,`datereply`)
VALUES(3,2,2,'Dạ còn tùy vào từng dòng chip cụ thể nữa anh nhé, anh vui lòng cho em thêm thông tin cụ thể về model(tên) sản phẩm anh đang quan tâm để em có thể hỗ trợ tốt hơn ạ Mong phản hồi từ anh.','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`reply`(`idreply`,`idcommentreply`,`iduserreply`,`textreply`,`datereply`)
VALUES(4,2,3,'Dạ còn tùy vào từng dòng chip cụ thể nữa anh nhé, anh vui lòng cho em thêm thông tin cụ thể về model(tên) sản phẩm anh đang quan tâm để em có thể hỗ trợ tốt hơn ạ Mong phản hồi từ anh.','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`reply`(`idreply`,`idcommentreply`,`iduserreply`,`textreply`,`datereply`)
VALUES(5,1,4,'Dạ còn tùy vào từng dòng chip cụ thể nữa anh nhé, anh vui lòng cho em thêm thông tin cụ thể về model(tên) sản phẩm anh đang quan tâm để em có thể hỗ trợ tốt hơn ạ Mong phản hồi từ anh.','2015-12-25 15:30:00');
INSERT INTO `webappjspservlet`.`reply`(`idreply`,`idcommentreply`,`iduserreply`,`textreply`,`datereply`)
VALUES(6,1,4,'Dạ còn tùy vào từng dòng chip cụ thể nữa anh nhé, anh vui lòng cho em thêm thông tin cụ thể về model(tên) sản phẩm anh đang quan tâm để em có thể hỗ trợ tốt hơn ạ Mong phản hồi từ anh.','2015-12-25 15:30:00');


INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1,'Laptop Lenovo Nitro 1 AN515-43-R84R',12000000,10000000,1,'a.jpg',1,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(2,'Laptop Lenovo Nitro 2 AN515-43-R84R',12000000,10000000,1,'a.jpg',1,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(3,'Laptop Lenovo Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',1,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(4,'Laptop Lenovo Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',1,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(5,'Laptop Lenovo Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',1,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(6,'Laptop Lenovo Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',1,100);

INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(31,'Laptop SamSung Nitro 1 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',2,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(32,'Laptop SamSung Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',2,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(33,'Laptop SamSung Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',2,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(34,'Laptop SamSung Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',2,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(35,'Laptop SamSung Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',2,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(36,'Laptop SamSung Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',2,100);

INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(51,'Laptop DELL Nitro 1 AN515-43-R84R',12000000,10000000,1,'dell-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(52,'Laptop DELL Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(53,'Laptop DELL Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(54,'Laptop DELL Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(55,'Laptop DELL Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(56,'Laptop DELL Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(61,'Laptop DELL Nitro 1 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(62,'Laptop DELL Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(63,'Laptop DELL Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(64,'Laptop DELL Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(65,'Laptop DELL Nitro 5 AN515-43-R84R',12000000,10000000,1,'dell-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(66,'Laptop DELL Nitro 6 AN515-43-R84R',12000000,10000000,1,'dell-2.PNG',3,100);


INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(151,'Laptop DELL Nitro 1 AN515-43-R84R',12000000,10000000,1,'dell-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(152,'Laptop DELL Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(153,'Laptop DELL Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(154,'Laptop DELL Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(155,'Laptop DELL Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(156,'Laptop DELL Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(161,'Laptop DELL Nitro 1 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(162,'Laptop DELL Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(163,'Laptop DELL Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(164,'Laptop DELL Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(165,'Laptop DELL Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(166,'Laptop DELL Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);

INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1151,'Laptop DELL Nitro 1 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1152,'Laptop DELL Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1153,'Laptop DELL Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1154,'Laptop DELL Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1155,'Laptop DELL Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1156,'Laptop DELL Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-4.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1161,'Laptop DELL Nitro 1 AN515-43-R84R',12000000,10000000,1,'samsung-1.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1162,'Laptop DELL Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1163,'Laptop DELL Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-3.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1164,'Laptop DELL Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-1.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1165,'Laptop DELL Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-4.PNG',3,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(1166,'Laptop DELL Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',3,100);


DROP procedure IF EXISTS `PROCEDURE_Pagination`;
DELIMITER $$
USE `webappjspservlet`$$
CREATE PROCEDURE `PROCEDURE_Pagination` (id int)
BEGIN
 select mod(count(*),5) as residual ,FLOOR(count(*)/5) as tatolPageRounding from product  where `producerid` = id;
END$$
DELIMITER ;

call PROCEDURE_Pagination(1);

INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(71,'Laptop Apple Nitro 1 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',4,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(72,'Laptop Apple Nitro 2 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',4,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(73,'Laptop Apple Nitro 3 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',4,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(74,'Laptop Apple Nitro 4 AN515-43-R84R',12000000,10000000,2,'samsung-2.PNG',4,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(75,'Laptop Apple Nitro 5 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',4,100);
INSERT INTO `WebAppJspServlet`.`product`(`idproduct`,`nameproduct`,`price`,`marketprice`,`statusid`,`image`,`producerid`,`total`)
VALUES(76,'Laptop Apple Nitro 6 AN515-43-R84R',12000000,10000000,1,'samsung-2.PNG',4,100);

CREATE TABLE bill (
  idbill int NOT NULL PRIMARY KEY auto_increment,
  iduserbuy int NOT NULL,
  fullnamebuy VARCHAR(150) NOT NULL,
  totalproduct int NOT NULL,
  totalMoney int NOT NULL,
  datebuy DATETIME
);
CREATE TABLE detailbill (
  iddetailbill int NOT NULL PRIMARY KEY auto_increment,
  idbill int NOT NULL,
  idproductbuy int NOT NULL,
  nameproductbuy VARCHAR(255) NULL,
  totalproduct int NOT NULL,
  totalMoneypro int NOT NULL,
  datebuy DATETIME
);


DROP function IF EXISTS `FUNCTION_findNameUser`;
DELIMITER $$
USE `webappjspservlet`$$
CREATE FUNCTION `FUNCTION_findNameUser`(name VARCHAR(150)) RETURNS int
BEGIN
 declare kq int;
 if(select count(iduser)  from user where username = name) >0 then set kq =1;
 else set kq =0;
 end if;
RETURN kq;
END$$
DELIMITER ;

DROP procedure IF EXISTS `PROCEDURE_findUser`;
DELIMITER $$
USE `webappjspservlet`$$
CREATE PROCEDURE `PROCEDURE_findUser` (name VARCHAR(150))
BEGIN
select *  from user where username = name;
END$$
DELIMITER ;
call PROCEDURE_findUser('user');
DROP procedure IF EXISTS `PROCEDURE_InsertUser`;
DELIMITER $$
USE `webappjspservlet`$$
CREATE PROCEDURE `PROCEDURE_InsertUser` (username VARCHAR(150),password VARCHAR(150),fullname VARCHAR(150))
BEGIN
INSERT INTO `webappjspservlet`.`user`(`iduser`,`username`,`password`,`fullname`,`statusid`,`roleid`)
VALUES(null,username,password,fullname,1,'1');
END$$
DELIMITER ;

DROP procedure IF EXISTS `PROCEDURE_UpdateUser`;
DELIMITER $$
USE `webappjspservlet`$$
CREATE PROCEDURE `PROCEDURE_UpdateUser` (id int,username VARCHAR(150),password VARCHAR(150),fullname VARCHAR(150),statusid int)
BEGIN
UPDATE user
SET `username` = username,`password` = password,`fullname` = fullname,`statusid` = statusid WHERE `iduser` = id;
END$$
DELIMITER ;
SELECT idcomment,idproductcomment ,idusercomment ,textcomment , datecomment ,username,fullname from comment,user where comment.idproductcomment =51 and comment.idusercomment = user.iduser and statusid=1 ORDER BY idcomment DESC LIMIT 0, 5;