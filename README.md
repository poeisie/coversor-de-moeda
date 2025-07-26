# Conversor de Moedas

Este projeto é um **Conversor de Moedas** simples, desenvolvido como parte do curso Java e Orientação a Objetos G8 - ONE, da Alura. Ele te permite converter valores entre diferentes moedas usando taxas de câmbio atualizadas, direto de uma API externa.

-----

## Funcionalidades

  * **Conversão de Moedas**: Converta um valor de uma moeda de origem para uma moeda de destino.
  * **Integração com API Externa**: As taxas de câmbio são obtidas em tempo real pela [ExchangeRate-API](https://www.exchangerate-api.com/).
  * **Estrutura Modular**: O código é organizado em classes separadas, o que o torna mais fácil de manter e entender.

-----

## Como Usar

1.  **Clone o Repositório:**

    ```bash
    git clone https://github.com/seu-usuario/nome-do-seu-repositorio.git
    cd nome-do-seu-repositorio
    ```

2.  **Obtenha sua Chave da API:**

      * Acesse o site da [ExchangeRate-API](https://www.exchangerate-api.com/) e faça seu registro para conseguir sua **chave de API gratuita**.

3.  **Configure a Chave da API no Código:**

      * Abra o arquivo `src/main/java/com/poeisie/conversor/api/ClienteApiCambio.java`.

      * Encontre a linha que define a `API_KEY`:

        ```java
        private static final String API_KEY = "SUA_API_KEY_AQUI";
        ```

      * Substitua `"SUA_API_KEY_AQUI"` pela chave que você obteve.

4.  **Compile e Execute o Projeto:**

      * Você pode compilar e rodar o projeto usando sua IDE favorita (como IntelliJ IDEA, Eclipse, VS Code com extensões Java) ou diretamente pela linha de comando:

    <!-- end list -->

    ```bash
    # Navegue até a pasta raiz do projeto
    cd seu-projeto-conversor

    # Compile os arquivos Java
    javac -d out -cp "lib/*" src/main/java/com/poeisie/conversor/*.java src/main/java/com/poeisie/conversor/api/*.java src/main/java/com/poeisie/conversor/servico/*.java

    # Execute o aplicativo
    java -cp "out:lib/*" com.poeisie.conversor.AplicativoConversor
    ```

      * **Importante**: Certifique-se de ter a biblioteca **Gson** (para JSON) no seu `CLASSPATH` ou já incluída no seu projeto, caso esteja usando um sistema de build como Maven ou Gradle. O comando acima considera que o arquivo JAR do Gson está na pasta `lib/` na raiz do seu projeto.

5.  **Interaja com o Conversor:**

      * Basta seguir as instruções no console para digitar as moedas de origem e destino, além do valor que você quer converter.

-----

## Estrutura do Projeto

O código está organizado nas seguintes pastas e classes para garantir uma **boa separação de responsabilidades**:

```
src/main/java/com/poeisie/conversor/
├── api/
│   ├── ClienteApiCambio.java    # Cuida da comunicação HTTP com a API.
│   └── LeitorDadosCambio.java   # Analisa a resposta JSON da API.
├── servico/
│   └── ConversorMoedas.java     # Contém a lógica principal da conversão.
└── AplicativoConversor.java     # É o ponto de entrada do programa e gerencia a interação com o usuário.
```

-----

## Tecnologias Utilizadas

  * **Java 11+**: Linguagem de programação.
  * **Java HTTP Client**: Usado para fazer requisições HTTP (já vem no Java a partir da versão 11).
  * **Gson**: Biblioteca para trabalhar com JSON.

-----

## Contribuições

Fique à vontade para explorar, modificar e melhorar este projeto. Suas sugestões e *pull requests* são muito bem-vindas\!

-----

## Licença

Este projeto está sob a licença MIT.
