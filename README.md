# Técnicas de refatoração


## 🚀 Começando

Exemplos de refatoração de código módulo 02

### 📋 Pré-requisitos

JAVA 1.8

### ⚙️Remover atribuições a parâmetros
```
Class CalculadoraDeCompra.java
```
### ⚙️Substituir método por objeto método
```
Class ISBN.java
Class ValidarISBN.java  
```
### ⚙️Substituir algoritmo
```
Class Livros.java  
```
### ⚙ Extraindo classes 
#### Mover método
```
Class Desconto.java
Class TipoDeDesconto.java
```
#### Mover campo
```
Class SelecaoDeLivro.java
-Remover o atributo cep que era passado como parametro no médodo
adionarLivroNoCarrinhoDoCliente e adicionar na classe Cliente.java
```

#### Extrair código para um nova classe
```
Class  SelecaoDeLivro.java
Classe CarrinhoDeComprasFactory.java
 -Foi extraído o código que tinha como função obter o carrinho de compra
 de um cliente para adicionar um livro.
 Criamos uma classe para cuidar dessa responsabilidade    
```