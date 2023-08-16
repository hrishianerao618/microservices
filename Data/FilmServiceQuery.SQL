-- SEQUENCE: public.language_language_id_seq

-- DROP SEQUENCE public.language_language_id_seq;

CREATE SEQUENCE public.language_language_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.language_language_id_seq
    OWNER TO postgres;
	
CREATE TABLE public.language
(
    language_id integer NOT NULL DEFAULT nextval('language_language_id_seq'::regclass),
    name character(20) COLLATE pg_catalog."default" NOT NULL,
    last_update timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT language_pkey PRIMARY KEY (language_id)
)

TABLESPACE pg_default;

ALTER TABLE public.language
    OWNER to postgres;



-- SEQUENCE: public.film_film_id_seq

-- DROP SEQUENCE public.film_film_id_seq;

CREATE SEQUENCE public.film_film_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.film_film_id_seq
    OWNER TO postgres;
	
	-- Type: mpaa_rating

-- DROP TYPE public.mpaa_rating;

CREATE TYPE public.mpaa_rating AS ENUM
    ('G', 'PG', 'PG-13', 'R', 'NC-17');

ALTER TYPE public.mpaa_rating
    OWNER TO postgres;

	
CREATE TABLE public.film
(
    film_id integer NOT NULL DEFAULT nextval('film_film_id_seq'::regclass),
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    release_year character varying COLLATE pg_catalog."default",
    language_id smallint NOT NULL,
    rental_duration smallint NOT NULL DEFAULT 3,
    rental_rate numeric(4,2) NOT NULL DEFAULT 4.99,
    length smallint,
    replacement_cost numeric(5,2) NOT NULL DEFAULT 19.99,
    rating character varying COLLATE pg_catalog."default" DEFAULT 'G'::mpaa_rating,
    last_update timestamp without time zone DEFAULT now(),
    special_features character varying COLLATE pg_catalog."default",
    fulltext tsvector,
    CONSTRAINT film_pkey PRIMARY KEY (film_id),
    CONSTRAINT film_language_id_fkey FOREIGN KEY (language_id)
        REFERENCES public.language (language_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)



ALTER TABLE public.film
    OWNER to postgres;
-- Index: film_fulltext_idx

-- DROP INDEX public.film_fulltext_idx;

CREATE INDEX film_fulltext_idx
    ON public.film USING gist
    (fulltext)
    TABLESPACE pg_default;
-- Index: idx_fk_language_id

-- DROP INDEX public.idx_fk_language_id;

CREATE INDEX idx_fk_language_id
    ON public.film USING btree
    (language_id ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: idx_title

-- DROP INDEX public.idx_title;

CREATE INDEX idx_title
    ON public.film USING btree
    (title COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;


