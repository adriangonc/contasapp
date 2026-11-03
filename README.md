# 💰 Contas App

Aplicação web para gerenciamento de contas e pagamentos, desenvolvida com Java e Spring Boot.

---

## 📋 Sobre o Projeto

O **ContasApp** é um sistema de controle financeiro pessoal que permite cadastrar contas (*bills*) e registrar pagamentos (*payments*), com visualização detalhada de cada transação.

---

## 🚀 Tecnologias Utilizadas

### Backend

| Tecnologia | Versão | Descrição |
|---|---|---|
| **Java** | 1.8 | Linguagem principal do projeto |
| **Spring Boot** | 1.5.21 | Framework principal para criação da aplicação |
| **Spring MVC** | — | Camada web e controle de rotas (controllers) |
| **Spring Data JPA** | — | Abstração para acesso a dados e repositórios |
| **Spring DevTools** | — | Recarregamento automático em desenvolvimento |
| **Maven** | — | Gerenciador de dependências e build |

### Banco de Dados

| Tecnologia | Versão | Descrição |
|---|---|---|
| **MySQL** | 8.0.16 | Banco de dados relacional para produção |
| **PostgreSQL** | 42.2.1 | Banco de dados alternativo suportado |
| **H2 Database** | — | Banco de dados em memória para desenvolvimento/testes |
| **Apache Commons DBCP2** | 2.6.0 | Pool de conexões com o banco de dados |

### Frontend

| Tecnologia | Descrição |
|---|---|
| **Thymeleaf** | Template engine para renderização de páginas HTML no servidor |
| **Materialize CSS** | Framework CSS baseado no Material Design do Google |
| **HTML5** | Estrutura das páginas |
| **CSS3** | Estilização customizada |

---

## 🏗️ Arquitetura do Projeto

```
contasapp/
├── src/
│   ├── main/
│   │   ├── java/com/contasapp/
│   │   │   ├── ContasappApplication.java      # Classe principal (entry point)
│   │   │   ├── DataConfiguration.java          # Configuração de datasource (produção)
│   │   │   ├── DataConfigurationDev.java       # Configuração de datasource (desenvolvimento)
│   │   │   ├── DataConfigurationH2.java        # Configuração de datasource (H2/testes)
│   │   │   ├── controllers/
│   │   │   │   ├── IndexController.java        # Controller da página inicial
│   │   │   │   └── PaymentController.java      # Controller de pagamentos
│   │   │   ├── models/
│   │   │   │   ├── Bill.java                   # Entidade: Conta
│   │   │   │   └── Payment.java                # Entidade: Pagamento
│   │   │   └── repository/
│   │   │       ├── IBillRepository.java        # Repositório de contas
│   │   │       └── IPaymentRepository.java     # Repositório de pagamentos
│   │   └── resources/
│   │       ├── application.properties          # Configurações da aplicação
│   │       ├── static/
│   │       │   ├── materialize/                # Framework Materialize CSS
│   │       │   └── style/style.css             # Estilos customizados
│   │       └── templates/
│   │           ├── index.html                  # Página inicial
│   │           ├── validationMessenge.html     # Página de validação
│   │           └── payment/
│   │               ├── formPayment.html        # Formulário de pagamento
│   │               ├── listPayments.html       # Listagem de pagamentos
│   │               └── paymentDetail.html      # Detalhe do pagamento
│   └── test/
│       └── java/com/contasapp/
│           └── ContasappApplicationTests.java  # Testes da aplicação
├── pom.xml                                     # Configuração Maven
└── mvnw / mvnw.cmd                             # Maven Wrapper
```

---

## ⚙️ Como Executar

### Pré-requisitos

- Java 8+
- Maven 3.x (ou use o Maven Wrapper incluído)
- MySQL ou PostgreSQL (para produção), ou use H2 para testes

### Rodando com H2 (sem banco externo)

```bash
./mvnw spring-boot:run
```

### Rodando com MySQL

Configure o `application.properties` com suas credenciais:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/contasapp
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

Em seguida:

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

---

## 🧪 Testes

```bash
./mvnw test
```

---

## 📦 Build

```bash
./mvnw clean package
java -jar target/contasapp-0.0.1-SNAPSHOT.jar
```
