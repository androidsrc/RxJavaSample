package net.androidsrc.rxjava;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import net.androidsrc.rxjava.fragment.MainFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new MainFragment(), this.toString())
                    .commit();
        }
    }
}
