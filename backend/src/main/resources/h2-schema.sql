create sequence if not exists hibernate_sequence start with 1000;

create table USER
(
    ID IDENTITY NOT NULL CONSTRAINT USER_PK PRIMARY KEY,
    USERNAME varchar (24) NOT NULL UNIQUE,
    EMAIL varchar (50) NOT NULL UNIQUE,
    PASSWORD varchar (200) NOT NULL,
    LAST_PASSWORD_RESET date,
    version integer not null default 0
);

create table USER_AUTHORITY
(
    ID IDENTITY NOT NULL CONSTRAINT USERAUTHORITY_PK PRIMARY KEY,
    USER_ID integer NOT NULL,
    AUTHORITY_ID integer NOT NULL,
    -- user
    -- authority
)

create table RECIPE
(
    ID IDENTITY NOT NULL CONSTRAINT RECIPE_PK PRIMARY KEY,
    RECIPE_NAME varchar(50) not null,
    DESCRIPTION varchar (200) not null,
    IMAGEPATH varchar(200) not null,
    INGREDIENT_ID integer
);

create table SHOPPINGLIST
(
    ID IDENTITY NOT NULL CONSTRAINT SHOPPINGLIST_PK PRIMARY KEY,
    SHOPPINGLIST_NAME varchar(50) not null,
    AMOUNT integer not null,
    RECIPE_ID integer
);

create table INGREDIENT
(
    ID IDENTITY NOT NULL CONSTRAINT INGREDIENT_PK PRIMARY KEY,
    INGREDIENT_NAME varchar(50) not null,
    AMOUNT integer not null,
    RECIPE_ID integer
);

alter table RECIPE
    add constraint RECIPE_INGREDIENT_ID foreign key (INGREDIENT_ID) references ingredient(ID);
