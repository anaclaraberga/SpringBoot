# Aplicação com SpringBoot

## Objetivo do projeto

Um sistema que realiza o cadastro de produtos contendo nome e valor, juntamente sendo possível a pesquisa desses produtos, atualização dos dados e exclusão dos mesmos com os métodos GET, PUT, DELETE e POST.

## Utilização

Para utilizar a aplicação de maneira coesa, é realizado a instalação do banco de dados PostgreSQL. Após isso, deve-se criar uma database com o nome SpringBoot para a hospedagem.

> Por padrão da máquina, a aplicação é inicializada na porta 8080.

## Back-End

Já o back-end da aplicação consiste em uma API, sendo ela responsável pela comunicação com o banco de dados e controle de consumo de dados.

###  Controllers

O Controller é responsável por receber todas as requisições do usuário. Seus métodos chamados actions são responsáveis por uma página, controlando qual model usar e qual view será mostrado ao usuário.

![alt](https://www.alura.com.br/apostila-java-web/assets/imagens/mvc/request-dispatcher.png)

- Cadastro de produtos => Utilização do método POST.

- Procurar por todos os produtos => Utilização do método GET.

- Procurar por um produto específico => Utilização do método GET.

- Atualizar um produto => Utilização do método PUT.

- Deletar um dos produtos => Utilização do método DELETE.

### Controllers e Rotas

> Cadastro de produtos:

```java
  @PostMapping("/products")
  public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
    var productModel = new ProductModel();
    BeanUtils.copyProperties(productRecordDto, productModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
  }
```

> Procurar por todos os produtos:

```java
  @GetMapping("/products")
  public ResponseEntity<List<ProductModel>> getAllProducts(){
    return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
  }
```

> Procurar por um produto específico:

```java
  @GetMapping("/products/{id}")
  public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {
    Optional<ProductModel> product0 = productRepository.findById(id);
    if(product0.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(product0.get());
  }
```

> Atualizar um produto:

```java
  @PutMapping("/products/{id}")
  public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {
    Optional<ProductModel> product0 = productRepository.findById(id);
      if(product0.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
    }
    var productModel = product0.get();
    BeanUtils.copyProperties(productRecordDto, productModel);
    return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
  }
```
> Deletar um produto:

```java
  @DeleteMapping("/products/{id}")
  public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
    Optional<ProductModel> product0 = productRepository.findById(id);
    if(product0.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
    }
    productRepository.delete(product0.get());
    return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
  }
```