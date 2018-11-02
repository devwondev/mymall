-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 mall의 구조를 덤프합니다. item
CREATE TABLE IF NOT EXISTS `item` (
  `no` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mall의 구조를 덤프합니다. member
CREATE TABLE IF NOT EXISTS `member` (
  `no` int(10) NOT NULL AUTO_INCREMENT,
  `id` varchar(50) COLLATE utf8_bin NOT NULL,
  `pw` varchar(50) COLLATE utf8_bin NOT NULL,
  `level` int(11) DEFAULT '0',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='level 1';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mall의 구조를 덤프합니다. member_item
CREATE TABLE IF NOT EXISTS `member_item` (
  `no` int(10) NOT NULL AUTO_INCREMENT,
  `member_no` int(10) NOT NULL,
  `item_no` int(10) NOT NULL,
  `order_date` datetime NOT NULL,
  PRIMARY KEY (`no`),
  KEY `FK_member` (`member_no`),
  KEY `FK_item` (`item_no`),
  CONSTRAINT `FK_item` FOREIGN KEY (`item_no`) REFERENCES `item` (`no`),
  CONSTRAINT `FK_member` FOREIGN KEY (`member_no`) REFERENCES `member` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='주문';

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

insert into item (name, price) values ('Bryonia Alba', 3851);
insert into item (name, price) values ('HGH Plus', 1293);
insert into item (name, price) values ('Famotidine', 3983);
insert into item (name, price) values ('Metamucil', 2147);
insert into item (name, price) values ('Doxycycline Hyclate', 4825);
insert into item (name, price) values ('Diphenoxylate Hydrochloride and Atropine Sulfate', 1215);
insert into item (name, price) values ('Radiogardase', 4800);
insert into item (name, price) values ('Paroxetine', 1709);
insert into item (name, price) values ('DG Health Ibuprofen', 2461);
insert into item (name, price) values ('miconazole 1', 1894);
insert into item (name, price) values ('Dove', 4946);
insert into item (name, price) values ('CLE DE PEAU BEAUTE CR COMPACT FOUNDATION', 4855);
insert into item (name, price) values ('Isomers Clear Skin Acne Treatment Gel', 3102);
insert into item (name, price) values ('Allergy Desensitization', 4709);
insert into item (name, price) values ('Pleo Nig Ex', 1738);
insert into item (name, price) values ('Pigweed Mixture', 4745);
insert into item (name, price) values ('Lady Speed Stick', 3974);
insert into item (name, price) values ('Crest', 3446);
insert into item (name, price) values ('KOMBIGLYZE', 4797);
insert into item (name, price) values ('Zenzedi', 2822);

