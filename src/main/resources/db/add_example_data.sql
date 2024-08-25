insert into tasklist.user (role, email, first_name, last_name)
values
    ('USER','shrek@mail.ru','Shrek',''),
    ('USER', 'karlgauss@gmail.com', 'Karl', 'Gauss'),
    ('USER', 'mona@mail.ru', 'Mona', 'Lisa'),
    ('USER', 'davinci@gmail.com', 'Leonardo', 'da Vinci'),
    ('USER', 'makelourie@gmail.com', 'Mike', 'Lourie'),
    ('USER', 'hannamon@gmail.com', 'Hanna', 'Montana'),
    ('USER', 'sansai@gmail.com', 'Sansai', ''),
    ('USER', 'bruceeckel@gmail.com', 'Bruce', 'Eckel'),
    ('USER', 'albertein@gmail.com', 'Albert', 'Einstain'),
    ('USER', 'alant@gmail.com', 'Alan', 'Turing');

insert into tasklist.task (author_id, executor_id, title, description, priority, status)
values
    (1, 2, 'Матрицы',
     'Придумай новые матрицы, старые какие-то непонятные',
     'HIGH', 'WAITING'),
    (2, 4, 'Болото',
     'Необходимо переделать болота в стадионы',
     'MEDIUM', 'COMPLETED'),
    (7, 3, 'Программа для взлома',
     'Напиши программу для взлома пентагона, чтоб все ломало сразу',
     'LOW', 'WAITING'),
    (5, 9, 'Покраска стен',
     'Надо покрасить стены в прихожей, по окончании работ доклад наверх',
     'HIGH', 'IN_PROGRESS'),
    (2, 4, 'Дистрибутив линукса',
     'Создать новый дистрибутив линукса, чтоб сам все драйвера качал нужные и проблем вообще не было',
     'HIGH', 'COMPLETED'),
    (5, 3, 'Лодка',
     'Сколоти лодку для ловли рыби',
     'MEDIUM', 'IN_PROGRESS'),
    (6, 8, 'Проблемы глобального потепления',
     'Реши проблему глобального потепления вечерком',
     'LOW', 'COMPLETED'),
    (10, 7, 'Звезды',
     'Покрасить звезды в другой цвет',
     'HIGH', 'IN_PROGRESS'),
    (6, 2, 'Машина',
     'Надо починить машину',
     'LOW', 'IN_PROGRESS'),
    (8, 9, 'Дедлайн на проекте',
     'Проект горит, нужно срочно закончить его',
     'HIGH', 'IN_PROGRESS');

insert into tasklist.comment (commentator_id, task_id, comment)
values
    (1, 6, 'В мое время такого не было'),
    (4, 7, 'хахаха'),
    (1, 8, 'Я уже такое где-то видел'),
    (4, 10, 'А я бы по-другому сделал'),
    (7, 8, 'Неужто сам так решил'),
    (3, 6, 'Нет бы сначала разобраться, а потом уже...'),
    (1, 5, 'Никакого самоуважения'),
    (4, 9, 'Да вы вообще ничего не умеете, я бы то же самое лучше сделал!');