# 💳 Itaú Unibanco - Desafio de Programação

Este repositório contém a solução para o desafio de programação proposto pelo Itaú Unibanco, que consiste em construir uma API RESTful para o gerenciamento de **transações financeiras** e o cálculo de **estatísticas** baseadas nessas transações.

---

## 📋 Descrição do Desafio

Desenvolver uma **API REST** que:

- Recebe transações financeiras
- Calcula estatísticas sobre as transações dos **últimos 60 segundos**
- Permite limpar todas as transações salvas

A aplicação foi construída com **Java** e **Spring Boot**, com armazenamento **em memória** e sem uso de banco de dados.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- JUnit 5
- Maven

---

## 🧠 Regras de Negócio

### ✅ POST `/transacao`

Recebe uma transação no seguinte formato:

```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

#### Validações:

- `valor` deve ser **maior ou igual a 0**
- `dataHora` deve estar no **passado**
- Campos obrigatórios: `valor`, `dataHora`

#### Respostas:

- `201 Created` — Transação aceita
- `422 Unprocessable Entity` — Transação inválida (ex: valor negativo ou data no futuro)
- `400 Bad Request` — JSON inválido

---

### 🧹 DELETE `/transacao`

Remove todas as transações da memória.

#### Resposta:

- `200 OK` — Transações removidas com sucesso

---

### 📊 GET `/estatistica`

Retorna estatísticas das transações dos **últimos 60 segundos**:

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

#### Observações:

- Quando **não houver transações**, todos os campos retornam `0`.

#### Resposta:

- `200 OK` — Estatísticas calculadas com sucesso

---

## 🧪 Testes

A aplicação contém testes automatizados que cobrem:

- Regras de negócio
- Comportamento esperado dos endpoints
- Validações de entrada

### Executar os testes:

```bash
./mvnw test
```

---

## ⚙️ Como Executar Localmente

### 1. Clonar o repositório

```bash
git clone https://github.com/seuusuario/nome-do-repositorio.git
cd nome-do-repositorio
```

### 2. Rodar a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
📍 `http://localhost:8080`

---

## 🧩 Extras Implementados (caso tenha feito)

- ✅ Cobertura de testes com JUnit

---

## 📬 Contato

Caso queira entrar em contato para feedbacks ou dúvidas:

- ✉️ seu.email@exemplo.com
- 💼 [LinkedIn](https://www.linkedin.com/in/guilherme-ribeiro-1a5705235/)
- 🐙 [GitHub](https://github.com/Guilherm12122)

---

## 🏁 Considerações Finais

Este projeto foi desenvolvido com foco em **boas práticas de desenvolvimento**, **organização de código** e **testabilidade**.  
Todas as regras do desafio foram seguidas rigorosamente, com especial atenção aos detalhes dos endpoints e suas validações.

Obrigado por conferir! 🚀
