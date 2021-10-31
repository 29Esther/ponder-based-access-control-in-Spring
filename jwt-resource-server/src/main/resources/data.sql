insert into school_user (age, email, first_name, last_name, user_name, id)
values (18, "s1@ecs235.edu", "Student", "One", "student1", 1);
insert into user (age, email, first_name, last_name, user_name, id)
values (18, "s1@ecs235.edu", "Student", "One", "student1", 1);
merge into school_user (age, email, first_name, last_name, user_name, id)
values (16, "s1@ecs235.edu", "Student", "Two", "student2", 2);
merge into school_user (age, email, first_name, last_name, user_name, id)
values (28, "s1@ecs235.edu", "Student", "Three", "student3", 3);
merge into school_user (age, email, first_name, last_name, user_name, id)
values (30, "s1@ecs235.edu", "Student", "Four", "student4", 4);

merge into school_user (age, email, first_name, last_name, user_name, id)
values (39, "l1@ecs235.edu", "Lecture", "One", "lecture1", 5);
merge into school_user (age, email, first_name, last_name, user_name, id)
values (47, "l2@ecs235.edu", "Lecture", "Two", "lecture2", 6);

merge into course (lecturer_id, level, name, id)
values (5, 0, "course1", 7);
merge into course (lecturer_id, level, name, id)
values (6, 2, "course2", 8);