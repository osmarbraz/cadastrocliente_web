[![Github Actions Status for osmarbraz/cadastrocliente_web](https://github.com/osmarbraz/cadastrocliente_web/workflows/Integra%C3%A7%C3%A3o%20continua%20de%20Java%20com%20Maven/badge.svg)](https://github.com/osmarbraz/cadastrocliente_web/actions) 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=osmarbraz_cadastrocliente_web&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=osmarbraz_cadastrocliente_web)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=osmarbraz_cadastrocliente_web&metric=coverage)](https://sonarcloud.io/component_measures?id=osmarbraz_cadastrocliente_web&metric=coverage)

# Sistema de Cadastro de Clientes para WEB em Banco de Dados em 3 camadas utilizando o padrão Abstract Factory.
 - O projeto foi desenvolvido no NetBeans deve ser chamado cadastrocliente_web.<br>
 - Utiliza o Apache Maven para a automatização da construção.<br>
 - O projeto é um CRUD para os dados de cliente(clienteId, Nome, CPF).
 - As classes do projeto está organizado nos pacotes visão, controle, modelo, dao além de um pacote util.<br>
 - Utiliza o padrão abstract factory para abstrair 3 formas de armazenamento:
	- 1 - Banco de Dados(SQLLite)
	- 2 - HashMap
	- 3 - Arquivo Binário
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - A aplicação esta configurada para utilizar inicialmente memória principal(Hashmap) para armazenamento.
 - Se desejar utilizar outra fonte de dados, edite o arquivo src\dao\Factory.java alterando a FABRICA para outro valor.
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - Os dados de configuração (Servidor, Database, Usuario, Senha) da integração do java com o banco de dados estão no arquivo src/dao/SQLiteDadosBanco.java.<br>
 - A especificação da fábrica a ser utilizada é feita na interface Factory.java. 
 - A pasta test contêm os testes unitários do projeto utilizando JUnit 4.<br> 
 - Os testes são realizados no SO ubuntu-lastest e JDK 16, 17 e 18.<br>
 - A cobertura do código é realizada através do JaCoCo e relatório enviado para o Sonarcloud.<br>
