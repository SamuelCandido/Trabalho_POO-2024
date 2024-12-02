# Gerenciamento de Lançamentos Financeiros

Uma aplicação de gerenciamento de finanças pessoais que permite o controle de receitas e despesas, exibindo informações organizadas em uma interface gráfica.

## 📝 Descrição Geral

A aplicação foi desenvolvida em **Java**, utilizando **Swing** para a interface gráfica e o paradigma de **Programação Orientada a Objetos (POO)**. Funcionalidades principais incluem:

- Adicionar receitas e despesas.
- Excluir lançamentos financeiros.
- Exibir lançamentos categorizados e ordenados por data.
- Gerar relatórios detalhados de extrato.
- Importar e exportar lançamentos financeiros em arquivos de texto.

---

## 🚀 Funcionalidades

### 1. Cadastro de Lançamentos
- **Receitas:** Categorias como salário, aluguel, investimentos, entre outras.
- **Despesas:** Categorias como moradia, alimentação, lazer, entre outras.
- Validação de dados, incluindo formato de data e valores antes do cadastro.

### 2. Exclusão de Lançamentos
- Exclui lançamentos com base no **ID**.
- Garantia de exclusão somente para IDs válidos.

### 3. Relatório de Extrato
- Apresenta um relatório com:
  - Tipo do lançamento (Receita ou Despesa).
  - Categoria associada.
  - Valor e data do lançamento.
  - Saldo atualizado após cada movimentação.

### 4. Importação e Exportação
- **Importação:** Carrega lançamentos a partir de arquivos de texto.
- **Exportação:** Salva lançamentos em formato **TXT**.

### 5. Filtros e Organização
- **Filtros:** Permite exibir lançamentos por:
  - Tipo (Receitas, Despesas ou Todos).
  - Período (Data Atual ou por Intervalo).
- **Ordenação:** Lançamentos organizados automaticamente por data.

---

## 📂 Estrutura do Projeto

### 1. Pacote **Model**
Responsável pelas regras de negócio e objetos do sistema

### 2. Pacote **View**
Interface gráfica implementada com **Swing**

---

## 🗂 Documentação

Na pasta **Documentos** do projeto, você encontrará os seguintes materiais complementares:

1. **Diagrama:** Apresenta a estrutura do sistema e suas relações.
2. **Plano de Teste:** Descreve os testes realizados para validar as funcionalidades.
3. **Javadoc:** Documentação gerada automaticamente com a descrição detalhada do código.


---
## 🛠 Tecnologias Utilizadas
- **Linguagem de Programação:** Java
- **Interface Gráfica:** Swing
- **Paradigma de Desenvolvimento:** Orientação a Objetos (POO)
- **Gerenciamento de Dependências:** Ant (NetBeans)

- Integrantes: Samuel, Vitor, Maria
