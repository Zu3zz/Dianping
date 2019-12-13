CREATE TABLE `dianping`.`user` (
   `id` int NOT NULL AUTO_INCREMENT,
   `created_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
   `updated_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
   `telphone` varchar(40) NOT NULL DEFAULT '',
   `password` varchar(200) NOT NULL DEFAULT '',
   `nick_name` varchar(40) NOT NULL DEFAULT '',
   `gender` int NOT NULL DEFAULT 0,
   PRIMARY KEY (`id`),
   UNIQUE `telphone_unique_index` USING BTREE (`telphone`) comment ''
) COMMENT='';