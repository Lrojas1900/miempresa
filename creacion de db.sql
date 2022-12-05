--base de datos de postgresql en local con puerto por defecto

CREATE DATABASE fabricaropa;

CREATE TABLE IF NOT EXISTS public.tipos
(
    id integer NOT NULL DEFAULT nextval('tipos_id_seq'::regclass),
    ropa character varying(100) COLLATE pg_catalog."default" NOT NULL,
    descripcion character varying(500) COLLATE pg_catalog."default",
    CONSTRAINT tipos_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.pedido
(
    id integer NOT NULL DEFAULT nextval('pedido_id_seq'::regclass),
    nombre character varying(80) COLLATE pg_catalog."default" NOT NULL,
    tipo_identificacion character varying(1) COLLATE pg_catalog."default" NOT NULL,
    identificacion character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pedido_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.itempedido
(
    id integer NOT NULL DEFAULT nextval('itempedido_id_seq'::regclass),
    peido_id integer NOT NULL,
    tipos_id integer NOT NULL,
    cantidad integer NOT NULL,
    fecha timestamp with time zone NOT NULL DEFAULT now(),
    direccion character varying(500) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT itempedido_pkey PRIMARY KEY (id),
    CONSTRAINT pedido_fk FOREIGN KEY (peido_id)
        REFERENCES public.pedido (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT tipos_fk FOREIGN KEY (tipos_id)
        REFERENCES public.tipos (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

INSERT INTO public.tipos(ropa, descripcion)	VALUES ('Camisas formales', 'Camisas formales');
INSERT INTO public.tipos(ropa, descripcion)	VALUES ('Pantalones formales', 'Pantalones formales');
INSERT INTO public.tipos(ropa, descripcion)	VALUES ('Chaquetas', 'Chaquetas');