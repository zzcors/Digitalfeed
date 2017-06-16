package fg.mdp.cpf.digitalfeed.activity;

/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import com.mdp.core.activity.AppCompatCore;
import com.mdp.core.executor.LogicThread;
import com.mdp.core.system.systemInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import fg.mdp.cpf.digitalfeed.R;
import fg.mdp.cpf.digitalfeed.screen.LoginScreen;


public class MainActivity extends AppCompatCore {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMainFragmentID(R.id.main_screen);
        systemInfo.setMainActivity(this);
        systemInfo.setLogicThread(new LogicThread(this));
        ButterKnife.bind(MainActivity.this);
        systemInfo.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                ReplaceFragment(new LoginScreen());

            }
        });


    }


}