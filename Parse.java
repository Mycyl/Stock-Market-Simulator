import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Parse {

    private final static String API_KEY = getAPIKeyFromPython();

    private static Map<String, String> stockCodes = new HashMap<String, String>(
        Map.ofEntries(
            Map.entry("apple", "AAPL"),
            Map.entry("nvidia", "NVDA"),
            Map.entry("microsoft", "MSFT"),
            Map.entry("tesla", "TSLA"),
            Map.entry("amazon", "AMZN"),
            Map.entry("google", "GOOGL"),
            Map.entry("facebook", "FB"),
            Map.entry("netflix", "NFLX"),
            Map.entry("ford", "F"),
            Map.entry("general motors", "GM"),
            Map.entry("ibm", "IBM"),
            Map.entry("intel", "INTC"),
            Map.entry("oracle", "ORCL"),
            Map.entry("qualcomm", "QCOM"),
            Map.entry("twitter", "TWTR"),
            Map.entry("uber", "UBER"),
            Map.entry("lyft", "LYFT"),
            Map.entry("zoom", "ZM")
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

    public static double[] parseResponseData (String stockName) {
        String stockCode = stockCodes.get(stockName.toLowerCase());
        String responseBody = buildUrlResponse(stockCode);
        JSONObject jsonObj = new JSONObject(responseBody);
        double c = jsonObj.getDouble("c");
        double d = jsonObj.getDouble("d");
        double dp = jsonObj.getDouble("dp");
        double h = jsonObj.getDouble("h");
        double l = jsonObj.getDouble("l");
        double o = jsonObj.getDouble("o");
        double pc = jsonObj.getDouble("pc");
        return new double[] {c, d, dp, h, l, o, pc};
    }

}