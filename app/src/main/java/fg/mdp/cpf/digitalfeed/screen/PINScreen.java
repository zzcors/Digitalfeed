package fg.mdp.cpf.digitalfeed.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mdp.core.screen.ScreenFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import fg.mdp.cpf.digitalfeed.R;
import android.content.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.app.Activity;
import android.widget.EditText;

/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

public class PINScreen extends ScreenFragment implements View.OnClickListener {
    View rootview;
    @BindView(R.id.bt0)
    Button btn0;
    @BindView(R.id.bt1)
    Button btn1;
    @BindView(R.id.bt2)
    Button btn2;
    @BindView(R.id.bt3)
    Button btn3;
    @BindView(R.id.bt4)
    Button btn4;
    @BindView(R.id.bt5)
    Button btn5;
    @BindView(R.id.bt6)
    Button btn6;
    @BindView(R.id.bt7)
    Button btn7;
    @BindView(R.id.bt8)
    Button btn8;
    @BindView(R.id.bt9)
    Button btn9;
    @BindView(R.id.backspace)
    Button btnbackspace;
    public View onCreateScreen(Bundle savedInstanceState) {
        rootview = InflateView(R.layout.screen_pin_enterpw);

        if (rootview != null) {
            ButterKnife.bind(this, rootview);
//            setValue();
        }

        return rootview;
    }

    public void getPIN(String p){
        int cnt = 0;
        String pin1 = "";
        String pin2 = "";
        while(cnt<8){
            if(cnt<=3){
                pin1 = pin1 + p;
            }
            else  if(cnt==3){

            }
            else if(cnt >3&& cnt <=7){
                pin2 = pin2 + p;
            }
            cnt++;
        }
        if(checkPIN(pin1,pin2)==true){
            ReplaceScreen(new PINScreen());
        }

    }

    public boolean checkPIN(String pin1,String pin2){
        if (pin1==pin2){
//            ReplaceScreen(new PINScreen());
            return true;
        }
        else
            return false;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt0:
                getPIN("0");
                break;
            case R.id.bt1:
                getPIN("1");
                break;
            case R.id.bt2:
                getPIN("2");
                break;
            case R.id.bt3:
                getPIN("3");
                break;
            case R.id.bt4:
                getPIN("4");
                break;
            case R.id.bt5:
                getPIN("5");
                break;
            case R.id.bt6:
                getPIN("6");
                break;
            case R.id.bt7:
                getPIN("7");
                break;
            case R.id.bt8:
                getPIN("8");
                break;
            case R.id.bt9:
                getPIN("9");
                break;
        }
    }


}
