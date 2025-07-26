package com.poeisie.conversor.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class LeitorDadosCambio {

    private final Gson gson;

    public LeitorDadosCambio() {
        this.gson = new Gson();
    }

    public double lerTaxaCambio(String jsonResposta, String moedaDestino, String moedaBase) throws Exception {
        JsonObject objetoJson;
        try {
            objetoJson = gson.fromJson(jsonResposta, JsonObject.class);
        } catch (JsonSyntaxException e) {
            throw new JsonSyntaxException("Erro ao ler JSON: Resposta da API não é um objeto JSON. Verifique a chave da API ou o formato da resposta. Detalhes: " + e.getMessage() + "\nResposta recebida: " + jsonResposta);
        }

        String resultado = objetoJson.get("result").getAsString();
        if (!"success".equals(resultado)) {
            String tipoErro = objetoJson.has("error-type") ? objetoJson.get("error-type").getAsString() : "Desconhecido";
            throw new Exception("Erro da API: " + tipoErro + ". Resposta: " + jsonResposta);
        }

        JsonObject taxasConversao = objetoJson.getAsJsonObject("conversion_rates");

        if (taxasConversao.has(moedaDestino)) {
            return taxasConversao.get(moedaDestino).getAsDouble();
        } else {
            throw new Exception("Moeda de destino '" + moedaDestino + "' não encontrada nas taxas de câmbio para '" + moedaBase + "'.");
        }
    }
}