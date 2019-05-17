CREATE TABLE orders (
  id          varchar(50)    NOT NULL,
  product_id   bigint         NOT NULL,
  total_price decimal(10, 2) NOT NULL,
  PRIMARY KEY (id)
);