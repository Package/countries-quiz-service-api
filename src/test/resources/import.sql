/* Seed the in memory test database with sample data we can write tests against. */

-- Seed countries
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Montevideo', '.uy', 'https://flagcdn.com/w320/uy.png', 'Spanish', 'Uruguay', 3473727, 'South America');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Asunción', '.py', 'https://flagcdn.com/w320/py.png', 'Guaraní', 'Paraguay', 7132530, 'South America');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Banjul', '.gm', 'https://flagcdn.com/w320/gm.png', 'English', 'Gambia', 2416664, 'Western Africa');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Djibouti', '.dj', 'https://flagcdn.com/w320/dj.png', 'Arabic', 'Djibouti', 988002, 'Eastern Africa');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Fort-de-France', '.mq', 'https://flagcdn.com/w320/mq.png', 'French', 'Martinique', 378243, 'Caribbean');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Hagåtña', '.gu', 'https://flagcdn.com/w320/gu.png', 'Chamorro', 'Guam', 168783, 'Micronesia');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Tbilisi', '.ge', 'https://flagcdn.com/w320/ge.png', 'Georgian', 'Georgia', 3714000, 'Western Asia');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Washington, D.C.', '.us', 'https://flagcdn.com/w320/us.png', 'English', 'United States', 329484123, 'North America');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Belmopan', '.bz', 'https://flagcdn.com/w320/bz.png', 'Belizean Creole', 'Belize', 397621, 'Central America');
INSERT INTO country (capital, domain_extension, flag_src, language, name, population, subregion) VALUES('Port Louis', '.mu', 'https://flagcdn.com/w320/mu.png', 'English', 'Mauritius', 1265740, 'Eastern Africa');

-- Seed questions
INSERT INTO question(media_url, text, type) VALUES(null, 'Test Question', 0);
INSERT INTO question(media_url, text, type) VALUES(null, 'Test Question', 1);
INSERT INTO question(media_url, text, type) VALUES(null, 'Test Question', 2);
INSERT INTO question(media_url, text, type) VALUES(null, 'Test Question', 3);

-- Seed Answers
INSERT INTO answer(is_correct, text, question_id) VALUES (true, 'Answer 1', 1);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 2', 1);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 3', 1);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 4', 1);

INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 1', 2);
INSERT INTO answer(is_correct, text, question_id) VALUES (true, 'Answer 2', 2);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 3', 2);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 4', 2);

INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 1', 3);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 2', 3);
INSERT INTO answer(is_correct, text, question_id) VALUES (true, 'Answer 3', 3);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 4', 3);

INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 1', 4);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 2', 4);
INSERT INTO answer(is_correct, text, question_id) VALUES (false, 'Answer 3', 4);
INSERT INTO answer(is_correct, text, question_id) VALUES (true, 'Answer 4', 4);