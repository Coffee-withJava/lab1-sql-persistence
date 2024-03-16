## Criando a Classe `OrderEntity`

Vamos criar uma classe chamada `OrderEntity.java` para representar um pedido de um cliente. Esta classe será mapeada para uma tabela chamada "orders" em um banco de dados usando o Hibernate. A classe terá os seguintes atributos:

- `id`: Chave primária do pedido.
- `idCustomer`: Referência ao cliente que fez o pedido, utilizando associação muitos para um (ManyToOne) com a classe `CustomerEntity`.
- `orderDate`: Data e hora do pedido.
- `paymentTransaction`: Informação sobre a transação de pagamento do pedido.

### Mapeando a Entidade com o Hibernate

Ao usar o Hibernate, precisamos informar como mapear nossa classe para uma tabela. Usaremos anotações específicas para isso:

1. **`@Entity`**: Indica ao Hibernate que a classe `OrderEntity` é uma entidade que será mapeada para uma tabela no banco de dados. Quando o Hibernate é inicializado, ele procura por todas as classes anotadas com `@Entity` e cria as tabelas correspondentes no banco de dados.

2. **`@Table`**: Esta anotação é usada para especificar o nome da tabela no banco de dados. No nosso caso, estamos configurando o nome da tabela como "orders".

3. **`@Id`**: Colocada acima do campo `id`, indica que este é o campo chave primária da entidade. Uma chave primária é um valor único que identifica exclusivamente cada registro na tabela do banco de dados. A anotação `@Id` é seguida pela anotação `@GeneratedValue`, que especifica como o valor da chave primária será gerado. Neste exemplo, estamos usando `GenerationType.AUTO`, indicando que o banco de dados irá gerar automaticamente valores para a chave primária.

4. **`@ManyToOne`**: Esta anotação indica uma associação muitos para um (ManyToOne) entre `OrderEntity` e `CustomerEntity`. Ou seja, muitos pedidos podem pertencer a um único cliente. A anotação `@ManyToOne` é configurada com `cascade = CascadeType.ALL`, o que significa que todas as operações (persistir, remover, atualizar) feitas no pedido também serão aplicadas ao cliente associado.

5. **`@Column`**: Usada para mapear um campo da classe para uma coluna na tabela do banco de dados.

### Métodos Getters e Setters

Por fim, é importante criar métodos `get` e `set` para cada atributo da classe. Estes métodos são essenciais para garantir um acesso controlado aos campos privados da classe, seguindo as práticas de encapsulamento em Java.

Em resumo, a classe `OrderEntity` representa um pedido feito por um cliente. Ela será mapeada para a tabela "orders" no banco de dados, utilizando o Hibernate e suas anotações. A associação `@ManyToOne` permite que um pedido esteja relacionado a um único cliente, e os métodos getters e setters garantem um acesso controlado aos atributos da classe.

