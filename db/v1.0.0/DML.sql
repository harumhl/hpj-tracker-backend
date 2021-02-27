INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Hazel', 12);         -- id = 1
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Basic', 9);         -- id = 2
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Body Care', 9);     -- id = 3
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Hobby', 0.5);         -- id = 4
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Mind', 3.5);          -- id = 5
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Others', 2);        -- id = 6
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Interpersonal', 1); -- id = 7
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Programming/AI', 1);-- id = 8
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Workout', 10);       -- id = 9

INSERT INTO public.task(category_id, name, archived, goal_count, max_count, multiplier, unit, expected_times_of_completion, details)
VALUES
    -- Hazel
    -- Basic
    (2, 'Brush teeth', false, 3, 3, 1.0, 'count', array['07:35', '12:45', '18:50'], ''),
    (2, 'Chores', false, 10, 15, 2.0, 'minutes', array['10:00'], ''),
    (2, 'Drink water', false, 6, 8, 1.25, 'cups', array['09:00', '11:00', '14:00', '16:00', '18:00', '20:00'], ''),
    (2, 'Poop', false, 1, 1, 1.0, 'count', array['07:40'], ''),
    (2, 'Read HPJtw', false, 1, 1, 1.0, 'count', array['07:40'], ''),
    (2, 'Rest', false, 30, 30, 1.0, 'minutes', array['12:50', '16:20', '18:55'], ''),
    (2, 'Shave', false, 1, 1, 1.0, 'count', array['07:30'], ''),
    (2, 'Shower', false, 2, 2, 1.0, 'count', array['07:50', '21:00'], ''),
    (2, 'Sleep 7 hours', false, 1, 1, 1.0, 'count', array['06:00'], ''),
    (2, 'Wake up at 6am', false, 1, 1, 1.0, 'count', array['06:00'], ''),
    (2, 'Write diary', false, 1, 1, 1.0, 'count', array['21:30'], ''),
    -- Body Care
    (3, 'Avoid sweets', false, 200, 200, 1.0, 'avoided calories', array['09:00', '21:00'], ''),
    (3, 'Body lotion', false, 1, 1, 1.0, 'count', array['08:00'], ''),
    (3, 'Eat healthy', false, 3, 3, 1.0, 'count', array['07:00', '12:00', '18:00'], ''),
    (3, 'Hair care', false, 1, 1, 1.0, 'count', array['08:50', '21:10'], ''),
    (3, 'Shampoo & mask', false, 1, 1, 1.0, 'count', array['08:50', '21:10'], ''),
    (3, 'Brush hair', false, 100, 100, 0.5, 'count', array['08:50', '21:10'], ''),
    (3, 'Massage face', false, 5, 5, 1.0, 'minutes', array['10:00', '11:00', '14:00', '15:00', '16:00', '17:00'], ''),
    (3, 'Masturbate on schedule', false, 1, 1, 1.0, 'count', array['09:00', '21:30'], ''),
    (3, 'Posture', false, 5, 5, 1.0, 'minutes', array['10:00', '11:00', '14:00', '15:00', '16:00', '17:00'], ''),
    (3, 'Posture correction', false, 5, 10, 1.0, 'minutes', array['10:00', '11:00', '14:00', '15:00', '16:00', '17:00'], ''),
    (3, 'Retainer', false, 10, 10, 1.0, 'minutes', array['22:15'], ''),
    (3, 'Skin care', false, 2, 2, 1.0, 'count', array['08:45', '21:15'], ''),
    (3, 'Smile', false, 5, 10, 1.0, 'minutes', array['10:00', '11:00', '14:00', '15:00', '16:00', '17:00'], ''),
    (3, 'Stretch', false, 5, 15, 1.0, 'count', array['07:00'], ''),
    (3, 'Learn to cook', false, 8, 16, 1.0, 'minutes', array['10:10'], ''),
    -- Hobby
    (4, 'Learn to dance', false, 8, 16, 1.0, 'minutes', array['08:00'], ''),
    -- Mind
    (5, 'Meditate', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    (5, 'Hypnosis', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    (5, 'Mindful', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    (5, 'Mirror', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    (5, 'Study mindful', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    (5, 'Talk with mindful', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    -- Others
    (6, 'Have fun', false, 5, 5, 1.0, 'minutes', array['08:00'], ''),
    (6, 'Memorize', false, 3, 9, 1.0, 'minutes', array['08:00'], ''),
    (6, 'Read out loud in English', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    (6, 'Read out loud in Korean', false, 5, 10, 1.0, 'minutes', array['08:00'], ''),
    (6, 'Learn more in general', false, 10, 10, 1.0, 'minutes', array['08:00'], ''),
    -- Interpersonal
    (7, 'Contact - text/call', false, 2, 4, 1.0, 'people', array['08:00'], ''),
    -- Programming/AI
    (8, 'Learn/practice programming', false, 10, 10, 1.0, 'minutes', array['08:00'], ''),
    (8, 'Learn/practice AI', false, 10, 10, 1.0, 'minutes', array['08:00'], ''),
    -- Workout
    (9, 'Running', false, 1.1, 10, 1.5, 'miles', array['08:00'], ''),
    (9, 'Walking', false, 30, 45, 1.5, 'minutes', array['08:00'], ''),
    (9, 'Kegel practice', false, 50, 100, 1.0, 'squeezes', array['08:00'], ''),
    (9, 'Ab workout', false, 100, 300, 1.5, 'count', array['08:00'], ''),
    (9, 'Donkey kicks', false, 50, 150, 1.5, 'count', array['08:00'], ''),
    (9, 'Fire hydrants', false, 50, 150, 1.5, 'count', array['08:00'], ''),
    (9, 'Squats', false, 50, 100, 1.5, 'count', array['08:00'], ''),
    (9, 'Lunges', false, 50, 100, 1.5, 'count', array['08:00'], ''),
    (9, 'Glute bridges', false, 50, 150, 1.0, 'count', array['08:00'], ''),
    (9, 'Jumping jacks', false, 100, 200, 1.0, 'count', array['08:00'], ''),
    (9, 'Push-ups', false, 30, 30, 1.0, 'count', array['08:00'], '')
;

-- INSERT INTO public.entry(done_date, task_id, name, count, hide, goal_count, max_count, multiplier)
-- VALUES ('2021-02-20', 1, 'Brush teeth', 1, false, 3, 3, 1.0);

