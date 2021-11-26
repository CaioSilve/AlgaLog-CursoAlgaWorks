CREATE TABLE entrega(
	id BIGINT NOT NULL AUTO_INCREMENT,
	cliente_id BIGINT NOT NULL,
	taxa DECIMAL(10,2) NOT NULL, 
	STATUS VARCHAR(20) NOT NULL,
	data_pedido DATETIME NOT NULL,
	data_finalizacao DATETIME NOT NULL,
	
	destinatario_nome VARCHAR(60) NOT NULL,
	destinatario_logra VARCHAR(255) NOT NULL,
	destinatario_nume VARCHAR(30) NOT NULL,
	destinatario_comple VARCHAR(60) NOT NULL,
	destinatario_bairro VARCHAR(30) NOT NULL,
	
	PRIMARY KEY(id)
	

);

ALTER TABLE entrega ADD CONSTRAINT fk_entrega_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente(id);