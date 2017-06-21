package fg.mdp.cpf.digitalfeed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.orangegangsters.lollipin.lib.PinActivity;
import com.github.orangegangsters.lollipin.lib.managers.AppLock;

/**
 * Created by mdc_macbook on 6/19/2017 AD.
 */

public class PinAct extends PinActivity {

    String TAG = "main";
    int REQUEST_CODE_ENABLE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "on create");
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(PinAct.this, CustomPinActivity.class);
        intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
        startActivityForResult(intent, REQUEST_CODE_ENABLE);
        Log.d(TAG, "click to pin");
    }
}