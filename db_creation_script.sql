
use climatedatabase;
drop table climate_data;
drop table target_climate;
drop table climate_profile_records;
drop table climate_profiles;

/*
use climatedatabase;
drop table target_climate_seq;
drop table climate_profile_records_seq;
drop table climate_profiles_seq;
drop table climate_data_seq;
create tables
*/
use climatedatabase;
create table climate_data(
climate_data_id int auto_increment primary key,
temperature float,
humidity float,
pressure float,
data_date date,
data_time time
);
create table target_climate(
target_climate_id int auto_increment primary key,
target_temperature float,
target_humidity float,
data_date date,
data_time time
);
create table climate_profiles(
climate_profile_id int auto_increment primary key,
climate_profile_name varchar(50),
climate_profile_selected bool
);
create table climate_profile_records(
climate_profile_record_id int auto_increment primary key,
temperature float,
humidity float,
begin_time time,
end_time time,
climate_profile_id int null,
foreign key (climate_profile_id) 
references climate_profiles(climate_profile_id)
on delete cascade
);
/*
inset some data
*/
use climatedatabase;
insert into climate_data(temperature,humidity,pressure,data_date,data_time)
values(50.0,30.0,760.0,'2023-06-01','13:56'),
(40.0,32.0,770.0,'2023-06-01','13:57'),
(30.0,35.0,765.0,'2023-06-01','13:58'),
(28.0,38.0,763.0,'2023-06-01','13:59');
use climatedatabase;
select * from climate_profile_records;

use climatedatabase;
insert into climate_profile_records(temperature,humidity,
begin_time,
end_time,
climate_profile_id) 
values (25.5, 60.0, '00:00:00', '9:00:00', 1),
(20.5, 80.0, '18:00:00', '23:59:00', 1),
(50.5, 10.0, '09:00:00', '18:00:00', 1);

use climatedatabase;
DELETE FROM climate_data;

use climatedatabase;
select * FROM climate_data;

use climatedatabase;
select * from climate_profiles;
use climatedatabase;
update climate_profiles set selected=true where climate_profile_id=1;

use climatedatabase;
insert into climate_profiles(climate_profile_name) 
values ('climate pofile 1'),('climate pofile 2'),('climate pofile 3');
select * from climate_profiles;
