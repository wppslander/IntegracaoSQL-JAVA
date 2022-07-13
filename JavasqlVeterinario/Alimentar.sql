INSERT INTO `dono` (`ID`, `Nome`, `Telefone`, `Endereco`) VALUES 
	('1', 'Daniel Wppslander', '47 999 111 555', 'AV Brasil, 000, ap 01'),
	('2', 'Khard', '88 999 222 111', '370, Itapema'), 
	('3', 'Danielle Martins', '66 777 888 999', 'Rua 3700 ap 404, Bairro Not Found');
	
INSERT INTO `animal` (`ID`, `ID_Dono`, `Nome`,`Especie`, `Raca`,`genero` ) VALUES 
	(1, 1, 'Yoda', 'Passaro', 'Calopsita', 'M'), 
	(2, 1, 'Leia', 'Passaro', 'Calopsita', 'F'), 
	(3, 1, 'Ana', 'Passaro', 'Calopsita', 'F'),
	(4, 2, 'Valkiria', 'Cavalo', 'Arabe', 'F'),
	(5, 2, 'Thor', 'Cavalo', 'Arabe', 'M');
	
INSERT INTO `Os`(`ID`, `ID_Animal`, `DATA`, `Servico`, `Preco`, `Observacao`) VALUES 
	('1','1', '2022-06-17', 'Aplicação de antibiotico','100.00','3 aplicações, Passaro estava com uma asa infeccionada, provavelmente uma pena encravada.'),
	('2','4', '2022-01-01', 'Aplicação de antibiotico','400.00','Quantas necessarias, Casco da pata inferior esquerda infeccionada, o casco foi limpo e tradado.'),
	('3','4', '2022-04-01', 'Check Up','100.00','Valkiria esta gravida, marcado dia para realizar o acompanhamento do nascimento.');