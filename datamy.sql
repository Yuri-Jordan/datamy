--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

-- Started on 2017-06-07 10:20:26 BRT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12395)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


-- Table: public.user_token

-- DROP TABLE public.user_token;

CREATE TABLE public.user_token
(
  id bigint NOT NULL DEFAULT nextval('user_token_id_seq'::regclass),
  user_id integer,
  token text,
  CONSTRAINT user_token_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.user_token
  OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 32769)
-- Name: cartaocredito; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cartaocredito (
    id integer NOT NULL,
    nometitular character varying(255) NOT NULL,
    numero integer NOT NULL,
    usuario_id integer NOT NULL
);


ALTER TABLE cartaocredito OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 32772)
-- Name: chamado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE chamado (
    id integer NOT NULL,
    titulo character varying(255) NOT NULL,
    datainicio timestamp without time zone DEFAULT now() NOT NULL,
    tipo character varying(255) NOT NULL,
    datafim timestamp without time zone,
    status character varying(45) DEFAULT 'Em aberto'::character varying NOT NULL,
    descricao character varying(255) NOT NULL,
    pathimagem character varying(255) DEFAULT NULL::character varying,
    usuario_id integer NOT NULL
);


ALTER TABLE chamado OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 32781)
-- Name: comprarelatorio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE comprarelatorio (
    id integer NOT NULL,
    datacomprarelatorio timestamp without time zone DEFAULT now() NOT NULL,
    valorcompra double precision NOT NULL,
    parcelas integer NOT NULL,
    quantidade integer NOT NULL,
    usuario_id integer NOT NULL
);


ALTER TABLE comprarelatorio OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 32785)
-- Name: estatistica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE estatistica (
    id integer NOT NULL,
    status character varying(255) DEFAULT 'A fazer'::character varying NOT NULL,
    datauso timestamp without time zone DEFAULT now() NOT NULL,
    caminhoarquivo character varying(255) NOT NULL,
    comprarelatorio_id integer NOT NULL
);


ALTER TABLE estatistica OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 32793)
-- Name: facebook; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE facebook (
    iddadosfacebook integer NOT NULL,
    gostei integer NOT NULL,
    amei integer NOT NULL,
    haha integer NOT NULL,
    triste integer NOT NULL,
    raiva integer NOT NULL,
    comentarios character varying(255) NOT NULL,
    uou integer NOT NULL
);


ALTER TABLE facebook OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 32796)
-- Name: twitter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE twitter (
    iddadostwitter integer NOT NULL,
    curtidas integer NOT NULL,
    retweets integer NOT NULL,
    falandosobre integer NOT NULL,
    replys character varying(255) NOT NULL
);


ALTER TABLE twitter OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 32799)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id integer NOT NULL,
    cpf character varying(11) NOT NULL,
    nomecompleto character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    perfil character varying(50) DEFAULT 'padrao'::character varying NOT NULL,
    status character varying(50) DEFAULT 'confirmar'::character varying NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 2166 (class 0 OID 32769)
-- Dependencies: 181
-- Data for Name: cartaocredito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cartaocredito (id, nometitular, numero, usuario_id) FROM stdin;
1	luiz	1653127323	1
2	luiz silva junior	1276351	1
3	junior luiz silva	213542112	1
4	luiz junior silva	13151673	1
5	luiz silva Junior	4313422	1
6	teste	3123	1
\.


--
-- TOC entry 2167 (class 0 OID 32772)
-- Dependencies: 182
-- Data for Name: chamado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY chamado (id, titulo, datainicio, tipo, datafim, status, descricao, pathimagem, usuario_id) FROM stdin;
\.


--
-- TOC entry 2168 (class 0 OID 32781)
-- Dependencies: 183
-- Data for Name: comprarelatorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY comprarelatorio (id, datacomprarelatorio, valorcompra, parcelas, quantidade, usuario_id) FROM stdin;
1	2017-01-21 19:59:19	200	9	5	1
7	2017-01-24 23:53:51	400	2	10	1
8	2017-02-06 14:47:42	200	1	5	1
\.


--
-- TOC entry 2169 (class 0 OID 32785)
-- Dependencies: 184
-- Data for Name: estatistica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY estatistica (id, status, datauso, caminhoarquivo, comprarelatorio_id) FROM stdin;
1	Feito	2017-02-11 21:19:14	teste	1
2	Feito	2017-02-11 21:19:14	Usado	7
3	Gerando	2017-02-11 21:19:14	teste	8
4	Gerando	2017-02-11 21:19:14	teste	1
\.


--
-- TOC entry 2170 (class 0 OID 32793)
-- Dependencies: 185
-- Data for Name: facebook; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY facebook (iddadosfacebook, gostei, amei, haha, triste, raiva, comentarios, uou) FROM stdin;
1	2345	3421	123	42	45	maravilha maravilhoso gostei amei maravilha gostei maravilha	450
\.


--
-- TOC entry 2171 (class 0 OID 32796)
-- Dependencies: 186
-- Data for Name: twitter; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY twitter (iddadostwitter, curtidas, retweets, falandosobre, replys) FROM stdin;
1	2131	345	345	melhor incrivel esplendido maravilhoso melhor amei amei amei melhor maravilhoso
\.


--
-- TOC entry 2172 (class 0 OID 32799)
-- Dependencies: 187
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id, cpf, nomecompleto, email, perfil, status, username, password) FROM stdin;
1	01646998480	ricardo luiz da silva junior	junior@gmail.com	padrao	confirmar	luiz	123
2	01648549870	Suporte Do Sistema	suporte@datamy.com	suporte	confirmar	suporte	123
3	01678412470	Administrador do Sistema	admin@datamy.com	administrador	confirmar	admin	admin
\.


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-06-07 10:20:26 BRT

--
-- PostgreSQL database dump complete
--
