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

    private static Map<String, String> countryCodes = new HashMap<String, String>(
        Map.ofEntries(
            Map.entry("United States", "US"),
            Map.entry("Canada", "CA"),
            Map.entry("United Kingdom", "GB"),
            Map.entry("Germany", "DE"),
            Map.entry("France", "FR"),
            Map.entry("Japan", "JP"),
            Map.entry("Australia", "AU"),
            Map.entry("India", "IN"),
            Map.entry("China", "CN"),
            Map.entry("Brazil", "BR"),
            Map.entry("Russia", "RU"),
            Map.entry("South Korea", "KR"),
            Map.entry("Italy", "IT"),
            Map.entry("Spain", "ES"),
            Map.entry("Netherlands", "NL"),
            Map.entry("Switzerland", "CH"),
            Map.entry("Sweden", "SE"),
            Map.entry("Norway", "NO"),
            Map.entry("Finland", "FI"),
            Map.entry("Denmark", "DK"),
            Map.entry("Belgium", "BE")
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

    public static String buildUrlResponse (String countryAcronym) {
        String queryParameters = "&token=" + getApiKey();
        String endPoint = "stock/market-status?exchange=" + countryAcronym; // get endpoint
        String url = "https://finnhub.io/api/v1/" + endPoint + queryParameters;
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

    public static ArrayList<Stock> parseResponseData (String country) {
        String countryCode = countryCodes.get(country);
        String responseBody = buildUrlResponse(countryCode);
        JSONObject jsonObj = new JSONObject(responseBody);
        return 0;
    }

}