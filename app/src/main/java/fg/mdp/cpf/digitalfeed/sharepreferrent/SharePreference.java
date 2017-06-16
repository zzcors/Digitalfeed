package fg.mdp.cpf.digitalfeed.sharepreferrent;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;

/**
 * Created by mdc_macbook on 6/16/2017 AD.
 */

public class SharePreference {
    private static SharedPreferences sp ;
    private SharedPreferences.Editor spEditor;
    private Context context;
    private final String preferenceName = "SharePreference";
    private HashMap<String, Boolean> favHashMap = new HashMap<>();
    String _pinpw ="pinpw";
    public SharePreference(Context _context) {
        this.context = _context;

    }
    public void createSharePreference() {
        sp = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }
    public void createSharePreference(String preferenceName) { //FavoriteSick
        sp = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }
    public void setPIN(String pinpw){
        spEditor.putString(_pinpw, pinpw);
        spEditor.commit();
    }
    public String getPIN() {
        return sp.getString(_pinpw, "");
    }
    public void clearPIN() {
        spEditor.remove(_pinpw);
        spEditor.commit();
    }





}
