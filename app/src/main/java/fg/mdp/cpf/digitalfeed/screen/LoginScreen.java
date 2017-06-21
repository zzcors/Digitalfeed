package fg.mdp.cpf.digitalfeed.screen;

/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONObject;

import com.github.orangegangsters.lollipin.lib.managers.AppLock;

import com.mdp.core.screen.ScreenFragment;
import com.mdp.core.system.systemInfo;
import com.mdp.core.util.PopupUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import fg.mdp.cpf.digitalfeed.R;
import fg.mdp.cpf.digitalfeed.activity.CustomPinActivity;
import fg.mdp.cpf.digitalfeed.activity.MainActivity;
import fg.mdp.cpf.digitalfeed.connections.Connections;

import android.util.Log;

import java.util.Objects;

/**
 * Created by zzcors on 6/14/2017 AD.
 */

public class LoginScreen extends ScreenFragment implements View.OnClickListener {
    View rootview;
    EditText _passwordText;
    Button _loginButton;
    EditText _user;
    static final String TAG = LoginScreen.class.getName();

    int REQUEST_CODE_ENABLE = 11;

    @Override
    public View onCreateScreen(Bundle savedInstanceState) {
        rootview = InflateView(R.layout.screen_login);
        if (rootview != null) {
            ButterKnife.bind(this, rootview);
            _passwordText = (EditText) rootview.findViewById(R.id.password);
            _user = (EditText) rootview.findViewById(R.id.user);
            _loginButton = (Button) rootview.findViewById(R.id.loginbt);

        }

        _loginButton.setOnClickListener(this);

        return rootview;
    }


//    public void login(EditText _emailText, EditText _passwordText) {
//        Log.d(TAG, "Login");
//
//        if (!validate(_emailText, _passwordText)) {
//            onLoginFailed();
//            return;
//        }
//
//        _loginButton.setEnabled(false);
//    }


    public void onLoginFailed() {
        PopupUtil.AlertMessage(getContext(), "Login failed");
        Log.d(TAG, "onlogin fail");
        _loginButton.setEnabled(true);
    }

    public boolean validate(EditText _emailText, EditText _passwordText) {
        boolean valid = false;
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        Log.d("test", "email :" + email);
        Log.d("test", "password : " + password);

        if (!email.equals("") && !password.equals("")) {
            Log.d("test", "not empty");
            JSONObject json;
            try {
                String rep = Connections.doLogin(email.trim(), password.trim());
                //don't forget to change rep to json
                json = new JSONObject(rep);
                Log.d("test", "rep :" + rep.toString());
                JSONObject HeadObject = json.getJSONObject("HEAD");
                Log.d("test", "HeadObject :" + HeadObject.toString());
                int errorcode = HeadObject.getInt("error_code");
                String errorflag = HeadObject.getString("error_flag");
                Log.d("test", "errorcode :" + errorcode);
            Log.d("test", "call json");
                if (errorcode == 0 && errorflag.equals("N")) {
                    valid = true;
                    Log.d("test", "connect success");
                } else {
                    valid = false;
                    Log.d("test", "connect fail");
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("test", "connect error");
            }

        }
        else {
            PopupUtil.AlertMessage(getContext(), getContext().getResources().getString(R.string.login_error));
            valid = false;
            Log.d("test", "empty edt");


        }
        return valid;
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginbt:
                final EditText textemail = _user;
                final EditText textpw = _passwordText;
                boolean valid = validate(textemail, textpw);
                Log.d("test", "valid : " + valid);
                if (valid) {
                    Log.d("test", "check valid");
                    Intent myIntent = new Intent(systemInfo.getMainActivity(), CustomPinActivity.class);
                    myIntent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
                    startActivityForResult(myIntent, REQUEST_CODE_ENABLE);
                    systemInfo.getMainActivity().startActivity(myIntent);
//                    ReplaceScreen(new PINScreen());
                } else {
                    Log.d("test", "check valid fail");
                    onLoginFailed();
                }


                break;
        }
    }

}