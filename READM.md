# 🛍️ Sistema de Vendas - Microserviços

## 📋 Sobre o Projeto

O **Sistema de Vendas** é uma aplicação baseada em arquitetura de microserviços desenvolvida durante
o curso Especialista Java Back-end, na Ebac para gerenciar operações de vendas, clientes 
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