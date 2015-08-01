package messagingapp.mastermind.com.messagingapp;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Dip on 8/1/2015.
 */
public class ParseActivity extends Application {


    @Override
            public void onCreate()
    {
          super.onCreate();

        // Enable Local Datastore.

        Parse.initialize(this, "hQZb8F7sWpDoWucbwLsrxme0iEr2pzo3EopkoXcN", "nVhnBGGRFzaRvnVl2DQawT5LgIFEiV0OjaYJA1sp");

    }

}
