CREATE TABLE "usuario"
(
    "id"    SERIAL NOT NULL,
    "nome"  TEXT   NOT NULL,
    "login" TEXT   NOT NULL,
    "senha" TEXT   NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );

INSERT INTO "usuario" ("nome", "login", "senha")
VALUES ('Usuario', 'user', '$2a$10$oLSlGuWbD43fYrw.7DzkQubr2Q8Ronbnw8r1zpkjTHzJsQ6z5oXPq');