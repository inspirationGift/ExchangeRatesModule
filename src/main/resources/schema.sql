drop schema if exists schema_test CASCADE;
create schema if not exists schema_test;

-- set search_path TO schema_test;
--
--
create table if not exists schema_test.currencies_rate
(
    id           serial,
    reportDate   date,
    baseCurrency varchar(3),
    currency     varchar(3),
    sale         double precision,
    purchase     double precision,
    reportSource int
--     unique (baseCurrency, currency, reportDate, reportSource)
);

create table if not exists schema_test.codes
(
    id   serial primary key,
    code varchar(3),
    name varchar(3),
    unique (code, name)
);

create table if not exists schema_test.resourceCode
(
    id   int,
    name varchar(10),
    unique (name)
);
