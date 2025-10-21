# 🛍️ Sistema de Vendas - Microsserviços

## 📋 Sobre o Projeto

O **Sistema de Vendas** é uma aplicação baseada em arquitetura de microserviços desenvolvida durante
o curso **Especialista Java Back-end**, na Ebac e tem como finalidade, gerenciar operações de vendas, clientes 
e produtos de forma escalável e distribuída.
O projeto foi construído seguindo as melhores práticas de desenvolvimento de software,
utilizando tecnologias modernas do ecossistema Spring.

### 🎯 Principais Funcionalidades

- **Gestão de Clientes**: Cadastro, consulta, atualização e remoção de clientes
- **Gestão de Produtos**: Controle completo do catálogo de produtos
- **Gestão de Vendas**: Processamento e registro de vendas, integrando clientes e produtos
- **Configuração Centralizada**: Gerenciamento de configurações através do Spring Cloud Config Server
- **Comunicação entre Serviços**: Integração entre microserviços utilizando OpenFeign

### 🔍 Contexto de Uso

Este sistema é ideal para:
- Pequenas e médias empresas que precisam gerenciar vendas
- Projetos acadêmicos de arquitetura de microserviços
- Portfolio de desenvolvedores backend
- Base para sistemas de e-commerce

---

## 🏗️ Arquitetura do Projeto

O projeto foi desenvolvido utilizando uma **arquitetura de microserviços**,
onde cada serviço é independente e possui sua própria responsabilidade.
A comunicação entre os serviços é realizada através de APIs RESTful.

### 📦 Estrutura de Módulos

```
Vendas/ 
    ├── ClienteService/ # Microserviço responsável pela gestão de clientes 
    ├── ProdutoService/ # Microserviço responsável pela gestão de produtos 
    ├── VendasService/ # Microserviço responsável pelo processamento de vendas 
    └── ConfigServer/ # Servidor de configuração centralizada
```

### 🎨 Padrões Arquiteturais Utilizados

#### **Microserviços**
Cada serviço é uma aplicação independente com:
- Base de dados própria (MongoDB)
- Endpoint REST específico
- Domínio de negócio bem definido

#### **Camadas da Aplicação** (por microserviço)

* Controller (API REST)
* Service (Lógica de Negócio) 
* Repository (Acesso a Dados) 
* MongoDB (Banco de Dados)

#### **Padrões Implementados**
- **API Gateway Pattern**: Ponto único de entrada (preparado para expansão)
- **Config Server Pattern**: Configuração centralizada
- **Service Discovery**: Preparado para integração com Eureka
- **Client-Side Load Balancing**: Através do OpenFeign
- **Repository Pattern**: Abstração do acesso a dados



## 🚀 Tecnologias e Ferramentas

### **Backend**

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **Java** | 25 | Linguagem de programação principal |
| **Spring Boot** | 3.5.6 | Framework para criação de aplicações Java |
| **Spring Cloud** | 2025.0.0 | Ferramentas para sistemas distribuídos |
| **Spring Cloud Config** | - | Gerenciamento centralizado de configurações |
| **Spring Data MongoDB** | - | Integração com MongoDB |
| **Spring MVC** | - | Framework web para APIs REST |
| **Spring Validation** | - | Validação de dados |
| **Spring Actuator** | - | Monitoramento e métricas da aplicação |

### **Comunicação entre Serviços**

| Tecnologia | Descrição |
|------------|-----------|
| **OpenFeign** | Cliente HTTP declarativo para comunicação entre microserviços |
| **REST API** | Protocolo de comunicação via HTTP/JSON |

### **Banco de Dados**

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **MongoDB** | - | Banco de dados NoSQL orientado a documentos |
| **Spring Data MongoDB** | - | Abstração para acesso ao MongoDB |

### **Documentação**

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **SpringDoc OpenAPI** | 2.8.13 | Documentação automática da API (Swagger UI) |

### **Ferramentas de Desenvolvimento**

| Ferramenta | Descrição |
|------------|-----------|
| **Lombok** | Redução de código boilerplate (getters, setters, constructors) |
| **Maven** | Gerenciamento de dependências e build |
| **Spring DevTools** | Hot reload durante desenvolvimento |


### **Infraestrutura**

```
                ┌─────────────────┐
                │  Config Server  │ (Porta 8888)
                └────────┬────────┘
                         │
          ┌──────────────┼──────────────┐
          │              │              │
          ▼              ▼              ▼
    ┌──────────┐   ┌──────────┐   ┌──────────┐
    │ Cliente  │   │ Produto  │   │  Vendas  │
    │ Service  │   │ Service  │   │ Service  │
    │  (8081)  │   │  (8082)  │   │  (8083)  │
    └────┬─────┘   └────┬─────┘   └────┬─────┘
         │              │              │
         └──────────────┴──────────────┘
                        │
                  ┌─────▼─────┐
                  │  MongoDB  │
                  └───────────┘
```
### **Portas dos Serviços**

- **ConfigServer**: `8888`
- **ClienteService**: `8081`
- **ProdutoService**: `8082`
- **VendasService**: `8083`
- **MongoDB**: `27017`


## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado em sua máquina:

### **Obrigatórios**

- **Java Development Kit (JDK) 25** ou superior (A utilizada foi CorrettoJDK da Amazon)
  - [Download CorrettoJDK](https://docs.aws.amazon.com/corretto/latest/corretto-25-ug/downloads-list.html)
  - Verifique a instalação: `java -version`

- **Maven 3.6+**
  - [Download Maven](https://maven.apache.org/download.cgi)
  - Verifique a instalação: `mvn -version`

- **MongoDB 4.0+**
  - [Download MongoDB](https://www.mongodb.com/try/download/community)
  - Verifique a instalação: `mongod --version`

### **Recomendados**

- **IDE** (escolha uma):
  - IntelliJ IDEA (recomendado. Foi a tulizada no projeto)
  - Eclipse
  - VS Code com extensões Java

- **Postman** ou **Insomnia** para testar as APIs
- **MongoDB Compass** para visualizar os dados (opcional)
- **Git** para clonar o repositório

---

## 🚀 Como Rodar a Aplicação

### **1️⃣ Clonar o Repositório**
```bash
git clone https://github.com/seu-usuario/vendas.git cd vendas
```

### **2️⃣ Configurar o MongoDB**

#### **MongoDB com Docker**

``` 
docker compose up
```


### **3️⃣ Configurar o Config Server**
O Config Server deve ser o primeiro serviço a ser iniciado, pois os outros serviços dependem dele para obter suas configurações.

Certifique-se de que os seguintes arquivos estejam presentes em:
* ConfigServer/src/main/resources/config/:
    - cliente-config-service.yml
    - produto-config-service.yml
    - vendas-config-service.yml


### Estrutura das Configurações
```YAML
# Exemplo: cliente-config-service.yml
server:
  port: 8081

spring:
  data:
    mongodb:
      uri: mongodb://admin:superSecreta@localhost:27017/?authMechanism=SCRAM-SHA-256
      database: ClienteDB
      auto-index-creation: true
```

### **4️⃣ Iniciar os Serviços**
#### ⚠️ IMPORTANTE: Os serviços devem ser iniciados na seguinte ordem:
- Passo 1: Iniciar o ConfigServer
    - ```cd ConfigServer```
    - ```mvn clean install```
    - ```mvn spring-boot:run```
- Passo 2: Iniciar o ClienteService

    Em um novo terminal:
    - ```cd ClienteService```
    - ```mvn clean install```
    - ```mvn spring-boot:run```
- Passo 3: Iniciar o ProdutoService

    Em um novo terminal:
    - ```cd ProdutoService```
    - ```mvn clean install```
    - ```mvn spring-boot:run```

- Passo 4: Iniciar o VendasService

    Em um novo terminal:
    - ```cd VendasService```
    - ```mvn clean install```
    - ```mvn spring-boot:run```
### **6️⃣ Acessar a Documentação da API (Swagger)**
Após iniciar os serviços, acesse a documentação interativa:

- ClienteService: http://localhost:8081/swagger-ui.html
- ProdutoService: http://localhost:8082/swagger-ui.html
- VendasService: http://localhost:8083/swagger-ui.html

## **🛑 Parando os Serviços**
Para parar os serviços, pressione Ctrl + C em cada terminal onde os serviços estão rodando.

Ordem Recomendada para Parar:

    1. VendasService
    2. ProdutoService
    3. ClienteService
    4. ConfigServer

---

## 🔧 Troubleshooting

### **Problema: Config Server não inicia**

**Erro**: `Application failed to start`

**Solução**:
- Verifique se a porta 8888 está livre: `netstat -ano | findstr :8888` (Windows) ou `lsof -i :8888` (Linux/Mac)
- Certifique-se de que os arquivos de configuração estão na pasta correta


### **Problema: Serviço não conecta ao Config Server**

**Erro**: `Could not locate PropertySource`

**Solução**:
1. Verifique se o Config Server está rodando: `curl http://localhost:8888/actuator/health`
2. Verifique o arquivo `application.properties` do serviço
3. Reinicie o serviço após o Config Server estar completamente iniciado


### **Problema: Erro de conexão com MongoDB**

**Erro**: `MongoSocketOpenException` ou `Authentication failed`

**Solução**:
1. Verifique se o MongoDB está rodando: `mongosh`
2. Confirme as credenciais no arquivo de configuração:
   - Usuário: `admin`
   - Senha: `superSecreta`
3. Teste a conexão:

```bash
mongosh "mongodb://admin:superSecreta@localhost:27017/?authMechanism=SCRAM-SHA-256"
```

## **🌟 Agradecimentos**

- EBAC - Escola Britânica de Artes Criativas e Tecnologia pelo curso Especialista Java Back-end
- Spring Team - Pela excelente documentação e frameworks
- MongoDB - Pelo banco de dados NoSQL robusto
- Comunidade Open Source - Por todas as ferramentas e bibliotecas utilizadas

## **📚 Referências e Documentação**
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/?)
- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud?)
- [MongoDB Documentation](https://www.mongodb.com/docs/?)
- [OpenFeign Documentation](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/?)
- [Spring Data MongoDB](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)
- [SpringDoc OpenAPI](https://springdoc.org/)

Desenvolvido com ❤️ e ☕ por Harrison Oliveira
