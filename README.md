# Cadastro-Colaboradores
Esse sistema foi criado para facilitar o cadastro de colaboradores da empresa em que trabalho, com ele, só preciso solicitar os dados uma unica vez ao invés de ficar perguntando a cada dois e dois meses!


-----

# 📝 Cadastro de Colaboradores

## 💻 Sobre o Projeto

Este é um sistema completo de gerenciamento de colaboradores, desenvolvido para facilitar o cadastro, edição, visualização e exclusão (CRUD) de funcionários. A aplicação conta com uma camada de segurança robusta para controlar o acesso às funcionalidades.

## 🛠 Tecnologias Utilizadas

* **Back-end:** Java com Spring Boot.
* **Front-end:** Thymeleaf (engine de template) e Bootstrap 5 (estilização).
* **Segurança:** Spring Security (Autenticação e Autorização).
* **Banco de Dados:** Spring Data JPA (compatível com H2, MySQL, PostgreSQL, etc).

## 🔑 Funcionalidades Principais

* **CRUD Completo:** Cadastro, Listagem, Edição e Exclusão de colaboradores.
* **Segurança:** Tela de login customizada e proteção de rotas.
* **Interface Responsiva:** Visual moderno e adaptável a dispositivos móveis através do Bootstrap.
* **Validação de Dados:** Garantia de que os dados inseridos estão no formato correto.

## 🚀 Como executar o projeto

### Pré-requisitos

* Java 17 ou superior.
* Maven instalado (ou usar o `mvnw` incluso).

### Passo a passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/CyroLuis/Cadastro-Colaboradores.git
    ```
2.  **Entre na pasta do projeto:**
    ```bash
    cd Cadastro-Colaboradores
    ```
3.  **Execute a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```
4.  **Acesse no navegador:**
    Abra `http://localhost:8080`

## 📂 Estrutura de Pastas

* `src/main/java`: Contém a lógica de negócio (Controllers, Models, Repositories, Services e Configurações de Segurança).
* `src/main/resources/templates`: Páginas HTML construídas com Thymeleaf.
* `src/main/resources/static`: Arquivos CSS, JS e imagens.


-----

✨ *Desenvolvido por [Cyro Luis](https://www.google.com/search?q=https://github.com/CyroLuis)*
