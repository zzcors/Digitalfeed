package fg.mdp.cpf.digitalfeed.screen;

/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mdp.core.screen.ScreenFragment;
import com.mdp.core.util.PopupUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import fg.mdp.cpf.digitalfeed.R;

import android.util.Log;

/**
 * Created by zzcors on 6/14/2017 AD.
 */

public class LoginScreen extends ScreenFragment implements View.OnClickListener {
    View rootview;
    @BindView(R.id.password)
    EditText _passwordText;
    @BindView(R.id.loginbt)
    Button _loginButton;
    @BindView(R.id.user)
    EditText _user ;
    static final String TAG = LoginScreen.class.getName();

    @Override
    public View onCreateScreen(Bundle savedInstanceState) {
        rootview = InflateView(R.layout.screen_login);
        if (rootview != null) {
            ButterKnife.bind(this, rootview);
            setValue();
        }

        return rootview;
    }


    public void login(EditText _emailText, EditText _passwordText) {
        Log.d(TAG, "Login");

        if (!validate(_emailText, _passwordText)) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);
    }


    public void onLoginFailed() {
        PopupUtil.AlertMessage(getContext(), "Login failed");
        Log.d (TAG , "onlogin fail");
        _loginButton.setEnabled(true);
    }

    public boolean validate(EditText _emailText,EditText _passwordText) {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        Log.d("email", email);
        Log.d("password", password);
        if (email.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            PopupUtil.AlertMessage(getContext(),getContext().getResources().getString(R.string.email_error) );
            valid=false;
        }
        else _emailText.setError(null);
        if (email.isEmpty()){
            PopupUtil.AlertMessage(getContext(),getContext().getResources().getString(R.string.password_error));
            valid = false;
        }
        else _passwordText.setError(null);

        return valid;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginbt:
                final EditText textemail = _user;
                final EditText textpw = _passwordText;
                boolean valid = validate(textemail, textpw);
                if (valid == true){
                    ReplaceScreen(new PINScreen());
                }

                else {
                    onLoginFailed();
                }

                break;
        }
    }

    public void setValue() {
        _loginButton.setOnClickListener(this);
    }
}