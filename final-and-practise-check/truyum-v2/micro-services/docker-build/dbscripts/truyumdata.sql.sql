-- Include table data insertion, updation, deletion and select scripts
use truyum;
insert into menu_item(me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery, me_image)
values('Sandwich',99.00,'Yes','2017/03/15','Main Course','Yes','https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1353&amp;q=80'),
('Burger',129.00,'Yes','2017/12/23','Main Course','No','https://images.unsplash.com/photo-1457460866886-40ef8d4b42a0?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1350&amp;q=80'),
('Pizza',149.00,'Yes','2017/08/21','Main Course','No','https://images.unsplash.com/photo-1542282811-943ef1a977c3?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1352&amp;q=80'),
('French Fries',56.00,'No','2017/07/02','Starters','Yes','https://images.unsplash.com/photo-1518013431117-eb1465fa5752?ixlib=rb-1.2.1&amp;auto=format&amp;fit=crop&amp;w=500&amp;q=60'),
('Chocolate Brownie',32.00,'Yes','2022/11/02','Dessert','Yes','https://images.unsplash.com/photo-1498602679121-1adc04bd257f?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=1375&amp;q=80');

insert into user(us_name,us_password,us_first_name,us_last_name)
values('admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','admin','admin'),('user','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','user','user');

insert into cart(ct_us_id,ct_pr_id)
values(1,1), (1,2), (1,3);
select *from cart;

insert into role(ro_name)
values('admin'),('user');

insert into user_role(ur_us_id,ur_ro_id)
values(1,1),(2,2);

