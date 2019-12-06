CREATE TABLE "categorias"
(
    "idCategoria" serial       NOT NULL,
    "categoria"   varchar(255) NOT NULL,
    CONSTRAINT "categorias_pk" PRIMARY KEY ("idCategoria")
) WITH (
      OIDS= FALSE
    );

CREATE TABLE "produtos"
(
    "idProduto"   serial       NOT NULL,
    "idCategoria" bigint       NOT NULL,
    "produto"     varchar(255) NOT NULL,
    "preco"       DECIMAL      NOT NULL,
    "quantidade"  integer      NOT NULL,
    "descricao"   varchar(255) NOT NULL,
    "foto"        bytea        NOT NULL,
    CONSTRAINT "produtos_pk" PRIMARY KEY ("idProduto")
) WITH (
      OIDS= FALSE
    );

CREATE TABLE "clientes"
(
    "idCliente" serial       NOT NULL,
    "nome"      varchar(255) NOT NULL,
    "email"     varchar(255) NOT NULL,
    "senha"     varchar(255) NOT NULL,
    "rua"       varchar(100) NOT NULL,
    "cidade"    varchar(100) NOT NULL,
    "bairro"    varchar(150) NOT NULL,
    "cep"       varchar(8)   NOT NULL,
    "estado"    varchar(2)   NOT NULL,
    CONSTRAINT "clientes_pk" PRIMARY KEY ("idCliente")
) WITH (
      OIDS= FALSE
    );

CREATE TABLE "pedidos"
(
    "idPedido"  serial       NOT NULL,
    "data"      DATE         NOT NULL,
    "idCliente" bigint       NOT NULL,
    "status"    int          NOT NULL,
    "sessao"    varchar(255) NOT NULL,
    CONSTRAINT "pedidos_pk" PRIMARY KEY ("idPedido")
) WITH (
      OIDS= FALSE
    );

CREATE TABLE "pedidosItens"
(
    "idItem"     serial       NOT NULL,
    "idPedido"   bigint       NOT NULL,
    "idProduto"  bigint       NOT NULL,
    "produto"    varchar(255) NOT NULL,
    "quantidade" integer      NOT NULL,
    "valor"      DECIMAL      NOT NULL,
    "subtotal"   DECIMAL      NOT NULL,
    CONSTRAINT "pedidosItens_pk" PRIMARY KEY ("idItem")
) WITH (
      OIDS= FALSE
    );

ALTER TABLE "produtos"
    ADD CONSTRAINT "fk_produtos_categoria" FOREIGN KEY ("idCategoria") REFERENCES "categorias" ("idCategoria");


ALTER TABLE "pedidos"
    ADD CONSTRAINT "fk_pedidos_cliente" FOREIGN KEY ("idCliente") REFERENCES "clientes" ("idCliente");

ALTER TABLE "pedidosItens"
    ADD CONSTRAINT "fk_pedidosItens_pedido" FOREIGN KEY ("idPedido") REFERENCES "pedidos" ("idPedido");
ALTER TABLE "pedidosItens"
    ADD CONSTRAINT "fk_pedidosItens_produto" FOREIGN KEY ("idProduto") REFERENCES "produtos" ("idProduto");


INSERT INTO "clientes" ("nome", "email", "senha", "rua", "cidade", "bairro", "cep", "estado")
VALUES ('Warley', 'wsrochab@gmail.com', '$2a$10$oLSlGuWbD43fYrw.7DzkQubr2Q8Ronbnw8r1zpkjTHzJsQ6z5oXPq', 'Nossa Senhora',
        'São Paulo', 'Vila Isa','72000000', 'SP');