CREATE TABLE tb_missoes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    rank VARCHAR(20) NOT NULL
);

CREATE TABLE tb_cadastro_ninjas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER,
    email VARCHAR(150) UNIQUE NOT NULL,
    level VARCHAR(20) NOT NULL,
    imagem_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT  now(),
    missao_id BIGINT,

    CONSTRAINT fk_ninja_missao
                    FOREIGN KEY (missao_id)
                    REFERENCES tb_missoes(id)
);
