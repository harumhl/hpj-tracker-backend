INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Hazel', 10);         -- id = 1
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Basic', 10);         -- id = 2
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Body Care', 10);     -- id = 3
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Hobby', 10);         -- id = 4
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Mind', 10);          -- id = 5
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Others', 10);        -- id = 6
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Interpersonal', 10); -- id = 7
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Programming/AI', 10);-- id = 8
INSERT INTO public.category(name, goal_in_comparable_unit) VALUES ('Workout', 10);       -- id = 9

INSERT INTO public.task(category_id, name, archived, goal_count, max_count, multiplier, unit, expected_times_of_completion)
	VALUES (2, 'Brush teeth', false, 3, 3, 1, 'count', array['07:00']);

-- INSERT INTO public.entry(done_date, task_id, name, count, hide, goal_count, max_count, multiplier)
-- VALUES ('2021-02-20', 1, 'Brush teeth', 1, false, 3, 3, 1.0);
