## Criando a Classe `CustomerEntity`

Vamos criar uma classe chamada `CustomerEntity.java` para representar um cliente. Esta classe será mapeada para uma tabela em um banco de dados usando o Hibernate. A classe terá os seguintes atributos:

- `id`: Chave primária do cliente.
- `name`: Nome do cliente.
- `email`: E-mail do cliente, validado com a anotação `@Email`.
- `cpf`: CPF do cliente, validado com a anotação `@CPF`.

### Mapeando a Entidade com o Hibernate

Ao usar o Hibernate, precisamos informar como mapear nossa classe para uma tabela. Usaremos anotações específicas para isso:

1. **`@Entity`**: Indica ao Hibernate que a classe `CustomerEntity` é uma entidade que será mapeada para uma tabela no banco de dados. Quando o Hibernate é inicializado, ele procura por todas as classes anotadas com `@Entity` e cria as tabelas correspondentes no banco de dados.

2. **`@Id`**: Colocada acima do campo `id`, indica que este é o campo chave primária da entidade. Uma chave primária é um valor único que identifica exclusivamente cada registro na tabela do banco de dados. A anotação `@Id` é seguida pela anotação `@GeneratedValue`, que especifica como o valor da chave primária será gerado. Neste exemplo, estamos usando `GenerationType.AUTO`, indicando que o banco de dados irá gerar automaticamente valores para a chave primária.

3. **`@Column`**: Usada para mapear um campo da classe para uma coluna na tabela do banco de dados.

4. **`@Email`**: Anotação de validação que garante que o valor do campo `email` siga o padrão de um endereço de e-mail válido.

5. **`@CPF`**: Anotação de validação que garante que o valor do campo `cpf` seja um CPF válido, de acordo com as regras estabelecidas no Brasil.

### Métodos Getters e Setters

Por fim, é importante criar métodos `get` e `set` para cada atributo da classe. Estes métodos são essenciais para garantir um acesso controlado aos campos privados da classe, seguindo as práticas de encapsulamento em Java.

Em resumo, a classe `CustomerEntity` representa um cliente que pode ser armazenado em um banco de dados. Ela será mapeada para a tabela correspondente no banco de dados, utilizando o Hibernate e suas anotações. As anotações `@Entity`, `@Id`, `@Column`, `@Email` e `@CPF` fornecem ao Hibernate as informações necessárias para realizar o mapeamento corretamente.

