create table if not exists students (id bigserial primary key, name varchar(255), age int);

insert into students (name, age)
values
    ('Summer', 26),
    ('Hannah', 19),
    ('Sonia', 18),
    ('Sabrina', 19),
    ('Ethan', 24),
    ('Harrison', 28),
    ('Callum', 23),
    ('Lauren', 21),
    ('James', 28),
    ('Emma', 22);