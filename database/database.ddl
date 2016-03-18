DROP TABLE IF EXISTS `tejajava`.`customer`;
CREATE TABLE  `tejajava`.`customer` (
  `CUST_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `AGE` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`CUST_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `customer` (`CUST_ID`,`NAME`,`AGE`) VALUES
  (1,'teja1',28),
  (2,'teja2',28),
  (3,'teja3',28);