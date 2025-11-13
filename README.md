# 🧩 Sistema de Gerenciamento de Funcionários – Spring Boot + JPA + H2

## 📘 Descrição do Projeto
Este projeto é um **sistema simples de gerenciamento de funcionários**, desenvolvido em **Java com Spring Boot**.  
O objetivo é demonstrar o uso de operações **CRUD (Create, Read, Update e Delete)** utilizando **Spring Data JPA** e banco de dados **H2 em memória**.

O sistema permite cadastrar, listar, atualizar e excluir funcionários de forma simples via **requisições HTTP REST**.

---

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **H2 Database (em memória)**
- **Gradle**
- **Lombok** *(opcional, se configurado)*
- **Tomcat Embutido**

---

## ⚙️ Instruções de Execução

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/igorgustavo31/funcionarios-spring-jpa.git
   ```

2. **Acessar o diretório do projeto:**
   ```bash
   cd funcionarios-spring-jpa
   ```

3. **Executar o projeto (via Gradle):**
   ```bash
   ./gradlew bootRun
   ```
   Ou no Windows:
   ```bash
   gradlew.bat bootRun
   ```

4. **Acessar a aplicação:**
   ```
   http://localhost:8080
   ```

5. **Acessar o console do banco H2:**
   ```
   http://localhost:8080/h2-console
   ```
   - **JDBC URL:** `jdbc:h2:mem:funcionariosdb`  
   - **Usuário:** `sa`  
   - **Senha:** *(deixe em branco)*

---

## 🧱 Estrutura do Projeto

```
funcionarios/
├── src/
│   ├── main/java/com/example/funcionarios/
│   │   ├── controller/
│   │   │   └── FuncionarioController.java
│   │   ├── model/
│   │   │   └── Funcionario.java
│   │   ├── repository/
│   │   │   └── FuncionarioRepository.java
│   │   └── FuncionariosApplication.java
│   └── resources/
│       ├── application.properties
│       └── static / templates (se houver)
├── build.gradle
└── README.md
```

---

## 🧩 Exemplo de Requisições HTTP (JSON)

### ➕ Criar Funcionário
**POST** `/funcionarios`
```json
{
  "nome": "Igor Almeida",
  "cargo": "Analista de Sistemas",
  "salario": 5200.00
}
```

### 📄 Listar Todos os Funcionários
**GET** `/funcionarios`

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Igor Almeida",
    "cargo": "Analista de Sistemas",
    "salario": 5200.0
  }
]
```

### ✏️ Atualizar Funcionário
**PUT** `/funcionarios/1`
```json
{
  "nome": "Igor Almeida",
  "cargo": "Desenvolvedor Java",
  "salario": 5800.00
}
```

### ❌ Deletar Funcionário
**DELETE** `/funcionarios/1`

---

## 🧠 Observações
- O banco **H2 é temporário** — os dados são apagados quando a aplicação é encerrada.  
- O projeto pode ser facilmente adaptado para **MySQL, PostgreSQL** ou outro banco relacional alterando o `application.properties`.

---

## 🚀 Autor
👤 **Igor Gustavo**  
📍 [github.com/igorgustavo31](https://github.com/igorgustavo31)  
💻 Projeto desenvolvido para fins de estudo em **Spring Boot + JPA + H2**
