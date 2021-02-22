-- Table: public.category
CREATE TABLE public.category
(
    id SERIAL NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    color text COLLATE pg_catalog."default",
    goal_in_comparable_unit integer,
    CONSTRAINT category_pkey PRIMARY KEY (id)
) TABLESPACE pg_default;

ALTER TABLE public.category OWNER to hwmvazhkynagfn;

-- Table: public.task
CREATE TABLE public.task
(
    id SERIAL NOT NULL,
    category_id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    archived boolean NOT NULL,
    goal_count integer NOT NULL,
    max_count integer NOT NULL,
    count_to_comparable_unit double precision NOT NULL,
    unit text COLLATE pg_catalog."default" NOT NULL,
    expected_times_of_completion text[] COLLATE pg_catalog."default" NOT NULL,
    details text COLLATE pg_catalog."default",
    CONSTRAINT task_pkey PRIMARY KEY (id),
    CONSTRAINT fk_task_category_id_category_id FOREIGN KEY (category_id)
        REFERENCES public.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
) TABLESPACE pg_default;

ALTER TABLE public.task OWNER to hwmvazhkynagfn;

-- Table: public.entry
CREATE TABLE public.entry
(
    id SERIAL NOT NULL,
    done_date date NOT NULL,
    task_id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    count integer NOT NULL,
    hide boolean NOT NULL,
    goal_count integer NOT NULL,
    max_count integer NOT NULL,
    count_to_comparable_unit double precision NOT NULL,
    details jsonb,
    CONSTRAINT entry_pkey PRIMARY KEY (id),
    CONSTRAINT fk_entry_task_id_task_id FOREIGN KEY (task_id)
        REFERENCES public.task (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
) TABLESPACE pg_default;

ALTER TABLE public.entry OWNER to hwmvazhkynagfn;

-- View: public.task_with_category_name
CREATE OR REPLACE VIEW public.task_with_category_name AS
    SELECT task.*, category.name AS category_name
    FROM task
    LEFT JOIN category ON category.id = task.category_id;

ALTER TABLE public.task_with_category_name OWNER TO hwmvazhkynagfn;

-- View: public.entry_with_category_name_and_goal_name
CREATE OR REPLACE VIEW public.entry_with_category_name_and_goal_name AS
    SELECT entry.*, task.name AS task_name, task.category_name AS category_name
    FROM entry
    LEFT JOIN task_with_category_name task
    ON task.id = entry.task_id;

ALTER TABLE public.entry_with_category_name_and_goal_name OWNER TO hwmvazhkynagfn;

-- View: public.completion_units_per_category
CREATE OR REPLACE VIEW public.completion_units_per_category AS
    SELECT calculated.category_name, SUM(calculated.percent) AS percent_sum, calculated.goal_in_comparable_unit, SUM(calculated.percent) / calculated.goal_in_comparable_unit * 100 AS completion_percent
    FROM (
        SELECT *, CAST(count AS DOUBLE PRECISION) / e.goal_count * e.count_to_comparable_unit AS percent
        FROM public.entry_with_category_name_and_goal_name e
		LEFT JOIN category
		ON category.name = e.category_name
    ) calculated
    GROUP BY calculated.category_name, calculated.goal_in_comparable_unit;

ALTER TABLE public.completion_units_per_category OWNER TO hwmvazhkynagfn;
