CREATE TABLE avaliacao
(
    id_cli serial,
    nome_cli character varying(50),
    prontuario_cli character varying(50),
    turma_cli integer,
    rg_cli character varying(30),
    curso_cli character varying(30),
    data_cli character varying(30),    
    cpf_cli character varying(14),
    estaluno_cli character varying(15),
    CONSTRAINT cliente_pkey PRIMARY KEY (id_cli),
    CONSTRAINT cliente_cpf_key UNIQUE (cpf_cli)
)
