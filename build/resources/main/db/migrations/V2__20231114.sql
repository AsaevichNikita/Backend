INSERT INTO user (full_name, birthday, email, password, role)
VALUES ('Романовский Иван Михайлович', '2003-02-23', 'qwert@gmail.com', '12345', 'USER'),
       ('Асаевич Никита Сергеевич', '2003-02-23', '1234r5t6yui@gmail.com', '1235', 'MENTOR'),
       ('Ходарева Таисия ???', '2003-02-23', '12345678@gmail.com', 'asdf', 'MENTOR'),
       ('Магдина Валерия ???', '2003-02-23', '1235@gmail.com', 'sdf', 'USER'),
       ('Зайцева Екатерина ???', '2003-02-23', '123456@gmail.com', 'asdsddas', 'MENTOR');

INSERT INTO tag (tag, id)
VALUES('back-end developert', 1),
('юрист', 2);


INSERT INTO catalog_professions (name, id)
VALUES('back-end developer', 1),
('юрист', 2);
