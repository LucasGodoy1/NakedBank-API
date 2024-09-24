Sistema de Gerenciamento de Clientes e Contas Bancárias

Este repositório contém a implementação de uma aplicação de gerenciamento de clientes, contas bancárias e transações financeiras. O sistema foi construído utilizando Java, Spring Boot, e JPA para mapear as entidades e suas relações com um banco de dados MySQL. Além disso, inclui um diagrama da modelagem de dados que facilita a compreensão das relações entre as entidades do sistema.

Funcionalidades Principais:

    Gerenciamento de Usuários: Cada usuário possui um CPF, email, senha e data de criação. As senhas são criptografadas utilizando um algoritmo de hashing para garantir     segurança nos dados dos usuários.
    Cadastro de Clientes: O cliente pode ser vinculado a um usuário já existente, e armazena informações pessoais como nome, nacionalidade e telefone.
    Endereços de Clientes: Cada cliente possui um endereço único com campos como rua, número, CEP, e estado.
    Contas Bancárias: Clientes podem ter contas bancárias com informações como número da conta, agência, saldo e tipo de conta (corrente ou poupança).
    Extratos de Transações: As transações feitas em uma conta são armazenadas com o valor, data e nome da transação.
    Transferências Bancárias: O sistema permite realizar transferências de valores entre contas de clientes diferentes, mantendo o histórico de transações no extrato de     cada conta.

Modelagem do Banco de Dados







<img align="center" alt="modelagem-db" height="300" width="550" src="https://i.ibb.co/Q6nVPpg/versao-final.png">

descrição das tabelas e suas relações, conforme ilustrado no diagrama do banco de dados:

    tb_usuario: Armazena as informações de login dos usuários, com senhas criptografadas.
    tb_cliente: Cada cliente tem informações pessoais e está relacionado a um usuário e a um endereço.
    tb_endereco: Armazena os dados de endereço de um cliente.
    tb_conta: Cada conta pertence a um cliente, e armazena o tipo de conta, saldo e número da agência. Contas são usadas para realizar transações e transferências.
    tb_extrato: Guarda o histórico de transações vinculadas a uma conta, incluindo transferências entre contas.

Tecnologias Utilizadas

    Java 17: Linguagem de programação principal.
    Spring Boot: Framework para construção da aplicação, facilitando a configuração e o desenvolvimento.
    JPA/Hibernate: Abstração ORM para o mapeamento do banco de dados relacional em entidades Java.
    MySQL: Banco de dados utilizado para armazenar as informações do sistema.
    Lombok: Biblioteca para reduzir o código boilerplate com anotações de getters, setters, construtores, etc.
    BCrypt: Utilizado para criptografar e proteger as senhas dos usuários.
    DBML: Utilizado para modelagem e diagramação do banco de dados.
