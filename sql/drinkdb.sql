CREATE DATABASE drinkdb;

GRANT ALL PRIVILEGES ON drinkdb.* TO 'ohgiraffers%';

USE drinkdb;

CREATE TABLE `COMPANY`
(
    `COM_CODE` CHAR(5) NOT NULL COMMENT '제조사코드',
    `COM_NAME` VARCHAR(35) NOT NULL COMMENT '제조사이름',
    PRIMARY KEY (`COM_CODE`)
)
    COMMENT = '제조사';

INSERT INTO COMPANY (COM_CODE, COM_NAME) VALUES
                                             ('C1', '코카콜라'),
                                             ('C2', '칠성'),
                                             ('C3', '동아오츠카'),
                                             ('C4', '해태음료'),
                                             ('C5', 'etc');

CREATE TABLE `TYPE`
(
    `TYPE_CODE` CHAR(5) NOT NULL COMMENT '분류코드',
    `TYPE_NAME` VARCHAR(35) NOT NULL COMMENT '종류',
    PRIMARY KEY (`TYPE_CODE`)
)
    COMMENT = '종류';

INSERT INTO TYPE (TYPE_CODE, TYPE_NAME) VALUES
                                            ('T1', '탄산'),
                                            ('T2', '에너지드링크'),
                                            ('T3', '쥬스'),
                                            ('T4', '이온'),
                                            ('T5', '그 외');

CREATE TABLE `DRINK`
(
    `DRK_CODE` CHAR(5) NOT NULL COMMENT '음료코드',
    `DRK_NAME` VARCHAR(35) NOT NULL COMMENT '음료이름',
    `PRICE` INTEGER NOT NULL COMMENT '가격',
    `IS_ZERO` BOOLEAN NOT NULL COMMENT '제로여부',
    `COM_CODE` CHAR(5) NOT NULL COMMENT '제조사코드',
    `TYPE_CODE` CHAR(5) NOT NULL COMMENT '분류코드',
    `EXP_DATE` DATE NOT NULL COMMENT '유통기한',
    `DRK_SIZE` VARCHAR(10) NOT NULL COMMENT '용량',
    PRIMARY KEY (`DRK_CODE`)
)
    COMMENT = '음료수';

INSERT INTO DRINK (DRK_CODE, DRK_NAME, PRICE, IS_ZERO, COM_CODE, TYPE_CODE, EXP_DATE, DRK_SIZE) VALUES
                                                                                                    ('D1', '코카콜라', 2000, 0, 'C1', 'T1', '2025-01-20', '355ml'),
                                                                                                    ('D2', '코카콜라 제로', 2000, 1, 'C1', 'T1', '2025-01-20', '355ml'),
                                                                                                    ('D3', '칠성사이다', 1800, 0, 'C2', 'T1', '2025-05-15', '355ml'),
                                                                                                    ('D4', '펩시콜라', 1900, 0, 'C2', 'T1', '2025-03-10', '355ml'),
                                                                                                    ('D5', '펩시 제로', 1900, 1, 'C2', 'T1', '2025-03-10', '355ml'),
                                                                                                    ('D6', '몬스터 에너지', 2400, 0, 'C1', 'T2', '2025-06-20', '500ml'),
                                                                                                    ('D7', '포카리스웨트', 2500, 0, 'C3', 'T4', '2025-04-12', '500ml'),
                                                                                                    ('D8', '게토레이', 1800, 0, 'C5', 'T4', '2025-02-25', '500ml'),
                                                                                                    ('D9', '환타', 1500, 0, 'C1', 'T1', '2025-07-07', '355ml'),
                                                                                                    ('D10', '썬키스트 오렌지', 2000, 0, 'C5', 'T3', '2025-03-30', '250ml');

CREATE TABLE `SELL`
(
    `SELL_CODE` INT AUTO_INCREMENT NOT NULL COMMENT '판매코드',
    `IS_AVA` BOOLEAN NOT NULL COMMENT '재고여부',
    `DRK_CODE` CHAR(5) NOT NULL COMMENT '음료코드',
    PRIMARY KEY (`SELL_CODE`),
    FOREIGN KEY (`DRK_CODE`) REFERENCES `DRINK`(`DRK_CODE`)
)
    COMMENT = '판매';

COMMIT;