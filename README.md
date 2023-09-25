# API de Processamento de Pagamento com Spring Boot

Esta é uma API REST simples construída com o Spring Boot para processamento de pagamentos. Ela permite que os clientes façam pagamentos por boleto, pix, cartão de crédito e débito e consultem o status dos pagamentos.

## Funcionalidades Principais

- [x] Cadastro de Pagamentos. Recebe por RequestBody JSON conforme abaixo:
```json
{
    "cpfCnpj": "2342323233",
    "metodoPagamento": 3,
    "numCartao": "2809283098224",
    "valor": 538,
    "status": {
        "id": 2
    }
}
```
- [x] Consulta de Pagamentos com opção de filtro por id, cpfCnpj ou status. Os dados devem ser enviados por RequestParams.
- [x] Atualização de Status de Pagamentos. Recebe por RequestBody JSON conforme abaixo:
```json
{
    "idPagamento": 4,
    "idNovoStatus": 1
}
```
- [x] Exclusão de Pagamentos que recebe por PathVariable o id do Pagamento.

## Pré-requisitos

Antes de começar a usar esta API, certifique-se de ter as seguintes ferramentas e recursos configurados:

- [Java Development Kit (JDK)]
- [Spring Boot]
- Banco de Dados H2 configurado no arquivo pom.xml

