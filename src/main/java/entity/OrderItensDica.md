## Criando a Classe `OrderItemsEntity`

Vamos criar uma classe chamada `OrderItemsEntity.java` para representar os itens de um pedido. Esta classe será mapeada para uma tabela chamada "order_items" em um banco de dados usando o Hibernate. A classe terá os seguintes atributos:

- `id`: Chave primária do item do pedido.
- `idCustomer`: Referência ao cliente que fez o pedido, utilizando associação muitos para um (ManyToOne) com a classe `CustomerEntity`.
- `idOrder`: Referência ao pedido ao qual o item pertence, utilizando associação muitos para um (ManyToOne) com a classe `OrderEntity`.
- `productName`: Nome do produto do item do pedido.
- `quantity`: Quantidade do produto no item do pedido.
- `price`: Preço do produto no item do pedido.

### Mapeando a Entidade com o Hibernate

Ao usar o Hibernate, precisamos informar como mapear nossa classe para uma tabela. Usaremos anotações específicas para isso:

1. **`@Entity`**: Indica ao Hibernate que a classe `OrderItemsEntity` é uma entidade que será mapeada para uma tabela no banco de dados. Quando o Hibernate é inicializado, ele procura por todas as classes anotadas com `@Entity` e cria as tabelas correspondentes no banco de dados.

2. **`@Table`**: Esta anotação é usada para especificar o nome da tabela no banco de dados. No nosso caso, estamos configurando o nome da tabela como "order_items".

3. **`@Id`**: Colocada acima do campo `id`, indica que este é o campo chave primária da entidade. Uma chave primária é um valor único que identifica exclusivamente cada registro na tabela do banco de dados. A anotação `@Id` é seguida pela anotação `@GeneratedValue`, que especifica como o valor da chave primária será gerado. Neste exemplo, estamos usando `GenerationType.IDENTITY`, indicando que o banco de dados irá gerar automaticamente valores para a chave primária.

4. **`@ManyToOne`**: Esta anotação indica uma associação muitos para um (ManyToOne) entre `OrderItemsEntity` e `CustomerEntity`, e também entre `OrderItemsEntity` e `OrderEntity`. Isso significa que muitos itens do pedido podem pertencer a um único cliente, e muitos itens do pedido podem estar em um único pedido. A anotação `@ManyToOne` é configurada com `cascade = CascadeType.ALL`, o que significa que todas as operações (persistir, remover, atualizar) feitas nos itens do pedido também serão aplicadas ao cliente e ao pedido associados.

5. **`@Column`**: Usada para mapear um campo da classe para uma coluna na tabela do banco de dados.

### Métodos Getters e Setters

Por fim, é importante criar métodos `get` e `set` para cada atributo da classe. Estes métodos são essenciais para garantir um acesso controlado aos campos privados da classe, seguindo as práticas de encapsulamento em Java.

Em resumo, a classe `OrderItemsEntity` representa os itens de um pedido feito por um cliente. Ela será mapeada para a tabela "order_items" no banco de dados, utilizando o Hibernate e suas anotações. As associações `@ManyToOne` permitem que um item do pedido esteja relacionado a um único cliente e a um único pedido, e os métodos getters e setters garantem um acesso controlado aos atributos da classe.

