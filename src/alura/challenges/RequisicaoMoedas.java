package alura.challenges;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class RequisicaoMoedas {
    private final String apiKey;

    public RequisicaoMoedas() {
        this.apiKey = this.loadApiKey();
    }

    private String loadApiKey() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);

            return properties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    public double obterTaxaConversao(String moedaOrigem, String moedaDestino) {
        String urlString = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaOrigem + "/" + moedaDestino;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlString))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                ExchangeRateApiResponse apiResponse = gson.fromJson(response.body(), ExchangeRateApiResponse.class);

                return apiResponse.conversion_rate();
            } else {
                System.out.println("Falha na requisição: Código de status " + response.statusCode());

                return -1;
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();

            return -1;
        }
    }
}
