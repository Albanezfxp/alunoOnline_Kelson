# Documentação da API - Sistema de Alunos

**Disciplina:** BackEnd  
**Professor:** Kelson Victor  
**Aluno:** Gabriel Albanez  
**Data de Entrega:** 29/04/2025

---
📌 **Visão Geral**
API desenvolvida em Spring Boot para gerenciamento de alunos, professores e disciplinas com operações CRUD (Create, Read, Update, Delete).

---
🔧 **Tecnologias Utilizadas**
* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3.x
* **Banco de Dados:** PostgreSql
* **Ferramentas:**
    * Postman (para testes)
    * Maven/Gradle (gerenciamento de dependências)

---
📝 **Endpoints - Alunos**

**1. Listar Todos os Alunos (GET)**
* **Rota:** `http://localhost:8080/alunos`
* **Descrição:** Retorna todos os alunos cadastrados.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Listar Alunos](/src/assets/getAllAlunos.png)
* **Resposta de Sucesso (200 OK):**
    ```json
    [
        {
            "id": 8,
            "name": "Gabriel Albanez",
            "cpf": "709-530-704.09",
            "email": "gabrielalbanez27@gmail.com"
        }
    ]
    ```

---
**2. Buscar Aluno por ID (GET)**
* **Rota:** `http://localhost:8080/alunos/{id}`
* **Descrição:** Retorna um aluno específico com base no ID.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Buscar Aluno por ID](/src/assets/getAlunoById.png)
* **Resposta de Sucesso (200 OK):**
    ```json
    {
        "id": 8,
        "name": "Gabriel Albanez",
        "cpf": "709-530-704.09",
        "email": "gabrielalbanez27@gmail.com"
    }
    ```
* **Resposta de Erro (404 Not Found):**
    ```json
    Null
    ```

---
**3. Cadastrar Aluno (POST)**
* **Rota:** `/api/alunos`
* **Descrição:** Cria um novo aluno no sistema.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Cadastrar Aluno](/src/assets/createAluno.png)
* **Resposta de Sucesso (201 Created):**

---
**4. Deletar Aluno (DELETE)**
* **Rota:** `http://localhost:8080/alunos/{id}`
* **Descrição:** Remove um aluno com base no ID.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Deletar Aluno](/src/assets/deleteAluno.png)
* **Resposta de Sucesso (200 OK):**
    ```
    String: {
    Aluno Gabriel Albanez deleteado
    }
    ```
* **Resposta de Erro (404 Not Found):**
    ```
    String: {Aluno não encontrado
    ```

---
📝 **Endpoints - Professores**

**1. Listar Todos os Professores (GET)**
* **Rota:** `http://localhost:8080/professores`
* **Descrição:** Retorna todos os professores cadastrados.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Listar Professores](/src/assets/getAllProfessor.png)
* **Resposta de Sucesso (200 OK):**

---
**3. Cadastrar Professor (POST)**
* **Rota:** `http://localhost:8080/professores`
* **Descrição:** Cria um novo professor no sistema.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Cadastrar Professor](/src/assets/createProfessor.png)
* **Resposta de Sucesso (201 Created):**

---
**4. Update Professor (PUT)**
* **Rota:** `http://localhost:8080/professores/{id}`
* **Descrição:** Atualiza um professor com base no ID.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Update Professor](/src/assets/updateProfessor.png)
* **Resposta de Sucesso (200 OK):**

---
**4. Deletar Professor (DELETE)**
* **Rota:** `http://localhost:8080/professores/{id}`
* **Descrição:** Remove um professor com base no ID.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Deletar Professor](/src/assets/deleteProfessor.png)
* **Resposta de Sucesso (200 OK):**
    ```
    String: {
    Professor: Gabriel Albanez deletado. }
    ```
* **Resposta de Erro (404 Not Found):**
    ```
    String: {Professor não encontrado)
    ```

---
📝 **Endpoints - Disciplinas**

**1. Listar Todas as Disciplinas (GET)**
* **Rota:** `http://localhost:8080/disciplinas`
* **Descrição:** Retorna todas as disciplinas cadastradas.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Listar Disciplinas](/src/assets/getAllDiscipline.png)
* **Resposta de Sucesso (200 OK):**

---
**3. Cadastrar Disciplina (POST)**
* **Rota:** `http://localhost:8080/disciplinas`
* **Descrição:** Cria uma nova disciplina no sistema.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Cadastrar Disciplina](/src/assets/createDiscipline.png)
* **Resposta de Sucesso (201 Created):**

---
**4. Deletar Disciplina (DELETE)**
* **Rota:** `http://localhost:8080/disciplinas/{id}`
* **Descrição:** Remove uma disciplina com base no ID.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Deletar Disciplina](/src/assets/deleteDiscipline.png)
* **Resposta de Sucesso (200 OK):**
    ```
    String: {
    Disciplina: Matematica deletada. }
    ```
* **Resposta de Erro (404 Not Found):**
    ```
    String: {Disciplina não encontrado)
    ```

---
**4. Update Disciplina (PUT)**
* **Rota:** `http://localhost:8080/disciplinas/{id}`
* **Descrição:** Atualiza uma disciplina com base no ID.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Update Disciplina](/src/assets/updateDiscipline.png)
* **Resposta de Sucesso (200 OK):**

---
**5. Listar todas as disciplinas do professor (GET)**
* **Rota:** `http://localhost:8080/disciplinas/professor/{id}`
* **Descrição:** Lista todas as disciplinas do professor com base no ID do professor.
* **Exemplo de Requisição (Postman):**
    * ![Exemplo de Requisição Listar Disciplinas Professor](/src/assets/getAllDisciplineByProfessorID.png)
* **Resposta de Sucesso (200 OK):**

---
**Swagger**
* **Imagens:**
  * ![Swagger_1](/src/assets/swagger1.png)
  * ![Swagger_2](/src/assets/swagger2.png)
---
**Dbveaver**
* **Imagens:**
* ![Professor_Dbeaver](/src/assets/professorDbeaver.png)
* ![Aluno_Dbeaver](/src/assets/alunoDbeaver.png)
* ![Discipline_Dbeaver](/src/assets/disciplineDbeaver.png)
---
✅ Documentação gerada por: Gabriel Albanez  
📅 Última atualização: 27/05/2025