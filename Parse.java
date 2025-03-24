import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Parse {

    private final static String API_KEY = getAPIKeyFromPython();

    private static Map<String, String> stockCodes = new HashMap<String, String>(
        Map.ofEntries(
            Map.entry("Apple", "AAPL")
        )
    );

    public Parse() {}

    public static String getApiKey() {
        return API_KEY;
    }

    private static String getAPIKeyFromPython() {
        String apiKey = null;
        try {
            String scriptPath = "./get_env.py";
            ProcessBuilder processBuilder = new ProcessBuilder("python", scriptPath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            apiKey = reader.readLine();

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return apiKey;
    }

    public static String buildUrlResponse (String stockCode) {
        String queryParameters = "&token=" + getApiKey();
        String endPoint = "quote?symbol=" + stockCode; // get endpoint
        String url = "https://finnhub.io/api/v1/" + endPoint + queryParameters;
        System.out.println(url);
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void parseResponseData (String stockName) {
        String stockCode = stockCodes.get(stockName);
        String responseBody = buildUrlResponse(stockCode);
        JSONObject jsonObj = new JSONObject(responseBody);
        System.out.println(responseBody);
    }

}