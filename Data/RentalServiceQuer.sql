CREATE SEQUENCE public.staff_staff_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.staff_staff_id_seq
    OWNER TO postgres;
	
	CREATE TABLE public.staff
(
    staff_id integer NOT NULL DEFAULT nextval('staff_staff_id_seq'::regclass),
    first_name character varying(45) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(45) COLLATE pg_catalog."default" NOT NULL,
    address_id smallint NOT NULL,
    email character varying(50) COLLATE pg_catalog."default",
    store_id smallint NOT NULL,
    active boolean NOT NULL DEFAULT true,
    username character varying(16) COLLATE pg_catalog."default" NOT NULL,
    password character varying(40) COLLATE pg_catalog."default",
    last_update timestamp without time zone NOT NULL DEFAULT now(),
    picture bytea,
    CONSTRAINT staff_pkey PRIMARY KEY (staff_id)
)


ALTER TABLE public.staff
    OWNER to postgres;


CREATE SEQUENCE public.inventory_inventory_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.inventory_inventory_id_seq
    OWNER TO postgres;
	
	
CREATE TABLE public.inventory
(
    inventory_id integer NOT NULL DEFAULT nextval('inventory_inventory_id_seq'::regclass),
    film_id smallint NOT NULL,
    store_id smallint NOT NULL,
    last_update timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT inventory_pkey PRIMARY KEY (inventory_id)
)



ALTER TABLE public.inventory
    OWNER to postgres;
-- Index: idx_store_id_film_id

-- DROP INDEX public.idx_store_id_film_id;

CREATE INDEX idx_store_id_film_id
    ON public.inventory USING btree
    (store_id ASC NULLS LAST, film_id ASC NULLS LAST)
    TABLESPACE pg_default;





CREATE SEQUENCE public.rental_rental_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.rental_rental_id_seq
    OWNER TO postgres;
	
	
	
	
CREATE TABLE public.rental
(
    rental_id integer NOT NULL DEFAULT nextval('rental_rental_id_seq'::regclass),
    rental_date timestamp without time zone NOT NULL,
    inventory_id integer NOT NULL,
    customer_id smallint NOT NULL,
    return_date timestamp without time zone,
    staff_id smallint NOT NULL,
    last_update timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT rental_pkey PRIMARY KEY (rental_id),
    CONSTRAINT rental_inventory_id_fkey FOREIGN KEY (inventory_id)
        REFERENCES public.inventory (inventory_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT rental_staff_id_key FOREIGN KEY (staff_id)
        REFERENCES public.staff (staff_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



ALTER TABLE public.rental
    OWNER to postgres;
-- Index: idx_fk_inventory_id

-- DROP INDEX public.idx_fk_inventory_id;

CREATE INDEX idx_fk_inventory_id
    ON public.rental USING btree
    (inventory_id ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: idx_unq_rental_rental_date_inventory_id_customer_id

-- DROP INDEX public.idx_unq_rental_rental_date_inventory_id_customer_id;

CREATE UNIQUE INDEX idx_unq_rental_rental_date_inventory_id_customer_id
    ON public.rental USING btree
    (rental_date ASC NULLS LAST, inventory_id ASC NULLS LAST, customer_id ASC NULLS LAST)
    TABLESPACE pg_default;


