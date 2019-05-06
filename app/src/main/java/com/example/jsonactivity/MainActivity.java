package com.example.jsonactivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IGnomoListener {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment;
        fragment=ListaFragment.newInstance();
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace( R.id.fragment_container, fragment);
        transaction.commit();
    }
    @Override
    public void onGnomoClickListener(Gnomo gnomo) {
        Fragment fragment;
        fragment = GnomoFragment.newInstance(gnomo);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .addToBackStack(GnomoFragment.class.getName())
                .commit();

    }
}
