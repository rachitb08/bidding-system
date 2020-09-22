INSERT INTO bidder(name,email,phone_number) VALUES
('Rachit','rachitb008@gmail.com','9999999999'),
('XYZ','xyz@gmail.com','8888888888');

INSERT INTO seller(name,email,phone_number) VALUES
('ABC','abc@gmail.com','7777777777'),
('DEF','def@gmail.com','6666666666');

INSERT INTO item(name,step_rate,minimum_base_price,seller_id,auction_status_id,max_bid_id,start_date,end_date) VALUES
('Abstract Painting 1',250.0,2000.0,1,1,null,CURRENT_DATE,CURRENT_DATE + 7),
('Abstract Painting 2',300.0,2000.0,2,1,null,CURRENT_DATE,CURRENT_DATE + 7),
('Abstract Painting 3',350.0,3000.0,1,1,null,CURRENT_DATE,CURRENT_DATE + 7),
('Abstract Painting 4',400.0,2500.0,2,2,null,CURRENT_DATE,CURRENT_DATE),
('Abstract Painting 5',100.0,1000.0,1,2,null,CURRENT_DATE,CURRENT_DATE),
('Abstract Painting 6',150.0,1500.0,2,1,null,CURRENT_DATE,CURRENT_DATE + 7);