package fg.mdp.cpf.digitalfeed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.github.orangegangsters.lollipin.lib.managers.AppLock;
import com.github.orangegangsters.lollipin.lib.managers.AppLockActivity;

import fg.mdp.cpf.digitalfeed.R;

public class CustomPinActivity extends AppLockActivity {
    @Override
    public void showForgotDialog() {

    }

    @Override
    public void onPinFailure(int attempts) {
        Log.d("main" , "fail : " + attempts );
    }

    @Override
    public void onPinSuccess(int attempts) {
        Log.d("main" , "success : " + attempts );
        Intent intent = new Intent(CustomPinActivity.this, MainActivity.class);
        intent.putExtra("Pin", 1);
        startActivity(intent);
    }
    @Override
    public int getPinLength() {
        return super.getPinLength();//you can override this method to change the pin length from the default 4
    }

    @Override
    public int getContentView() {
        return R.layout.screen_pin_enterpw ;
    }

    @Override
    public String getStepText(int reason) {
        String msg = null;
        switch (reason) {
            case AppLock.DISABLE_PINLOCK:
                msg = getString(com.github.orangegangsters.lollipin.lib.R.string.pin_code_step_disable, this.getPinLength());
                break;
            case AppLock.ENABLE_PINLOCK:
                msg = "Please enter your password" ;
                break;
            case AppLock.CHANGE_PIN:
                msg = getString(com.github.orangegangsters.lollipin.lib.R.string.pin_code_step_change, this.getPinLength());
                break;
            case AppLock.UNLOCK_PIN:
                msg = getString(com.github.orangegangsters.lollipin.lib.R.string.pin_code_step_unlock, this.getPinLength());
                break;
            case AppLock.CONFIRM_PIN:
                msg = "Please confirm your password";
                break;
        }
        return msg;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mForgotTextView.setVisibility(View.GONE);
        mForgotTextView.setText("Are you forget your password?");
    }
}
