-- Include table data insertion, updation, deletion and select scripts
insert into menu_item(me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery, me_image)
values('Sandwich',99.00,'Yes','2017/03/15','Main Course','Yes','https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1353&amp;q=80'),
('Burger',129.00,'Yes','2017/12/23','Main Course','No','https://images.unsplash.com/photo-1457460866886-40ef8d4b42a0?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1350&amp;q=80'),
('Pizza',149.00,'Yes','2017/08/21','Main Course','No','https://images.unsplash.com/photo-1542282811-943ef1a977c3?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1352&amp;q=80'),
('French Fries',56.00,'No','2017/07/02','Starters','Yes','https://images.unsplash.com/photo-1518013431117-eb1465fa5752?ixlib=rb-1.2.1&amp;auto=format&amp;fit=crop&amp;w=500&amp;q=60'),
('Chocolate Brownie',32.00,'Yes','2022/11/02','Dessert','Yes','https://images.unsplash.com/photo-1498602679121-1adc04bd257f?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1375&amp;q=80');



select me_id,me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery ,me_image
from menu_item;

select me_name, me_free_delivery, me_price, me_category 
from menu_item 
where me_date_of_launch  <= (select curdate()) and me_active = 'yes';

select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery  
from menu_item 
where me_id = 1;

update menu_item 
set me_name = 'Maggi', 
me_price = 55.00,
me_active = 'yes',
me_date_of_launch = '2017/09/13',
me_category = 'Main Course',
me_free_delivery = 'Yes' 
where me_id = 2;

insert into user(us_name,us_password,us_first_name,us_last_name)
values('admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','admin','admin'),('user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','user','user');

insert into cart(ct_us_id,ct_pr_id)
values(1,1), (1,2), (1,3);
select *from cart;

insert into role(ro_name)
values('admin'),('user');

insert into user_role(ur_us_id,ur_ro_id)
values(1,1),(2,2);

Select menu_item.me_id, menu_item.me_name, menu_item.me_free_delivery, menu_item.me_price
from menu_item  
left join cart 
On menu_item.me_id=cart.ct_pr_id 
where cart.ct_us_id = 1;

select sum(menu_item.me_price) as total_price 
from menu_item 
inner join cart 
On menu_item.me_id = cart.ct_pr_id 
group by cart.ct_us_id;

delete from cart 
where ct_us_id = 1 and ct_pr_id = 3;

use truyum;
select * from menu_item;
select * from cart;
select * from user;
select * from role;
select * from user_role;
drop table menu_item;
drop table cart;
drop table user;
drop table user_role;
drop table role;

insert into user(us_name,us_password,us_first_name,us_last_name)
values('abi','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','admin','admin');

insert into user_role(ur_us_id,ur_ro_id)
values(4,1);

insert into role(ro_name)
values('admin'),('user'),('vendor');

insert into user_role(ur_au_id,ur_ro_id)
values(1,1);

drop table bill_details_electricity;
drop table user;
drop table vendor;
drop table all_users;

select * from user;
select * from vendor;
select *from all_users;
select * from user_role;
insert into all_users(au_name,au_password)
values("admin",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
desc vendor;
insert into vendor(ve_name,ve_company_register_number,ve_type,ve_address,ve_country,ve_state,ve_email,ve_contact_number,ve_website,ve_certificate_issued_date,ve_certificate_validity_date,ve_year_of_establish,ve_payment_gateway,ve_password,ve_image,ve_status,ve_remark)
values('TNEB','ELEC456','Electricity','No:800,Mount Road,Anna Salai,Chennai-02','India','TamilNadu','cemines@tnebnet.org',9445442300,'www.tneb.in','1950/06/17',
'2100/12/31',1950,'GPay','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','https://upload.wikimedia.org/wikipedia/en/e/e9/Tamil_Nadu_Electricity_Board_%28emblem%29.jpg',0,'to be done'),
('LIC','LIC396','Insurance','No:70,Guindy,Chennai-03','India','TamilNadu','user@licnet.org',02268276827,'www.licindia.in','1987/05/07',
'2050/12/01',1987,'E-Wallet','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQO62XuJCP8NRoRpVGvYonfLjyBej8qo2Ae88JgfLFZM0WxucV7&s',0,'to be done'),
('Airtel','AIRTEL001','DTH','No:42,Santhome Road,Mylapore,Chennai-02','India','TamilNadu','myairtel@airnet.org',42027733,'www.myairtel.in','2000/06/17',
'2100/12/01',2008,'GPay','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/Bharti_Airtel_Limited_logo.svg/361px-Bharti_Airtel_Limited_logo.svg.png',0,'to be done'),
('HDFC','HDFC0A1','Loan Account','No:759,ITC Centre,Anna Salai,Chennai-02','India','TamilNadu','customer@hdfcnet.org',07573919585,'www.tneb.in','1994/06/17',
'2070/12/31',1994,'E-Wallet','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdIDk2rL0sq7cV73pxn6KkxEJYdGE878bXai1PjTpH9YqPCdFt&s',0,'to be done'),
('BSNL','BSNL006','Telephone','No:16,Greams Road,Chennai-006','India','TamilNadu','bsnl@bsnlnet.org',18003451504,'www.bsnl.co.in','2000/10/01',
'2100/12/31',2000,'GPay','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','https://www.gizmotimes.com/wp-content/uploads/2016/04/BSNL-4G-serive-with-100Mbps-speed.jpg',0,'to be done'),
('MasterCard','CCREG002','Cerdit Card','No:805,Mount Road,Anna Salai,Chennai-02','India','TamilNadu','user@mastercard.org',8006227747,'www.mcard.com','1966/01/01',
'2100/12/01',1966,'E-Wallet','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5jP7j7g8uIiHPQEQX4hbxHDO0QxidYDtNRSDg0uj4E1V0CrHa&s',0,'to be done'),
('TNIT','TNTAX001','Tax','No:121,M.G Road,Nungambakkam,Chennai-34','India','TamilNadu','tntax@ittaxnet.org',9445467553,'www.it.gov.in','1980/06/17',
'2100/01/01',1980,'E-Wallet','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ96qhl9rpKe6rdJTUcdAB5PrpFxOmBL4ICh-vIo-hR_EVGrfpj&s',0,'to be done');
insert into all_users(au_name,au_password)
values("TNEB",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),
("LIC",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),
("HDFC",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),
("Airtel",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),
("BSNL",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),
("MasterCard",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK'),
("TNIT",'$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');








 