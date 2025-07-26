package com.poeisie.conversor.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

    public class ClienteApiCambio {

        private static final String API_KEY = "";
        private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
        private static final String END_URL = "/latest/";

        private final HttpClient httpClient;

        public ClienteApiCambio() {
            this.httpClient = HttpClient.newHttpClient();
        }

        public String obterDadosCambioJson(String moedaBase) throws IOException, InterruptedException {
            String urlRequisicao = BASE_URL + API_KEY + END_URL + moedaBase.toUpperCase();
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create(urlRequisicao))
                    .build();

            HttpResponse<String> resposta = httpClient.send(requisicao, HttpResponse.BodyHandlers.ofString());

            if (resposta.statusCode() != 200) {
                throw new IOException("Erro na API. Status: " + resposta.statusCode() + ", Corpo: " + resposta.body());
            }

            return resposta.body();
        }
    }
