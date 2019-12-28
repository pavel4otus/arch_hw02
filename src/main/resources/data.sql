--
-- страны
--
insert into countries( id, code, name) values( 1, '643', 'РОССИЯ');
insert into countries( id, code, name) values( 2, '840', 'США');
insert into countries( id, code, name) values( 3, '276', 'ГЕРМАНИЯ');
insert into countries( id, code, name) values( 4, '250', 'Франция');

--
-- города
--
insert into  cities( id, country_id, code, name) values( 1, 1, 'СПБ', 'Санкт-Петербург');
insert into  cities( id, country_id, code, name) values( 2, 1, 'МСК', 'Москва');
insert into  cities( id, country_id, code, name) values( 3, 1, 'ОРЛ', 'Орел');
insert into  cities( id,country_id,  code, name) values( 4, 1, 'ТВР', 'Тверь');

--
-- улицы
--
insert into streets ( id, city_id, name) values ( 1, 1, 'Благодатная');
insert into streets ( id, city_id, name) values ( 2, 1, 'Кирочная');
insert into streets ( id, city_id, name) values ( 3, 2, 'Земляной Вал');
insert into streets ( id, city_id, name) values ( 4, 3, 'Ленина');

--
-- адреса
--
insert into addresses( id, street_id, zip, house, building, flat) values ( 1, 1, '198302', '1а', '1', '' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 2, 2, '198302', '2а', '2', '' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 3, 3, '198302', '3а', '3', '3' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 4, 4, '198302', '4а', '4', '2' );
insert into addresses( id, street_id, zip, house, building, flat) values ( 5, 1, '198302', '5а', '5', '1' );

--
-- склады
--
insert into warehouses( id, name, contacts, schedule, address_id) values ( 1, 'Склад 1', 'sk1@mail.ru',     'с 10.00 до 21.00', 1 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 2, 'Склад 2', '8(495)123-45-67', 'с 11.00 до 22.00', 2 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 3, 'Склад 3', '8(22390)121212',  'с 12.00 до 23.00', 3 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 4, 'Склад 4', '8(1212)121212',   'с 13.00 до 24.00', 4 );
insert into warehouses( id, name, contacts, schedule, address_id) values ( 5, 'Склад 5', '8(800)1220292009','с 14.00 до 19.00', 5 );


--
-- бренды
--
insert into brands( id, name, description, country_id) values( 1, 'Bosch', '', 3);
insert into brands( id, name, description, country_id) values( 2, 'Siemens', '', 3);
insert into brands( id, name, description, country_id) values( 3, 'Cadillac', '', 2);
insert into brands( id, name, description, country_id) values( 4, 'ВАЗ', '', 1);

--
-- категории
--
insert into categories( id, code, name) values( 1, 'ELECTRO', 'Бытовая электроника');
insert into categories( id, code, name) values( 2, 'PHONES',  'Сотовые телефоны');
insert into categories( id, code, name) values( 3, 'BOOKS',   'Книги');
insert into categories( id, code, name) values( 4, 'DIGITAL', 'Цифровые товары');

--
-- статусы заказа
--
insert into statuses( id, code, name) values(  1, 'NEW', 'Создан');
insert into statuses( id, code, name) values(  2, 'CREATED', 'Оформлен');
insert into statuses( id, code, name) values(  3, 'PAYED', 'Оплачен');
insert into statuses( id, code, name) values(  4, 'TO_ASSEMBLED', 'Передан для сборки');
insert into statuses( id, code, name) values(  5, 'ASSEMBLING', 'Собирается');
insert into statuses( id, code, name) values(  6, 'ASSEMBLED', 'Собран');
insert into statuses( id, code, name) values(  7, 'TO_TRANSIT', 'Передан для отправки');
insert into statuses( id, code, name) values(  8, 'IN_TRANSIT', 'В пути');
insert into statuses( id, code, name) values(  9, 'DELIVERED', 'Доставлен в конечную точку');
insert into statuses( id, code, name) values( 10, 'RECEIVED', 'Получен клиентом');
insert into statuses( id, code, name) values( 11, 'CANCELED', 'Отменен');


--
-- пользователи пароль у всех 12345
--
insert into users( id, email, password, fio, phone, active, role) values( 1, 'admin@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Admin',   '+7(921)123-48-11', true, 'ROLE_ADMIN');
insert into users( id, email, password, fio, phone, active, role) values( 2, 'test2@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Петров',   '+7(921)123-48-12', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 3, 'test3@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Сидоров',  '+7(921)123-48-13', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 4, 'test4@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Кузнецов', '+7(921)123-48-14', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 5, 'test5@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Лавров',   '+7(921)123-48-15', true, 'ROLE_USER');
insert into users( id, email, password, fio, phone, active, role) values( 6, 'test6@mail.ru', '$2a$10$j2tFtUiRohlLp8HMfXAcD.clyBy50LGR6ntj2yRMJWJb1L9J4vP8m', 'Козин',    '+7(921)123-48-16', true, 'ROLE_USER');
