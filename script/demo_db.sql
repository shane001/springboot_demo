CREATE DATABASE `demo_db`;

DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) NOT NULL COMMENT 'name',
  `value` varchar(32) NOT NULL COMMENT 'value',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `demo` VALUES (1,'test_name','test_value');
