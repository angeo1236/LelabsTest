package com.lelabs.testapplication.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.lelabs.testapplication.R;
import com.lelabs.testapplication.view.fragment.UserListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        replaceFragment(UserListFragment.newInstance());
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_layout, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
