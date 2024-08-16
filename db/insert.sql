insert into roles (role) values ('admin');
insert into roles (role) values ('manager');
insert into roles (role) values ('programmer');
insert into roles (role) values ('sales');
insert into roles (role) values ('tester');
insert into roles (role) values ('recruiter');

insert into users (name, role_id) values
    ('admin_user','1');
insert into users (name, role_id) values
    ('manager_user','2');
insert into users (name, role_id) values
    ('programmer_user','3');
insert into users (name, role_id) values
    ('sales_user','4');
insert into users (name, role_id) values
    ('tester_user1','5');
insert into users (name, role_id) values
    ('tester_user2','5');
insert into users (name, role_id) values
    ('recruiter_user','6');

insert into rules (rule) values
    ('all');
insert into rules (rule) values
    ('read');
insert into rules (rule) values
    ('write');
insert into rules (rule) values
    ('delete');
insert into rules (rule) values
    ('insert');

insert into roles_rules (role_id, rule_id) values
    ('1','1');
insert into roles_rules (role_id, rule_id) values
    ('2','2');
insert into roles_rules (role_id, rule_id) values
    ('2','5');
insert into roles_rules (role_id, rule_id) values
    ('3','2');
insert into roles_rules (role_id, rule_id) values
    ('3','3');
insert into roles_rules (role_id, rule_id) values
    ('3','4');
insert into roles_rules (role_id, rule_id) values
    ('3','5');
insert into roles_rules (role_id, rule_id) values
    ('4','2');
insert into roles_rules (role_id, rule_id) values
    ('4','4');
insert into roles_rules (role_id, rule_id) values
    ('5','2');
insert into roles_rules (role_id, rule_id) values
    ('5','4');

insert into roles_rules (role_id, rule_id) values
    ('6','2');
insert into roles_rules (role_id, rule_id) values
    ('6','5');

insert into categories (category) values
    ('hire');
insert into categories (category) values
    ('fire');
insert into categories (category) values
    ('vacation');
insert into categories (category) values
    ('transfer');

insert into states (state) values
    ('new');
insert into states (state) values
    ('inwork');
insert into states (state) values
    ('confirm');
insert into states (state) values
    ('reject');

insert into items (item, user_id, category_id, state_id) values
    ('заявка 444','5', '1', '2' );
insert into items (item, user_id, category_id, state_id) values
    ('заявка 233','5', '4', '1' );
insert into items (item, user_id, category_id, state_id) values
    ('заявка 662','1', '4', '2' );
insert into items (item, user_id, category_id, state_id) values
    ('заявка 933','2', '2', '3' );

insert into comments (comment, item_id) values
    ('хочу в отпуск','1');
insert into comments (comment, item_id) values
    ('увольняюсь','3');
insert into comments (comment, item_id) values
    ('перевожусь','2');
insert into comments (comment, item_id) values
    ('работаю','4');

insert into attachs (attach, item_id) values
    ('файл word','1');
insert into attachs (attach, item_id) values
    ('файл exel','2');
insert into attachs (attach, item_id) values
    ('файл png','3');
insert into attachs (attach, item_id) values
    ('файл jpg','4');