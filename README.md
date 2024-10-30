<h1 align="center" style="font-weight: bold;">Desafio Fase 1 - Rpg Character CRUD 💻(Back End)</h1>

<p align="center">
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
   <a href="#routes">API Endpoints</a> •

<p align="center">
    <b>O backend fornece uma API RESTful para gerenciar personagens de RPG, suportando operações de criação, leitura, atualização e exclusão (CRUD). Cada endpoint permite ao frontend ou a outras aplicações acessar e manipular dados de personagens, incluindo atributos como nome, classe, nível e experiência.</b>
    <b>Aplicação criada para um desafio de uma vaga.</b>
</p>

<p align="center">
     <a href="PROJECT__URL">📱 Visit this Project</a>
</p>

<h2 id="technologies">💻 Technologies</h2>

- Java
- Spring Boot
- JUnit
- Mockito
- Lombok
- PostgreSQL
- Docker
- Insomnia

<h2 id="started">🚀 Getting started</h2>

<h3>Prerequisites</h3>

Here you list all prerequisites necessary for running your project. For example:

- [Docker](https://www.docker.com/products/docker-desktop/)
- [Java](https://www.java.com/pt-BR/download/manual.jsp)

<h3>Cloning</h3>

Clone o Repositório

```bash
git clone https://github.com/seu_usuario/seu_repositorio.git
```

<h3>Starting</h3>

Como iniciar seu projeto.

```bash
cd project-name
```

Instale as Dependências: Certifique-se de que você tenha o Java e o Maven instalados. Execute o seguinte comando para instalar as dependências necessárias:
```bash
mvn install
```
Configure o Banco de Dados: Certifique-se de que o banco de dados esteja configurado corretamente. Você pode precisar ajustar as configurações no arquivo application.properties ou application.yml para conectar-se ao seu banco de dados.

Inicie o Servidor: Execute o seguinte comando para iniciar o servidor:
```bash
mvn spring-boot:run
```
Acesse a API: Após iniciar o servidor, você pode acessar a API no endereço http://localhost:8080 (ou a porta que você configurou). Use ferramentas como Postman ou Insomnia para testar os endpoints da API.

<h2 id="routes">📍 API Endpoints</h2>

​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /characters</kbd>     | Retorna a lista de todos os personagens.
| <kbd>POST /characters/</kbd>     | Cria um novo personagem; envie os dados no corpo da requisição.
| <kbd>GET /characters/{id}</kbd>     | Retorna os detalhes de um personagem específico.
| <kbd>PUT /characters/{id}</kbd>     | Atualiza as informações de um personagem específico.
| <kbd>DELETE /characters/{id}</kbd>     | Remove um personagem específico.

<h3>GET /characters</h3>

**RESPONSE**
```json
{
		"id": 1,
		"name": "Joao Teste",
		"level": 1,
		"exp": 0,
		"characterClass": "Mago"
}
```

<h3 id="post-auth-detail">POST /characters/</h3>

**REQUEST**
```json
{
	"name": "Joao",
	"characterClass": "Mago",
	"level": 1
}
```
