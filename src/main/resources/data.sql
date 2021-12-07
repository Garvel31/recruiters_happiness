
DELETE FROM user_tbl;
INSERT INTO user_tbl (uid, isaccountnonexpired,isaccountnonlocked,iscredentialsnonexpired, isenabled, password, role, username ) VALUES
                                                      ('1','true', 'true', 'true', 'true', '12345', 'PM', 'ProductManager'),
                                                      ('2','true', 'true', 'true', 'true', '12345', 'HR', 'HeadRecruiter'),
                                                      ('3','true', 'true', 'true', 'true', '12345', 'DM', 'DevManager');

DELETE FROM technology;
INSERT INTO technology (tech)
VALUES
    ('Java'),('Python'),('Spring'),('Django'),('SQL'),('Postgres'),('JS'),('NodeJS'),('Hibernate'),('Docker'),
       ('MySQL'),('C#'),('.NET'),('Kotlin'),('Flask');


DELETE FROM project;
DELETE FROM projecttype;
DELETE FROM teaminfo;
DELETE FROM workingconditions;


INSERT INTO workingconditions (id, adress, isinoffice, isovertimeexpect, istimelag, procedure, schedule)
VALUES
    (-1, 'Николая Платонова 79', 'true','true', 'true', 'Собеседование с TeamLead', 'пн - птн');

INSERT INTO teaminfo (id, productdev, teamformed, allteamnumber, analiticsnumber, backnumber, designernumber, devmetodology, devsnumber, frontnumber, fullstacknumber, techpisnumber, testernumber)
VALUES
    (-1, 'true','true', 6, 1, 2, 0,'Agile', 0,0,3,0,0);

INSERT INTO projecttype (id, isfromscratch, ismvp, ispo, ispaytype)
VALUES
    (-1, 'true','true','true','true');

INSERT INTO project ( id, active, created, customer, description, draft, end_terms, func_direction,  gost_doc,
                     problem_to_solve, proj_stage, projectauthor,  project_name, stakeholder_number,
                     subject_area, technology,  updated, projecttype_id, teaminfo_id, workingconditions_id)
                     VALUES
                        (-1,'true','2021-12-01 00:52:05.860462','Савельев','создание сервиса по автоматизации производства','false',
                         '14-04-2022','автоматизация производства','true','разработка сервиса, подключение БД','Середина','Победа Александр','Орбита',
                         '2','онлайн сервис по автоматизации производства','Spring, instagram','2021-12-01 00:52:05.860462', -1, -1,-1);

INSERT INTO workingconditions (id, adress, isinoffice, isovertimeexpect, istimelag, procedure, schedule)
VALUES
    (-2, 'Чумичева 17', 'true','true', 'true', 'Собеседование с TeamLead', 'пн - птн');

INSERT INTO teaminfo (id, productdev, teamformed, allteamnumber, analiticsnumber, backnumber, designernumber, devmetodology, devsnumber, frontnumber, fullstacknumber, techpisnumber, testernumber)
VALUES
    (-2, 'true','true', 6, 1, 2, 0,'Agile', 0,0,3,0,0);

INSERT INTO projecttype (id, isfromscratch, ismvp, ispo, ispaytype)
VALUES
    (-2, 'true','true','true','true');

INSERT INTO project ( id, active, created, customer, description, draft, end_terms, func_direction,  gost_doc,
                      problem_to_solve, proj_stage, projectauthor,  project_name, stakeholder_number,
                      subject_area, technology,  updated, projecttype_id, teaminfo_id, workingconditions_id)
VALUES
    (-2,'true','2021-11-03 00:52:05.860462','Игнатьев','создание сервиса по выдаче займов','false',
     '14-04-2022','автоматизация выдачи кредитов','false','разработка сервиса, подключение БД','Инициация','Федоров Михаил','ГПН',
     '2','онлайн сервис','Spring, instagram','2021-12-01 00:52:05.860462', -2, -2,-2);








--
-- WITH data(active, created, customer, description, draft, end_terms, func_direction,  gost_doc,
--           problem_to_solve, proj_stage, projectauthor,  project_name, stakeholder_number,
--           subject_area, technology,  updated, isfromscratch, ismvp, ispo, ispaytype) AS (
--     VALUES                              -- provide data here
--     ('true','2021-12-01 00:52:05.860462','Савельев','создание сервиса по автоматизации производства','false',
--      '14-04-2022','автоматизация производства','true','разработка сервиса, подключение БД','с нуля','Победа Александр','Орбита',
--      '2','онлайн сервис по автоматизации производства','Spring, instagram','2021-12-01 00:52:05.860462', 'true','true','true','true') -- see below
--
-- )
--    , ins1 AS (
--     INSERT INTO project (active, created, customer, description, draft, end_terms, func_direction,  gost_doc,
--                          problem_to_solve, proj_stage, projectauthor,  project_name, stakeholder_number,
--                          subject_area, technology,  updated)
--         SELECT active, created, customer, description, draft, end_terms, func_direction,  gost_doc,
--                problem_to_solve, proj_stage, projectauthor,  project_name, stakeholder_number,
--                subject_area, technology,  updated        -- DISTINCT? see below
--         FROM   data
--         -- ON     CONFLICT DO NOTHING       -- UNIQUE constraint? see below
--         RETURNING active, created, customer, description, draft, end_terms, func_direction,  gost_doc,
--             problem_to_solve, proj_stage, projectauthor,  project_name, stakeholder_number,
--             subject_area, technology,  updated, id AS project_id
-- )
--    , ins2 AS (
--     INSERT INTO projecttype (project_id, isfromscratch, ismvp, ispo, ispaytype)
--         SELECT ins1.project_id, d.isfromscratch, d.ismvp, d.ispo, d.ispaytype
--         FROM   data d
--                    JOIN   ins1 USING (active, created, customer, description, draft, end_terms, func_direction, gost_doc, problem_to_solve, proj_stage, projectauthor, project_name, stakeholder_number, subject_area, technology, updated)
--         RETURNING project_id, id AS projecttype_id
-- )
-- INSERT INTO project(projecttype_id) VALUES (id)
-- --
-- --
