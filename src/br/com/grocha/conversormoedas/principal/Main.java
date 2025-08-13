package br.com.grocha.conversormoedas.principal;

import br.com.grocha.conversormoedas.modelo.Moeda;
import br.com.grocha.conversormoedas.servico.ConversorMoedaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedaService service = new ConversorMoedaService();
        boolean continuar = true;

        while (continuar) {
            System.out.println("===== Conversor de Moedas =====");
            System.out.println("Escolha a conversão desejada:");
            System.out.println("1 - USD para BRL");
            System.out.println("2 - BRL para USD");
            System.out.println("3 - EUR para BRL");
            System.out.println("4 - BRL para EUR");
            System.out.println("5 - JPY para BRL");
            System.out.println("6 - BRL para JPY");
            System.out.println("7 - Personalizada (digite as moedas)");
            System.out.println("0 - Sair");
            System.out.print("Digite o número desejado: ");

            int opcao = scanner.nextInt();
            String de = "", para = "";

            switch (opcao) {
                case 1: de = "USD"; para = "BRL"; break;
                case 2: de = "BRL"; para = "USD"; break;
                case 3: de = "EUR"; para = "BRL"; break;
                case 4: de = "BRL"; para = "EUR"; break;
                case 5: de = "JPY"; para = "BRL"; break;
                case 6: de = "BRL"; para = "JPY"; break;
                case 7: // Conversão personalizada
                    System.out.print("Digite a moeda de origem (ex: USD): ");
                    de = scanner.next().toUpperCase();
                    System.out.print("Digite a moeda de destino (ex: BRL): ");
                    para = scanner.next().toUpperCase();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Encerrando o conversor...");
                    continue;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            Moeda resultado = service.buscarConversao(de, para);

            if (resultado != null) {
                double convertido = valor * resultado.getConversion_rate();
                System.out.printf("%.2f %s = %.2f %s%n", valor, de, convertido, para);
            } else {
                System.out.println("Não foi possível obter a conversão.");
            }

            // Perguntar se deseja fazer outra conversão
            System.out.print("\nDeseja fazer outra conversão? (S/N): ");
            String resposta = scanner.next().toUpperCase();
            if (!resposta.equals("S")) {
                continuar = false;
                System.out.println("Encerrando o conversor...");
            }

            System.out.println(); // linha em branco para organizar a tela
        }

        scanner.close();
    }
}