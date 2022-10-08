
create database dbbank

create table statusclient(
id_statusclient int not null primary key auto_increment,
  status_client varchar(15) not null
)

create table clients (
id_client int not null primary key auto_increment,
  name_client varchar(26) not null,
  surname_client varchar(26) not null,
  phone_client varchar(9) not null,
  email_client varchar(65) not null,
  dni_client varchar(10) not null unique,
  user_client varchar(25) not null unique,
  password_client varchar(25) not null,
  id_statusclient int not null
) 

alter table clients add constraint foreign key (id_statusclient) references statusclient(id_statusclient)

create table typeaccount(
id_typeaccount int primary key not null auto_increment,
  type_account varchar(15) not null
)

create table statusaccount(
id_statusaccount int primary key not null auto_increment,
  status_account varchar(15) not null
)

create table account(
id_account int not null primary key auto_increment,
  number_account varchar(25) not null unique,
  balance_account numeric(7,2) not null,
  id_typeaccount int not null,
  id_statusaccount int not null
)

alter table account add constraint foreign key (id_statusaccount) references statusaccount(id_statusaccount)
alter table account add constraint foreign key (id_typeaccount) references typeaccount(id_typeaccount)

create table clientaccount(
id_client int not null,
id_account int not null,
constraint id_client_account primary key (id_client,id_account)
)

alter table clientaccount add constraint foreign key (id_client) references clients(id_client)
alter table clientaccount add constraint foreign key (id_account) references account(id_account)


create table statustransaction(
id_statustransaction int primary key not null auto_increment,
  status_transaction varchar(15) not null
)

create table typetransaction(
id_typetransaction int  primary key not null auto_increment,
  type_transaction varchar(15) not null
)

create table transactions(
id_transaction int primary key not null auto_increment,
  name_transaction varchar(15) not null,	
  date_transaction datetime default current_timestamp(),
  balance_transaction numeric(7,2) not null,
  total_transaction numeric(7,2) not null,
  id_typetransaction int not null,
  id_statustransaction int not null
) 

alter table transactions add constraint foreign key (id_typetransaction) references typetransaction(id_typetransaction)
alter table transactions add constraint foreign key (id_statustransaction) references statustransaction(id_statustransaction)

create table banks(
id_bank int primary key not null auto_increment,
   name_bank varchar(56) not null,
   direction_bank varchar(189) not null,
   phone_bank varchar(9) not null,
   president_bank varchar(55) not null,
   id_account int not null
)

alter table banks add constraint foreign key (id_account) references account(id_account)

create table accounttransaction(
id_account int not null,
id_transaction int not null,
constraint id_accounttransaction primary key (id_account,id_transaction)
)

alter table accounttransaction add constraint foreign key (id_account) references account(id_account)
alter table accounttransaction add constraint foreign key (id_transaction) references transactions(id_transaction)

create table historytransaction(
id_transaction_history int primary key not null auto_increment,
  name_transaction_history varchar(15) not null,	
  date_transaction_history datetime default current_timestamp(),
  balance_transaction_history numeric(7,2) not null,
  total_transaction_history numeric(7,2) not null,
  id_typetransaction_history int not null,
  id_statustransaction_history int not null,
  id_original_transaction int not null
)

alter table historytransaction add constraint foreign key(id_original_transaction) references transactions(id_transaction)

------------------------------------------------------------------------------------

select * from typeaccount t 

insert into typeaccount values (1,"Savings")
insert into typeaccount (type_account) values ("Ordinary")

select * from statusaccount s 

insert into statusaccount (status_account) values ("Active")
insert into statusaccount (status_account) values ("Unactive")

select * from typetransaction t 

insert into typetransaction (type_transaction) values ("Deposit")
insert into typetransaction (type_transaction) values ("Retirement")


select * from statustransaction s  

insert into statustransaction (status_transaction) values ("In Process")
insert into statustransaction (status_transaction) values ("Cancelled")


select * from account a 

alter table account Modify number_account varchar(36)

insert into account (number_account, balance_account, id_typeaccount, id_statusaccount) 
values ("SV52BPRA34322344333434434343", 2344.56, 1,1)

select * from banks b 

insert into banks (name_bank, direction_bank, phone_bank, president_bank,id_account)
values ("Banco Agrícola, S.A.", "Blvd. Constitución No.:100, San Salvador, El Salvador, C.A.", "2267-5000", "Ricardo Mauricio Rosillo Rojas", 1)

insert into banks (name_bank, direction_bank, phone_bank, president_bank,id_account)
values 
("Banco Cuscatlán de El Salvador, S.A", "Edificio Pirámide Km. 10 carretera a Santa Tecla. Depto. La Libertad", "2228-7777", "	Lic. José Eduardo Montenegro Palomo", 1),
("Banco Davivienda Salvadoreño, S.A", "Avenida Olímpica No.3550. San Salvador, El Salvador, C.A. Apdo. Postal No.: (0673)", "2556-2000","Ing. Pedro Alejandro Uribe Torres",1)



