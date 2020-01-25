INSERT INTO CLIENT (id,address,age,first_name,pesel,sex,surname) values (1,'Client address',29,'Client name',9010121234,'Male','Client surname');

INSERT INTO GUN (id,caliber,category,name,number_of_missiles,price,producent,serial_number,weigth)
    values (1,0.44,'Gun category','Gun name',12,450,'Gun producent',45346,2.5);

INSERT INTO SELLER (id,address,age,first_name,surname) values (1,'Seller address',38,'Seller name','Seller surname');

INSERT INTO TRANSACTION (id,time_of_transaction,client_id,gun_id,seller_id) values (1,'2000-10-20',1,1,1);

commit