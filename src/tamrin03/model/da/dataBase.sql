create table PRODUCT1
(
    ID      NUMBER primary key,
    PRODUCT NVARCHAR2(20) unique,
    BRAND   NVARCHAR2(20),
    PRICE   NUMBER,
    COUNT   NUMBER
);

CREATE SEQUENCE PRODUCT_SEQ START WITH 1 INCREMENT BY 1;