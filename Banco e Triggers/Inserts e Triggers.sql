use delivery;

-- Ingredientes

INSERT INTO ingrediente VALUES("Molho de tomate");
INSERT INTO ingrediente VALUES("Muçarela");
INSERT INTO ingrediente VALUES("Calabresa picada");
INSERT INTO ingrediente VALUES("Bacon picado");
INSERT INTO ingrediente VALUES("Pimenta calabresa");
INSERT INTO ingrediente VALUES("Orégano");
INSERT INTO ingrediente VALUES("Azeitora");
INSERT INTO ingrediente VALUES("Parmesão");
INSERT INTO ingrediente VALUES("Alho frito");
INSERT INTO ingrediente VALUES("Abobrinha");
INSERT INTO ingrediente VALUES("Tomate");
INSERT INTO ingrediente VALUES("Aliche");
INSERT INTO ingrediente VALUES("Presunto fatiado");
INSERT INTO ingrediente VALUES("Champignon");
INSERT INTO ingrediente VALUES("Atum");
INSERT INTO ingrediente VALUES("Cebola");
INSERT INTO ingrediente VALUES("Palmito");
INSERT INTO ingrediente VALUES("Peperoni");
INSERT INTO ingrediente VALUES("Ervilha");
INSERT INTO ingrediente VALUES("Ovo");
INSERT INTO ingrediente VALUES("Provolone");
INSERT INTO ingrediente VALUES("Catupiry");
INSERT INTO ingrediente VALUES("Tomate seco");
INSERT INTO ingrediente VALUES("Rúcula");
INSERT INTO ingrediente VALUES("Strogonoff");
INSERT INTO ingrediente VALUES("Batata palha");
INSERT INTO ingrediente VALUES("Banana");
INSERT INTO ingrediente VALUES("Brigadeiro");
INSERT INTO ingrediente VALUES("Chocolate");
INSERT INTO ingrediente VALUES("Bombom");
INSERT INTO ingrediente VALUES("Creme de leite");
INSERT INTO ingrediente VALUES("Berinjela assada");
INSERT INTO ingrediente VALUES("Brócolis");
INSERT INTO ingrediente VALUES("Alho");
INSERT INTO ingrediente VALUES("Muçarela de búfula");
INSERT INTO ingrediente VALUES("Camarão");
INSERT INTO ingrediente VALUES("Carne seca");
INSERT INTO ingrediente VALUES("Gorgonzola");
INSERT INTO ingrediente VALUES("Manjericão");
INSERT INTO ingrediente VALUES("Escarola");
INSERT INTO ingrediente VALUES("Milho");

-- Bebida

INSERT INTO pizza(nome, preco, tamanho) VALUES("Calabresa", 35.00, "Pequena");
INSERT INTO ingrediente_pizza VALUES (1, "Milho");

INSERT INTO bebida(nome, preco, quantidade) VALUES("Coca-Cola 2L", 10, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Fanta 2L", 9, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Coca Lata 350ML", 4, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Fanta 600ML", 6, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Funada 2L", 7, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Guaraná 1L", 6, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Sprite 2L", 9, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Sprite 600ML", 6, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Suco de uva", 6, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Suco de Laranja", 6, 999);
INSERT INTO bebida(nome, preco, quantidade) VALUES("Suco de Morango c/ Leite", 8, 999);

-- Usuário

INSERT INTO usuario VALUES(1, "Felipe Neves", "2022-02-01", "@.", "1", "Gerente", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "(18) 98171-2939");
INSERT INTO usuario VALUES(2, "Paulo Bolha", "2022-02-01", "@..", "1", "Gerente", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "(18) 98171-2939");

-- Cliente

INSERT INTO cliente VALUES(1, "Felipe Henrique", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(2, "Julia Trindade", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(3, "Gabriela Oliveira", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(4, "Flavia Mendes", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(5, "Rodrigo Fernandes", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(6, "Marcelo Boas", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(7, "Mariane Neves", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(8, "Carlos Pereira", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(9, "Vitória Amaral", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);
INSERT INTO cliente VALUES(10, "Rubia Vieira", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939", 0);

-- Entregador

INSERT INTO entregador VALUES(1, "Ronaldo Mendes", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939");
INSERT INTO entregador VALUES(2, "Gabriel Fernandes", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939");
INSERT INTO entregador VALUES(3, "Marcela Boas", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939");
INSERT INTO entregador VALUES(4, "Fernanda Neves", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939");
INSERT INTO entregador VALUES(5, "Jéssica Pereira", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939");
INSERT INTO entregador VALUES(6, "Pedro Amaral", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939");
INSERT INTO entregador VALUES(7, "Luiz Vieira", "Rua Horita Massafume 1730", "Presidente Epitácio", "SP", "471.331.234-30", "@.", "(18) 98171-2939");

DELIMITER $$
 CREATE PROCEDURE sumBloodletting(IN dia DATE, OUT t DOUBLE)
       BEGIN
         SELECT SUM(valor) INTO t FROM movimentacao
			WHERE caixa = (SELECT codigo FROM caixa WHERE DATE(data_abertura) = dia) AND tipo = 0; 
       END $$
DELIMITER ;

DELIMITER $$
 CREATE PROCEDURE sumSupplementation(IN dia DATE, OUT t DOUBLE)
       BEGIN
         SELECT SUM(valor) INTO t FROM movimentacao
			WHERE caixa = (SELECT codigo FROM caixa WHERE DATE(data_abertura) = dia) AND tipo = 1;
       END $$
DELIMITER ;

DELIMITER $$
 CREATE PROCEDURE countSell(IN dia DATE, OUT t INT)
       BEGIN
         SELECT COUNT(*) INTO t FROM venda
			WHERE DATE(data) = dia AND status = 'Finalizada'; 
       END $$
DELIMITER ;

DELIMITER $$
 CREATE PROCEDURE countBuy(IN dia DATE, OUT t INT)
       BEGIN
          SELECT count(*) INTO t FROM compra
					WHERE data_pagamento = dia; 
       END $$
DELIMITER ;

DELIMITER $$
 CREATE PROCEDURE sumBuyByDate(IN dia DATE, OUT t DOUBLE)
       BEGIN
         SELECT SUM(total) INTO t FROM compra
			WHERE data_pagamento = dia; 
       END $$
DELIMITER ;

DELIMITER $$
 CREATE PROCEDURE sumExpenseByDate(IN dia DATE, OUT t DOUBLE)
       BEGIN
         SELECT SUM(d.valor) INTO t FROM despesa d
         JOIN pagamento_despesa pd ON (pd.despesa = d.codigo)
         WHERE data_pagamento = dia; 
       END $$
DELIMITER ;

DELIMITER $$
 CREATE PROCEDURE sumPaymentDelivery(IN dia DATE, OUT t DOUBLE)
       BEGIN
         SELECT SUM(p.valor) INTO t FROM pagamento_entregador p
         WHERE p.data = dia; 
       END $$
DELIMITER ;

DELIMITER $$
 CREATE PROCEDURE sumSellByDate(IN dia DATE, OUT t DOUBLE)
       BEGIN
         SELECT SUM(total) INTO t FROM venda
			WHERE DATE(data) = dia AND status = 'Finalizada'; 
       END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER decreaseStock AFTER INSERT ON bebida_venda
  FOR EACH ROW
  BEGIN
	DECLARE qtd_bebida INT;
				SELECT quantidade INTO qtd_bebida FROM bebida WHERE codigo = new.bebida;
                UPDATE bebida SET quantidade = qtd_bebida - new.quantidade WHERE codigo = new.bebida;            
  END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER decreaseStock_after_remove AFTER DELETE ON bebida_venda
  FOR EACH ROW
  BEGIN
	DECLARE qtd_bebida INT;
				SELECT quantidade INTO qtd_bebida FROM bebida WHERE codigo = old.bebida;
                UPDATE bebida SET quantidade = qtd_bebida + old.quantidade WHERE codigo = old.bebida;            
  END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER increaseStock AFTER INSERT ON bebida_compra
  FOR EACH ROW
  BEGIN
	DECLARE qtd_bebida INT;
				SELECT quantidade INTO qtd_bebida FROM bebida WHERE codigo = new.bebida;
                UPDATE bebida SET quantidade = qtd_bebida + new.quantidade WHERE codigo = new.bebida;            
  END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER removeVenda BEFORE DELETE ON venda
  FOR EACH ROW
  BEGIN
		DELETE FROM pizza_venda WHERE venda = old.codigo;
		DELETE FROM bebida_venda WHERE venda = old.codigo;
  END $$
DELIMITER ;

CREATE OR REPLACE VIEW pagarEntregador AS
	SELECT
		e.codigo AS codigo,
        e.nome AS nome,
        e.cpf AS cpf,
        sum(en.taxa) AS taxa
	FROM entrega en
    JOIN entregador e ON (en.entregador = e.codigo)
    JOIN venda v ON (v.codigo = en.venda)
    JOIN Caixa c ON (v.caixa = c.codigo)
    WHERE c.data_abertura = current_date()
    AND(
		SELECT COUNT(*) FROM pagamento_entregador p
        WHERE p.data = current_date() 
        AND p.entregador = e.codigo
    ) = 0
    GROUP BY e.nome;
  

    







