INSERT INTO tbl_invoice_items (product_id, quantity, price ) VALUES( 1 , 1, 178.8);
INSERT INTO tbl_invoice_items (product_id, quantity, price)  VALUES( 2 , 2, 12.5);
INSERT INTO tbl_invoice_items (product_id, quantity, price)  VALUES( 3 , 1, 40.0);
INSERT INTO tbl_invoices (number_invoice, description, customer_id, create_at, state) VALUES('0001', 'invoice office items', 1, NOW(),'CREATED');