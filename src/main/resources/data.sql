DELETE FROM customers;
INSERT INTO customers (id, first_name, last_name, email) VALUES (100, 'John', 'Wick', 'johny@email.com');
INSERT INTO customers (id, first_name, last_name, email) VALUES (101, 'John', 'Snow', 'winter@email.com');

DELETE FROM accounts;
INSERT INTO accounts (id, fk_customer, amount, created) VALUES (1000, 100, 1000.0, '27-03-2023');
INSERT INTO accounts (id, fk_customer, amount, created) VALUES (1001, 100, 0.0, '01-01-2023');
INSERT INTO accounts (id, fk_customer, amount, created) VALUES (1002, 100, 0.0, '15-06-2022');
INSERT INTO accounts (id, fk_customer, amount, created) VALUES (1003, 100, 1.0, '20-05-2021');
INSERT INTO accounts (id, fk_customer, amount, created) VALUES (1004, 101, 10.0, '01-01-2023');
INSERT INTO accounts (id, fk_customer, amount, created) VALUES (1005, 101, 10000.0, '01-02-2023');

DELETE FROM cashback_rates;
INSERT INTO cashback_rates (id, cashback_category, amount) VALUES (10000, 1, 0.1);
INSERT INTO cashback_rates (id, cashback_category, amount) VALUES (10001, 2, 0.15);

DELETE FROM cashback;
INSERT INTO cashback (id, category, fk_cashback_rate) VALUES (1000, 1, 10000);
INSERT INTO cashback (id, category, fk_cashback_rate) VALUES (1001, 2, 10001);

DELETE FROM account_cashback;
INSERT INTO account_cashback (fk_account, fk_cashback) VALUES (1000, 1000);
INSERT INTO account_cashback (fk_account, fk_cashback) VALUES (1000, 1001);
INSERT INTO account_cashback (fk_account, fk_cashback) VALUES (1005, 1000);


