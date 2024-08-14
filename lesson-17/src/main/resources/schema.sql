CREATE TABLE Students (
student_id SERIAL PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name  VARCHAR(255) NOT NULL
);

CREATE TABLE Tests (
test_id   SERIAL PRIMARY KEY,
test_name VARCHAR(255) NOT NULL
);

CREATE TABLE Questions (
question_id   SERIAL PRIMARY KEY,
test_id       INT REFERENCES Tests (test_id),
question_text TEXT NOT NULL
);

CREATE TABLE Answers (
answer_id   SERIAL PRIMARY KEY,
question_id INT REFERENCES Questions (question_id),
answer_text TEXT    NOT NULL,
is_correct  BOOLEAN NOT NULL
);

CREATE TABLE TestResults (
result_id  SERIAL PRIMARY KEY,
student_id INT REFERENCES Students (student_id),
test_id    INT REFERENCES Tests (test_id),
test_date  DATE NOT NULL
);

CREATE TABLE StudentAnswers (
student_answer_id SERIAL PRIMARY KEY,
result_id         INT REFERENCES TestResults (result_id),
question_id       INT REFERENCES Questions (question_id),
answer_id         INT REFERENCES Answers (answer_id)
);

INSERT INTO Tests (test_name) VALUES ('тест по математике'), ('тест по физике');

INSERT INTO Questions (test_id, question_text) VALUES
(1, 'Сколько будет 2 + 2 * 2'),
(2, 'В каком году был изобретен вечный двигатель?');

INSERT INTO Answers (question_id, answer_text, is_correct) VALUES
(1, '8', FALSE),
(1, '6', TRUE),
(2, '1905', FALSE),
(2, '1875', FALSE),
(2, 'Не был создан', TRUE),
(2, '1903', FALSE),
(2, '1977', FALSE);

INSERT INTO Students (first_name, last_name) VALUES ('Otus', 'Course');

SELECT student_id FROM Students WHERE first_name = 'Otus' AND last_name = 'Course';

INSERT INTO TestResults (student_id, test_id, test_date) VALUES (1, 1, CURRENT_DATE);

SELECT
tr.result_id,
q.question_id,
a.answer_id
FROM
    TestResults tr
        JOIN Questions q ON tr.test_id = q.test_id
        JOIN Answers a ON q.question_id = a.question_id
WHERE
tr.student_id = 1;

INSERT INTO StudentAnswers (result_id, question_id, answer_id) VALUES
(1, 1, 2),
(1, 2, 3);


SELECT
q.question_text,
a.answer_text,
a.is_correct
FROM
    Questions q
        JOIN Answers a ON q.question_id = a.question_id;

SELECT
q.question_text,
a.answer_text
FROM
    Questions q
        JOIN Answers a ON q.question_id = a.question_id
WHERE
a.is_correct = TRUE;