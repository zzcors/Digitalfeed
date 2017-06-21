package fg.mdp.cpf.digitalfeed.connections;

/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

import android.os.StrictMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zzcors on 6/14/2017 AD.
 */

public class Connections {

    public static void initStrictMode() {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public static final MediaType JSON
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    static OkHttpClient client = new OkHttpClient();

    private static String post(String url, RequestBody body) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String doLogin(String username, String password) {
        String URL = ConProperties.URL + "authentication/login";
        FormBody.Builder formBuilder = new FormBody.Builder();

        String device = "abc";
        String token_id = "12wsx";
        String response = "";
        try {
//            jsonLogin.put("email", username);
//            jsonLogin.put("password", password);
//            jsonLogin.put("device", device );
//            jsonLogin.put("token_id",token_id);
            formBuilder.add("email", username);
            formBuilder.add("password", password);
            formBuilder.add("device", device);
            formBuilder.add("token_id", token_id);

            RequestBody formBody = formBuilder.build();
            response = post(URL, formBody);
//        } catch (JSONException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}
