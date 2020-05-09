use fincity;

create table if not exists car (
  id bigint not null auto_increment,
  car_name varchar(200) not null,
  manufacture_name varchar(200) not null,
  model varchar(200) null,
  manufacturing_year bigint null,
  color varchar(50),
  primary key (id)
);


