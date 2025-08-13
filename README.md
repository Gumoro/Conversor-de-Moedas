# Conversor de Moedas em Java 
## Descrição
Este projeto é um **conversor de moedas** desenvolvido em Java, que permite ao usuário converter valores entre diferentes moedas utilizando a API **ExchangeRate API**. O programa é interativo, rodando no console, e suporta opções prontas ou conversões personalizadas. 


--- 
## Funcionalidades 
- Converter valores entre moedas populares (USD, BRL, EUR, JPY).
- Permitir conversões personalizadas, digitando qualquer moeda suportada pela API.
- Repetir conversões sem reiniciar o programa. - Mostrar resultado formatado e legível no console.
- Tratar entradas inválidas e informar erros ao usuário.
---
## Detalhes das Classes
### 1. Main.java
- Classe principal que roda o programa no console.
-  Exibe um menu para o usuário escolher ou digitar moedas. 
-  Lê o valor a ser convertido e mostra o resultado. 
-  Pergunta se o usuário quer realizar outra conversão.

Exemplo de uso:

```text
===== Conversor de Moedas =====
Escolha a conversão desejada:
1 - USD para BRL
2 - BRL para USD
7 - Personalizada (digite as moedas)
0 - Sair
Digite o número desejado: 1
Digite o valor a ser convertido: 10
10.00 USD = 54.37 BRL
Deseja fazer outra conversão? (S/N): N
Encerrando o conversor...
```

### 2. ConversorMoedaService.java 
- Classe responsável por **conectar à API ExchangeRate**.
- Possui o método buscarConversao(String base, String target) que retorna um objeto Moeda com a taxa de conversão.


Fluxo: 
1. Monta a URL da API usando as moedas escolhidas.
2. Conecta via HttpURLConnection.
3. Lê o JSON retornado da API.
4. Converte o JSON em objeto Moeda usando **Gson**.
5. Retorna o objeto para o Main.java.

Exemplo de JSON retornado pela API: 
```json
{
  "base_code": "USD",
  "target_code": "BRL",
  "conversion_rate": 5.4371
}
```

### 3. Moeda.java Classe modelo para armazenar a resposta da API:
```
public class Moeda {
    private String base_code;      // Moeda de origem
    private String target_code;    // Moeda de destino
    private double conversion_rate; // Taxa de conversão

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }
}
``` 

Permite acessar a taxa de conversão e os códigos das moedas no Main.java.

## Observações

- A taxa de conversão é obtida em tempo real, dependendo da API. 
- Caso a API não responda ou a moeda seja inválida, o programa exibirá uma mensagem de erro.
- O usuário pode repetir várias conversões sem reiniciar o programa.
Exemplo de Execução:
```text
===== Conversor de Moedas =====
Escolha a conversão desejada:
1 - USD para BRL
2 - BRL para USD
3 - EUR para BRL
7 - Personalizada (digite as moedas)
0 - Sair
Digite o número desejado: 7
Digite a moeda de origem (ex: GBP): GBP
Digite a moeda de destino (ex: BRL): BRL
Digite o valor a ser convertido: 100
100.00 GBP = 657.50 BRL
Deseja fazer outra conversão? (S/N): S
===== Conversor de Moedas =====
Escolha a conversão desejada:
1 - USD para BRL
2 - BRL para USD
...
```
## Linguagens e Ferramentas Utilizadas - **Linguagem:** Java - **IDE:** IntelliJ IDEA - **Bibliotecas:** Gson pLinguagens e Ferramentas Utilizadas

Linguagem: Java

IDE: IntelliJ IDEA

Bibliotecas: Gson para conversão de JSON em objeto Java

API: ExchangeRate API (para obter taxas de conversão em tempo real)

Autor

Criado por: Gustavo Moreira Rocha

LinkedIn: https://www.linkedin.com/in/gustavo-rocha-9b9682167/
