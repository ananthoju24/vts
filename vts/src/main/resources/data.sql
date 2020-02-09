insert into T_USER_DETAILS(F_ID,F_USER_ID,F_PASSWORD, F_CREATE_DATE,F_UPDATE_DATE) values(1,'admin','1234',sysdate,sysdate);
insert into T_USER_DETAILS(F_ID,F_USER_ID,F_PASSWORD, F_CREATE_DATE,F_UPDATE_DATE) values(2,'arun','1234',sysdate,sysdate);
 
insert into t_owner_details (f_create_date, f_update_date, f_father_or_husband_name, f_mobile_number, f_owner_name, f_owner_id) values (now(), now(), 'father', '8098098090', 'Arun', 11644);

insert into t_house_details (f_create_date, f_update_date, f_owner_id, f_house_no) values (now(), now(),11644, '1-23');

insert into t_tax_details (f_create_date, f_update_date, f_cleaning_tax, f_house_id, f_house_tax, f_lighthing_tax, f_tax_status, f_tax_year, f_total_tax, f_village_tax, f_water_tax, f_tax_id) values (now(), now(), 10, '1-23',100 , 20, 'PENDING', '2018', 220, 40, 50, 10008669);

insert into t_tax_details (f_create_date, f_update_date, f_cleaning_tax, f_house_id, f_house_tax, f_lighthing_tax, f_tax_status, f_tax_year, f_total_tax, f_village_tax, f_water_tax, f_tax_id) values (now(), now(), 10, '1-23',100 , 20, 'PENDING', '2019', 220, 40, 50, 10008667);

insert into t_tax_details (f_create_date, f_update_date, f_cleaning_tax, f_house_id, f_house_tax, f_lighthing_tax, f_tax_status, f_tax_year, f_total_tax, f_village_tax, f_water_tax, f_tax_id) values (now(), now(), 10, '1-23',100 , 20, 'PENDING', '2020', 220, 40, 50, 10008668);




 