package br.com.grocha.conversormoedas.servico;

import br.com.grocha.conversormoedas.modelo.Moeda;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoedaService {

    public Moeda buscarConversao(String base, String target) {
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/dc0e396fbed7758f20279c16/pair/"
                    + base + "/" + target;

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            Gson gson = new Gson();
            Moeda moeda = gson.fromJson(new InputStreamReader(request.getInputStream()), Moeda.class);

            return moeda;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}