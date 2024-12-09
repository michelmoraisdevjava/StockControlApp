# **Controle de Estoque**

Este é um sistema básico de controle de estoque desenvolvido em **Java**, que permite gerenciar produtos de uma loja. O objetivo principal do sistema é fornecer uma interface simples para operações comuns de estoque, como adicionar produtos, registrar vendas, consultar e listar produtos, além de remover produtos obsoletos.

## **Funcionalidades**
- 📦 **Consulta de Estoque**: Verifica a quantidade disponível de um produto específico.
- ➕ **Adicionar Produtos**: Permite aumentar a quantidade de um produto no estoque.
- ➖ **Registrar Venda**: Reduz a quantidade de um produto no estoque com base nas vendas.
- 🗑️ **Remover Produto**: Exclui produtos que não serão mais trabalhados.
- 📋 **Listar Produtos**: Exibe todos os produtos disponíveis e suas quantidades.
- 💾 **Salvar e Carregar Estoque**: Salva o estado do estoque em um arquivo CSV e o carrega no início.

## **Estrutura do Arquivo de Entrada**
O sistema utiliza um arquivo CSV para armazenar os dados do estoque. Cada linha do arquivo contém o nome do produto e sua quantidade, separados por uma vírgula.

**Exemplo de arquivo CSV (`estoque.csv`):**
```
Celular,50
Notebook,30
Carregador,100
Fone de Ouvido,150
Monitor,40
Teclado,70
Mouse,80
```

## **Tecnologias Utilizadas**
- ☕ **Java**: Linguagem de programação principal.
- 📂 **Java IO**: Manipulação de arquivos.
- 🔗 **Coleções Java**: Uso de `Map` para gerenciar os produtos e suas quantidades.

## **Como Executar**
1. Clone este repositório para sua máquina local:
   ```bash
   git clone https://github.com/michelmoraisdevjava/StockControlApp/tree/main
   ```
2. Importe o projeto para sua IDE favorita (ex.: Eclipse ou IntelliJ).
3. Execute a classe principal `StockControlApp` para interagir com o sistema.

## **Contribuições**
Contribuições são bem-vindas! Sinta-se à vontade para abrir *issues* ou enviar *pull requests*.

## **Licença**
Este projeto é distribuído sob a licença MIT.
