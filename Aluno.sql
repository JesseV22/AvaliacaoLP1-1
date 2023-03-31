CREATE TABLE aluno
(
    id_cli serial,
    nome_cli character varying(50),    
    prontuarioCli integer,
	prontuarioCli integer,
    bairro_cli character varying(30),
    cidade_cli character varying(30),
    estado_cli character varying(2),
    cep_cli character varying(9),
    cpf_cli character varying(14),
    rg_cli character varying(15),
    CONSTRAINT cliente_pkey PRIMARY KEY (id_cli),
    CONSTRAINT cliente_cpf_key UNIQUE (cpf_cli)
)