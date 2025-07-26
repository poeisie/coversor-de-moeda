package com.poeisie.conversor.servico;

import com.poeisie.conversor.api.ClienteApiCambio;
import com.poeisie.conversor.api.LeitorDadosCambio;

import java.io.IOException;

public class ConversorMoedas {

    private final ClienteApiCambio clienteApiCambio;
    private final LeitorDadosCambio leitorDadosCambio;

    public ConversorMoedas(ClienteApiCambio clienteApiCambio, LeitorDadosCambio leitorDadosCambio) {
        this.clienteApiCambio = clienteApiCambio;
        this.leitorDadosCambio = leitorDadosCambio;
    }

    public double obterTaxaCambio(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException, Exception {
        String jsonResposta = clienteApiCambio.obterDadosCambioJson(moedaOrigem);
        return leitorDadosCambio.lerTaxaCambio(jsonResposta, moedaDestino, moedaOrigem);
    }

    public double converter(double valor, String moedaOrigem, String moedaDestino) throws IOException, InterruptedException, Exception {
        double taxaCambio = obterTaxaCambio(moedaOrigem, moedaDestino);
        return valor * taxaCambio;
    }
}