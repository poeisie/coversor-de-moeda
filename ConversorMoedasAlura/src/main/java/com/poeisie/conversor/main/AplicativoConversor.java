package com.poeisie.conversor.main;

import com.poeisie.conversor.api.ClienteApiCambio;
import com.poeisie.conversor.api.LeitorDadosCambio;
import com.poeisie.conversor.servico.ConversorMoedas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicativoConversor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClienteApiCambio clienteApiCambio = new ClienteApiCambio();
        LeitorDadosCambio leitorDadosCambio = new LeitorDadosCambio();
        ConversorMoedas conversor = new ConversorMoedas(clienteApiCambio, leitorDadosCambio);

        System.out.println("--- Bem-vindo ao Conversor de Moedas! ---");

        try {
            System.out.print("Digite a moeda de origem (ex: USD, BRL): ");
            String moedaOrigem = scanner.next().toUpperCase();

            System.out.print("Digite a moeda de destino (ex: EUR, JPY): ");
            String moedaDestino = scanner.next().toUpperCase();

            System.out.print("Digite o valor para converter: ");
            double valor = scanner.nextDouble();

            double valorConvertido = conversor.converter(valor, moedaOrigem, moedaDestino);

            System.out.printf("Resultado: %.2f %s equivalem a %.2f %s%n", valor, moedaOrigem, valorConvertido, moedaDestino);

        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Por favor, digite um número para o valor.");
        } catch (IOException e) {
            System.err.println("Erro de rede ou comunicação com a API: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Operação interrompida. Tente novamente.");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao processar a conversão: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}