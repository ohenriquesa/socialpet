# SocialPet

## Autores
* Henrique de Sá
* Wesley Luan

## Descrição
SocialPet é um projeto acadêmico que consiste em uma API para uma rede social voltada para tutores de pets. A ideia principal é que cada pet tenha um perfil público, que pode ser acessado através de um QR code na coleira. Caso o animal se perca, a pessoa que o encontrar pode escanear o código para visualizar informações do pet e entrar em contato com o tutor.

O sistema permite o cadastro completo de donos, seus pets e as vacinas aplicadas, facilitando o gerenciamento e a rápida consulta de informações importantes sobre os animais de estimação.

## Tecnologias Utilizadas
* **Java:** Versão 17
* **Spring Boot:** Versão 3.5.0
    * Spring Web: Para criação de APIs RESTful.
    * Spring Data JPA: Para persistência de dados.
    * Spring Boot DevTools: Para facilitar o desenvolvimento.
* **Maven:** Para gerenciamento de dependências e build do projeto.
* **MySQL:** Banco de dados relacional para armazenamento dos dados.
* **Hibernate:** Implementação JPA utilizada (via Spring Data JPA).
* **Lombok:** Para reduzir código boilerplate (getters, setters, construtores).
* **Jakarta Persistence API:** Especificação para persistência.

## Modelo de Dados
O sistema é composto pelas seguintes entidades principais:

* **Dono:** Representa o tutor do pet.
    * Atributos: `id`, `nome`, `telefone`, `endereco`.
    * Relacionamentos: Um dono pode ter vários pets (`@OneToMany`).
* **Pet:** Representa o animal de estimação.
    * Atributos: `id`, `nome`, `especie`, `raca`, `idade`, `restricaoAlimentar`.
    * Relacionamentos:
        * Um pet pertence a um dono (`@ManyToOne`).
        * Um pet pode ter recebido várias vacinas (`@ManyToMany`).
* **Vacina:** Representa uma vacina que pode ser aplicada aos pets.
    * Atributos: `id`, `nome`, `fabricante`.
    * Relacionamentos: Uma vacina pode ser aplicada a vários pets (`@ManyToMany`).

## Funcionalidades (Endpoints da API)

O projeto expõe os seguintes endpoints RESTful:

### Dono (`/donos`)
* `GET /donos`: Lista todos os donos cadastrados.
* `GET /donos/{id}`: Busca um dono específico pelo seu ID.
* `POST /donos`: Cria um novo dono. Requer um objeto `Dono` no corpo da requisição.
* `PUT /donos/{id}`: Atualiza os dados de um dono existente. Requer um objeto `Dono` no corpo da requisição.
* `DELETE /donos/{id}`: Remove um dono do sistema.

### Pet (`/pets`)
* `GET /pets`: Lista todos os pets cadastrados (retorna uma lista de `PetDTO` com `id`, `nome` e `especie`).
* `GET /pets/{id}`: Busca um pet específico pelo seu ID.
* `POST /pets`: Cria um novo pet. Requer um objeto `Pet` no corpo da requisição.
* `PUT /pets/{id}`: Atualiza os dados de um pet existente. Requer um objeto `Pet` no corpo da requisição.
* `DELETE /pets/{id}`: Remove um pet do sistema.
* `POST /pets/{petid}/vacinas/{vacinaid}`: Associa uma vacina existente a um pet existente, registrando a vacinação.

### Vacina (`/vacinas`)
* `GET /vacinas`: Lista todas as vacinas cadastradas.
* `GET /vacinas/{id}`: Busca uma vacina específica pelo seu ID.
* `POST /vacinas`: Cria uma nova vacina. Requer um objeto `Vacina` no corpo da requisição.
* `PUT /vacinas/{id}`: Atualiza os dados de uma vacina existente. Requer um objeto `Vacina` no corpo da requisição.
* `DELETE /vacinas/{id}`: Remove uma vacina do sistema.

## Configuração do Banco de Dados
O projeto está configurado para utilizar um banco de dados MySQL. As configurações de conexão podem ser encontradas no arquivo `src/main/resources/application.properties`:

* **URL:** `jdbc:mysql://localhost:3306/socialpet`
* **Username:** `root`
* **Password:** `root`
* **DDL Auto:** `spring.jpa.hibernate.ddl-auto=create` - Isso significa que o Hibernate irá criar/recriar as tabelas do banco de dados automaticamente ao iniciar a aplicação. **Atenção:** Isso apaga dados existentes. Mude para `update` ou `validate` em um ambiente de produção ou se desejar manter os dados.
* **Show SQL:** `spring.jpa.show-sql=true` - Exibe as queries SQL geradas pelo Hibernate no console.

Certifique-se de ter um servidor MySQL em execução e que o banco de dados `socialpet` exista, ou que o usuário configurado tenha permissão para criá-lo.

## Inicialização de Dados
Ao iniciar a aplicação, a classe `DataInitializer` é executada para popular o banco de dados com alguns dados de exemplo:
* Um Dono: "João Silva".
* Duas Vacinas: "Antirrábica" e "V10".
* Um Pet: "Max" (Labrador), pertencente a "João Silva" e vacinado com "Antirrábica" e "V10".

Isso é útil para testes e demonstração inicial da aplicação.

## Como Executar o Projeto

### Pré-requisitos
* JDK 17 ou superior instalado.
* Maven instalado.
* Servidor MySQL em execução.

### Passos
1.  **Clone o repositório:**
    ```bash
    git clone <https://github.com/ohenriquesa/socialpet>
    cd socialpet
    ```
2.  **Configure o Banco de Dados:**
    * Crie um banco de dados no MySQL chamado `socialpet`.
    * Verifique e, se necessário, ajuste as credenciais do banco de dados no arquivo `src/main/resources/application.properties`.

3.  **Execute a aplicação usando Maven:**
    ```bash
    mvn spring-boot:run
    ```
    Isso iniciará a aplicação Spring Boot.

4.  **Alternativamente, execute pela sua IDE:**
    * Importe o projeto como um projeto Maven na sua IDE (IntelliJ IDEA, Eclipse, VSCode).
    * Encontre a classe `SocialpetApplication.java` e execute o método `main`.

A aplicação estará disponível, por padrão, em `http://localhost:8080`.

## Estrutura do Projeto (Simplificada)

```text
socialpet/
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties        # Configuração do Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/socialpet/
│   │   │       ├── SocialpetApplication.java    # Classe principal da aplicação
│   │   │       ├── DataInitializer.java         # Classe para popular dados iniciais
│   │   │       ├── controller/                  # Controladores REST (Dono, Pet, Vacina)
│   │   │       ├── dto/                         # Data Transfer Objects (DonoDTO, PetDTO, etc.)
│   │   │       ├── model/                       # Entidades JPA (Dono, Pet, Vacina)
│   │   │       ├── repository/                  # Repositórios Spring Data JPA
│   │   │       └── service/                     # Camada de serviço/lógica de negócio
│   │   └── resources/
│   │       └── application.properties           # Configurações da aplicação
│   └── test/
│       └── java/
│           └── com/socialpet/
│               └── SocialpetApplicationTests.java # Testes da aplicação
├── pom.xml         # Arquivo de configuração do Maven
└── README.md       # Este arquivo
