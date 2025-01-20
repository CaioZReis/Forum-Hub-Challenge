# Forum-Hub ONE
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

Bem-vindo ao projeto **Forum-HubONE**! Este projeto tem como objetivo superar um desafio(Challenge) dado aos alunos do Projeto ONE.
Utilizando o método stateless para efetuar operações básicas CRUD em tópicos de um forum.

## Índice

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Usar](#como-usar)

## Visão Geral

O Forum-HubONE se propõe a ser um tópico web com método stateless para criação, listagem, atualização e exlusão de tópicos com titulo, mensagem/pergunta, autor, curso, além de outras informações como data de criação e status para saber quando foi criado e se está ativo.

## Funcionalidades

- **Login(Método POST):** Utilizando a URL http://localhost:8080/login é possível gerar um Token que deverá ser usado para mandar qualquer requisição posterior, pois sem ela todo acesso será barrado.
- **Criação de tópico(Método POST):** Nesta funcionalidade é necessário inserir titulo, mensagem, autor e curso do tópico para que seja criado nenhuma destas informações podem estar em branco.
- **Listar tópicos criados(Método GET):** Retorna em formato Json todos os tópico salvos ordenado por data de criação e paginados de forma que apareçam 10 tópicos por página.
- **Listar tópico por ID(Método GET):** Inserindo a URL com o ID do tópico http://localhost:8080/topico/{ID} retorna em formato Json somente o tópico requisitado.
- **Atualizar de tópico por ID(Método PUT):** Inserindo a URL com o ID do tópico http://localhost:8080/topico/{ID} é possível atualizar os dados titulo, mensagem, autor e curso do tópico em questão se titulo e mensagem forem diferentes de algum tópico já existente.
- **Deletar tópico por ID(Método DELETE):** Inserindo a URL com o ID do tópico http://localhost:8080/topico/{ID} é possível deletar o tópico com o ID pesquisado.

## Tecnologias Utilizadas
<div align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

</div>

- **Java 21:** Linguagem utilizada.
- **Spring:** Framework.
- **MySQL:** Banco de dados relacional.

## Como Usar

1. Primeiramente é necessário iniciar o projeto uma vez para criação das tabelas tópicos e usuarios no banco de dados mysql e então crie uma hash da sua senha na URL https://bcrypt-generator.com e então insira dentro da tabela usuarios o login e a hash para senha criada.
2. Será necessário usar alguma ferramente como: Postman ou Insomnia, para fazer requisições CRUD via URL.
3. Depois de ter iniciado o projeto e estar utilizando a ferramenta necessária, precisa inserir a URL http://localhost:8080/login para gerar um Token passando login e senha(que já devem estar no banco de dados) no formato Json que será utilizado em todas as próximas funcionalidades.
4. Com o Token gerado, copie ele pois será necessário também inserir na aba **Authorization** no cabeçalho da requisição para que seja liberado o acesso e todas as requisições deveram levar este Token junto para serem aceitas.
5. Em seguida as Requisições: POST, GET, PUT, DELETE, estarão aptas a serem utilizadas para, insetir, mostrar, atualizar e deletar tópicos do banco de dados MySQL da máquina
