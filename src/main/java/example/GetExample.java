package example;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A minimal example of making an API call that requires no additional parameters.
 */
public class GetExample {
    private final OkHttpClient client = new OkHttpClient();

    /**
     * Make an API call to the specified URL and return the result.
     * @param url the URL to query
     * @return the response as a String
     * @throws IOException if there is a problem connecting to the API
     */
    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * Make an API call to the specified URL with the given extra parameter key-value pair
     * and return the result.
     * @param baseURL the URL to query
     * @param paramKey the name for the extra parameter
     * @param paramValue the value for the extra parameter
     * @return the response as a String
     * @throws IOException if there is a problem connecting to the API
     */
    public String run(String baseURL, String paramKey, String paramValue) throws IOException {
        HttpUrl url = HttpUrl.parse(baseURL).newBuilder()
                .addQueryParameter(paramKey, paramValue)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader(paramKey, paramValue)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * Sample main method demonstrating calling the meowfacts API.
     * @param args not used
     * @throws IOException if the run method fails
     */
    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
        String response = example.run("https://meowfacts.herokuapp.com");
        System.out.println(response);

        response = example.run("https://meowfacts.herokuapp.com", "count", "5");
        System.out.println(response);
    }
}
