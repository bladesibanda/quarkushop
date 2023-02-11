INSERT INTO
  categories
VALUES
  (
    1,
    current_timestamp,
    current_timestamp,
    'Phones & Smartphones',
    'Mobile'
  ),
  (
    2,
    current_timestamp,
    current_timestamp,
    'Computers & Laptops',
    'PC'
  );

INSERT INTO
  products
VALUES
  (
    1,
    current_timestamp,
    current_timestamp,
    'The latest powerful iPhone from Apple',
    'iPhone 11 Pro',
    999.00,
    0,
    'AVAILABLE',
    1
  ),
  (
    2,
    current_timestamp,
    current_timestamp,
    'The most powerful iPhone from Apple',
    'iPhone XS',
    759.00,
    0,
    'AVAILABLE',
    1
  ),
  (
    3,
    current_timestamp,
    current_timestamp,
    'The most powerful MacBook from Apple',
    'MacBook Pro 13',
    1999.00,
    0,
    'AVAILABLE',
    2
  ),
  (
    4,
    current_timestamp,
    current_timestamp,
    'The phone that gets it done!',
    'Google Pixel 4',
    450.00,
    0,
    'AVAILABLE',
    1
  );

INSERT INTO
  reviews
VALUES
  (
    1,
    current_timestamp,
    current_timestamp,
    'I like the product but I found that it''s not perfect',
    4,
    'Good but not perfect'
  ),
  (
    2,
    current_timestamp,
    current_timestamp,
    'Wonderful product',
    5,
    'Excellent'
  ),
  (
    3,
    current_timestamp,
    current_timestamp,
    'I like the product but not the price',
    4,
    'Good but very expensive'
  );

INSERT INTO
  products_reviews
VALUES
  (1, 1),
  (1, 2),
  (2, 3);

INSERT INTO
  customers
VALUES
  (
    1,
    current_timestamp,
    current_timestamp,
    'jason.bourne@mail.hello',
    TRUE,
    'Jason',
    'Bourne',
    '010203040506'
  ),
  (
    2,
    current_timestamp,
    current_timestamp,
    'homer.simpson@mail.hello',
    TRUE,
    'Homer',
    'Simpson',
    '060504030201'
  ),
  (
    3,
    current_timestamp,
    current_timestamp,
    'peter.quinn@mail.hello',
    FALSE,
    'Peter',
    'Quinn',
    '070605040302'
  ),
  (
    4,
    current_timestamp,
    current_timestamp,
    'saul.berenson@mail.hello',
    FALSE,
    'Saul',
    'Berenson',
    '070503010204'
  ),
  (
    5,
    current_timestamp,
    current_timestamp,
    'nebrass@quarkushop.store',
    TRUE,
    'Nebrass',
    'Lamouchi',
    '0606060606'
  );

INSERT INTO
  carts
VALUES
  (
    1,
    current_timestamp,
    current_timestamp,
    'NEW',
    1
  ),
  (
    2,
    current_timestamp,
    current_timestamp,
    'NEW',
    2
  ),
  (
    3,
    current_timestamp,
    current_timestamp,
    'NEW',
    3
  ),
  (
    4,
    current_timestamp,
    current_timestamp,
    'NEW',
    4
  ),
  (
    5,
    current_timestamp,
    current_timestamp,
    'NEW',
    5
  );

INSERT INTO
  payments
VALUES
  (
    1,
    current_timestamp,
    current_timestamp,
    999.00,
    'somePaymentId',
    'ACCEPTED'
  ),
  (
    2,
    current_timestamp,
    current_timestamp,
    759.00,
    'paymentId',
    'ACCEPTED'
  ),
  (
    4,
    current_timestamp,
    current_timestamp,
    759.00,
    'paymentId',
    'ACCEPTED'
  );

INSERT INTO
  orders
VALUES
  (
    1,
    current_timestamp,
    current_timestamp,
    999.00,
    '1 Rue Vaugirard',
    NULL,
    'Paris',
    'FR',
    '75015',
    NULL,
    'PAID',
    1,
    2
  ),
  (
    2,
    current_timestamp,
    current_timestamp,
    759.00,
    '2 Rue Maupertuis',
    NULL,
    'Le Mans',
    'FR',
    '72100',
    NULL,
    'PAID',
    2,
    1
  ),
  (
    3,
    current_timestamp,
    current_timestamp,
    0,
    '39 Quai du Président Roosevelt',
    NULL,
    'Issy-les-Moulineaux',
    'FR',
    92130,
    NULL,
    'CREATION',
    3,
    NULL
  ),
  (
    4,
    current_timestamp,
    current_timestamp,
    0,
    'Cité Safia 2',
    NULL,
    'Ksour',
    'TN',
    7160,
    NULL,
    'CREATION',
    4,
    NULL
  ),
  (
    5,
    current_timestamp,
    current_timestamp,
    0,
    'Cité Safia 2',
    NULL,
    'Ksour',
    'TN',
    7160,
    NULL,
    'CREATION',
    5,
    4
  );

INSERT INTO
  order_items
VALUES
  (1, current_timestamp, current_timestamp, 1, 1, 1),
  (2, current_timestamp, current_timestamp, 1, 2, 2);