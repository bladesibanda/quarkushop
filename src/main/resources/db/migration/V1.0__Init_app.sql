CREATE SEQUENCE hibernate_sequence
START WITH
  100 INCREMENT BY 1;

CREATE TABLE carts (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  status CHARACTER VARYING(255) NOT NULL,
  customer_id bigint
);

ALTER TABLE
  carts
ADD
  CONSTRAINT carts_pkey PRIMARY KEY (id);

CREATE TABLE categories (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  description CHARACTER VARYING(255) NOT NULL,
  name CHARACTER VARYING(255) NOT NULL
);

ALTER TABLE
  categories
ADD
  CONSTRAINT categories_pkey PRIMARY KEY (id);

CREATE TABLE customers (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  email CHARACTER VARYING(255),
  enabled BOOLEAN NOT NULL,
  first_name CHARACTER VARYING(255),
  last_name CHARACTER VARYING(255),
  telephone CHARACTER VARYING(255)
);

ALTER TABLE
  customers
ADD
  CONSTRAINT customers_pkey PRIMARY KEY (id);

CREATE TABLE order_items (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  quantity bigint NOT NULL,
  order_id bigint,
  product_id bigint
);

ALTER TABLE
  order_items
ADD
  CONSTRAINT order_items_pkey PRIMARY KEY (id);

CREATE TABLE orders (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  total_price numeric(10, 2) NOT NULL,
  address_1 CHARACTER VARYING(255),
  address_2 CHARACTER VARYING(255),
  city CHARACTER VARYING(255),
  country CHARACTER VARYING(2) NOT NULL,
  postcode CHARACTER VARYING(10) NOT NULL,
  shipped TIMESTAMP,
  status CHARACTER VARYING(255) NOT NULL,
  cart_id bigint,
  payment_id bigint
);

ALTER TABLE
  orders
ADD
  CONSTRAINT orders_pkey PRIMARY KEY (id);

CREATE TABLE payments (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  amount numeric(10, 2) NOT NULL,
  paypal_payment_id CHARACTER VARYING(255),
  status CHARACTER VARYING(255) NOT NULL
);

ALTER TABLE
  payments
ADD
  CONSTRAINT payments_pkey PRIMARY KEY (id);

CREATE TABLE products (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  description CHARACTER VARYING(255) NOT NULL,
  name CHARACTER VARYING(255) NOT NULL,
  price numeric(10, 2) NOT NULL,
  sales_counter INTEGER,
  status CHARACTER VARYING(255) NOT NULL,
  category_id bigint
);

ALTER TABLE
  products
ADD
  CONSTRAINT products_pkey PRIMARY KEY (id);

CREATE TABLE products_reviews (
  product_id bigint NOT NULL,
  reviews_id bigint NOT NULL
);

ALTER TABLE
  products_reviews
ADD
  CONSTRAINT products_reviews_pkey PRIMARY KEY (product_id, reviews_id);

CREATE TABLE reviews (
  id bigint NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP,
  description CHARACTER VARYING(255) NOT NULL,
  rating bigint NOT NULL,
  title CHARACTER VARYING(255) NOT NULL
);

ALTER TABLE
  reviews
ADD
  CONSTRAINT reviews_pkey PRIMARY KEY (id);

ALTER TABLE
  products_reviews
ADD
  CONSTRAINT products_reviews_uk UNIQUE (reviews_id);

ALTER TABLE
  orders
ADD
  CONSTRAINT orders_uk UNIQUE (payment_id);

ALTER TABLE
  products_reviews
ADD
  CONSTRAINT products_reviews_fk1 FOREIGN KEY (reviews_id) REFERENCES reviews(id);

ALTER TABLE
  carts
ADD
  CONSTRAINT carts_fk FOREIGN KEY (customer_id) REFERENCES customers(id);

ALTER TABLE
  order_items
ADD
  CONSTRAINT order_item_fk1 FOREIGN KEY (product_id) REFERENCES products(id);

ALTER TABLE
  orders
ADD
  CONSTRAINT orders_fk1 FOREIGN KEY (payment_id) REFERENCES payments(id);

ALTER TABLE
  order_items
ADD
  CONSTRAINT order_item_fk2 FOREIGN KEY (order_id) REFERENCES orders(id);

ALTER TABLE
  products
ADD
  CONSTRAINT product_fk FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE
  orders
ADD
  CONSTRAINT orders_fk2 FOREIGN KEY (cart_id) REFERENCES carts(id);

ALTER TABLE
  products_reviews
ADD
  CONSTRAINT products_reviews_fk2 FOREIGN KEY (product_id) REFERENCES products(id);