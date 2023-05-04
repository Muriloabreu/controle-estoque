# Controle de estoque

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Muriloabreu/controle-estoque/blob/main/LICENCE) 

# Sobre o projeto


Controle de estoque é uma API REST.

API - Java utilizando Spring boot com o proposito de realizar Vários CRUDs para controle de estoque.
Nessa API devemos cadastrar um Produto, informando sua Categoria, qual é o Fornecedor e a data e hora atual. Para manipulação do estoque, vamos cadastrar entradas de produto, onde informamos o Produto, sua quantidade, valor do produto, data e hora atual, ao realizar essa entrada o campo "Estoque Atual" da tabela Produto é alimentado. Para manipulação saída de estoque, cadastramos uma saída de produto, informando o Produto, quantidade e a data e hora atual, ao realizar essa saída de produto o campo "Estoque Atual" é subtraído.

Os CRUDs são:
- Categoria do produto; 
- Fornecedor; 
- Produto;
- Entrada de Produto; 
- Saída de Produto;


# Tecnologias utilizadas
## Back end
- Java
- Maven
- Spring Boot


## Implantação em produção

- Banco de dados: Postgres 9.5

## Back end
- Pré-requisitos: Java 11

# Como executar o projeto

Necessário ter um servidor Tomcat para poder rodar o projeto Java

##  Utilize uma plataforma de consultas de API's e faça a requisição de acordo os modelos disponíveis na sessão abaixo.
</code></pre>
 - Modelos de requisição JSON
</p>

</P>
<h5>Categoria</h5>

```json
{
        "id": 1,
        "nome": "Tecnologia",
        "descricao": "Tudo em informática"
    },
    {
        "id": 2,
        "nome": "PET",
        "descricao": "Tudo para animais"
    }
```
</p>
<h5>Fornecedor</h5>

```json
{
        "id": 1,
        "nome": "Fornecedor 01",
        "cnpj": "000.000.0001-01",
        "dataRegistro": "2023-05-02T14:14:46Z"
    },
    {
        "id": 2,
        "nome": "Fornecedor 02",
        "cnpj": "000.000.0001-02",
        "dataRegistro": "2023-05-02T14:15:00Z"
    }
```
</p>
<h5>Produto</h5>

```json
{
        "id": 2,
        "nome": "PC Gamer",
        "descricao": "Desktop para Games",
        "quantidadeMinima": 2,
        "quantidadeMaxima": 8,
        "estoqueAtual": 0,
        "dataRegistro": "2023-05-02T14:31:33Z",
        "categoria": {
                      "id": 1,
                      "nome": "Tecnologia",
                      "descricao": "Tudo em informática"
        },
        "fornecedor": {
                      "id": 5,
                      "nome": "Fornecedor 05",
                      "cnpj": "000.000.0001-05",
                      "dataRegistro": "2023-05-02T14:16:48Z"
        }
    }
```
</p>
</p>

<h5>EntradaProduto</h5>

```json
{
        "id": 102,
        "produtosModel": {
            "id": 2,
            "nome": "PC Gamer",
            "descricao": "Desktop para Games",
            "quantidadeMinima": 2,
            "quantidadeMaxima": 8,
            "estoqueAtual": 6,
            "dataRegistro": "2023-05-02T14:31:33Z",
            "categoria": {
                "id": 1,
                "nome": "Tecnologia",
                "descricao": "Tudo em informática"
            },
            "fornecedor": {
                "id": 5,
                "nome": "Fornecedor 05",
                "cnpj": "000.000.0001-05",
                "dataRegistro": "2023-05-02T14:16:48Z"
            }
        },
        "precoUnitario": 6202.0,
        "quantidade": 2,
        "dataRegistro": "2023-05-03T10:11:52Z"
    }
```
</p>
</p>

<h5>SaidaProduto</h5>

```json
{
    "produtosModel":
                {
        "id": 103,
        "nome": "PC Gamer",
        "descricao": "Desktop para Games",
        "quantidadeMinima": 2,
        "quantidadeMaxima": 8,
        "estoqueAtual": 5,
        "dataRegistro": "2023-05-03T01:12:37Z",
        "categoria": {
            "id": 2,
            "nome": "Informática",
            "descricao": "Todos tipos de aparelhos"
        },
        "fornecedor": {
            "id": 52,
            "nome": "Fornecedor 6",
            "cnpj": "000.000.0001-06",
            "dataRegistro": "2023-04-29T14:01:32Z"
        }
    },
            "quantidade": 1
    
    
    
}
```
</p>
</p>


- Baixar o projeto

```bash
# clonar repositório
git clone git@github.com:Muriloabreu/controle-estoque.git

```

# Autor

Murilo Abreu do Nascimento

https://www.linkedin.com/in/murilo-abreu/
