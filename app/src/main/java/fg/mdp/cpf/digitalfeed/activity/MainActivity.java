package fg.mdp.cpf.digitalfeed.activity;

/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.orangegangsters.lollipin.lib.managers.AppLock;
import com.mdp.core.activity.AppCompatCore;
import com.mdp.core.executor.LogicThread;
import com.mdp.core.system.systemInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import fg.mdp.cpf.digitalfeed.R;
import fg.mdp.cpf.digitalfeed.connections.Connections;
import fg.mdp.cpf.digitalfeed.screen.LoginScreen;
import fg.mdp.cpf.digitalfeed.screen.PINScreen;


public class MainActivity extends AppCompatCore {

    TextView btn;
    int pin;
    int REQUEST_CODE_ENABLE = 11 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMainFragmentID(R.id.main_screen);
        systemInfo.setMainActivity(this);
        systemInfo.setLogicThread(new LogicThread(this));
        ButterKnife.bind(MainActivity.this);
        Bundle bundle = getIntent().getExtras();
        Connections.initStrictMode();
        if (bundle != null) {
            if (bundle.getInt("Pin") == 1) {

                setInsideContent();

            } else {
                setLoginContent();
            }
        }else {
            setLoginContent();
        }

    }
    public void setLoginContent() {

        systemInfo.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                ReplaceFragment(new LoginScreen());

            }
        });
    }
    public void setInsideContent() {
        setContentView(R.layout.activity_main);
        setMainFragmentID(R.id.activity_main);
        ReplaceFragment(new PINScreen());
    }


}