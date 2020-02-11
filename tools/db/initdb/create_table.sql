create table tasks (
  id serial,
  content VARCHAR(100) not null,
  done Boolean not null default false,
  primary key(id)
);

