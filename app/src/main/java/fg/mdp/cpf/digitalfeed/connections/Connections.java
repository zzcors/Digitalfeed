package fg.mdp.cpf.digitalfeed.connections;

/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zzcors on 6/14/2017 AD.
 */

public class Connections {


    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    static OkHttpClient client = new OkHttpClient();

    private static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String doLogin(String username, String password) {
        String URL = ConProperties.URL + "product_manager/get_brand_and_unit";
        JSONObject jsonLogin = new JSONObject();
        String response = "";
        try {
            jsonLogin.put("USERNAME", username);
            jsonLogin.put("PASSWORD", password);
            response = post(URL, jsonLogin.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}
