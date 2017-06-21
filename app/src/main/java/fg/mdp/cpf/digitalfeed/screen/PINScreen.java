package fg.mdp.cpf.digitalfeed.screen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mdp.core.screen.ScreenFragment;
import fg.mdp.cpf.digitalfeed.R;


/**
 * Created by mdc_macbook on 6/15/2017 AD.
 */

public class PINScreen extends ScreenFragment {

    View rootView ;
    String TAG = "ScreenLogin" ;

    public PINScreen(){}

    @Override
    public View onCreateScreen(Bundle savedInstanceState) {
        Log.d(TAG , "on pin page") ;
        rootView = InflateView(R.layout.screen_pin_enterpw);
        if(rootView != null){
            setCurrentView(rootView);
        }
        return rootView ;
    }
}
