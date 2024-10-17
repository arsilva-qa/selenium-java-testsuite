# Testes Web Automatizados em Java com Selenium

Este projeto é uma automação de testes utilizando Java e Selenium WebDriver. Ele foi desenvolvido para demonstrar habilidades em testes de software e automação de interface web utilizando o site [The Internet](https://the-internet.herokuapp.com/challenging_dom), seguindo as boas práticas de programação e estruturação de código. Foram aplicados os padrões Page Objects e Page Factory para estruturar o projeto e organizar o código.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **Selenium WebDriver**: Biblioteca para automação de navegadores.
- **WebDriverManager**: Biblioteca para gerenciar drivers do Selenium automaticamente.
- **TestNG**: Framework para execução de testes.
- **Maven**: Gerenciador de dependências e build.

## Estrutura do Projeto

/src/main/java </br>
├── /config </br>
│ └── DriverSetup.java # Gerencia o WebDriver </br>
├── /pages </br>
│ └── HomePage.java # Page Object da página </br>
├── /tests </br>
│ └──  ChallengingDomTests.java # Testes automatizados </br>

## Pré-requisitos

Antes de executar o projeto, você precisa ter os seguintes itens instalados:

-   **JDK 11+**: Para compilar e executar o código Java.
-   **IDE com suporte ao Java**: Para importar o projeto na IDE, você deve escolher a opção de importar um projeto Maven. A IDE irá buscar as dependências automaticamente com base no pom.xml.

## Testes Implementados

### 1. Interação com botões e elemento Canvas

-   **Clicar No Botão Azul Deve Alterar Answer**: Valida se a interação com o botão Azul exibido na página, altera o valor exibido no elemento canvas `Anwer`.
-   **Clicar No Botão VermelhoDeve Alterar Answer**: Valida se a interação com o botão Vermelho exibido na página, altera o valor exibido no elemento canvas `Anwer`.
-   **Clicar No Botão Verde Deve Alterar Answer**: Valida se a interação com o botão Verde exibido na página, altera o valor exibido no elemento canvas `Anwer`.

### 2. Interação com as opções Edit e Delete

-   **Clicar No Primeiro Botão Editar Da Tabela**: Valida comportamento da página ao clicar na opção `edit` do primeiro registro na tabela.
-   **Clicar No Primeiro Botão Deletar Da Tabela**: Valida comportamento da página ao clicar na opção `delete` do primeiro registro na tabela.
-   **Clicar Em Todas As Opções Editar Da Tabela**: Valida que todas as opções `edit` da tabela foram acionadas.
-   **Clicar Em Todas As Opções Deletar Da Tabela**: Valida que todas as opções `delete` da tabela foram acionadas.

----------

**Autor**: Angélica Rodrigues da Silva Gomes
