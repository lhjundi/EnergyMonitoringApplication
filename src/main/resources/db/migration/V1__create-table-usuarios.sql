CREATE TABLE usuarios(
id bigint,
email VARCHAR(255) NOT NULL,
nome VARCHAR(100) NOT NULL,
senha VARCHAR(255) NOT NULL,
consumomax NUMERIC(10, 2) NOT NULL,
CONSTRAINT pk_usuario_id PRIMARY KEY(id),
CONSTRAINT uq_usuario_email UNIQUE(email)
);