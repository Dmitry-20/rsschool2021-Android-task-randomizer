package com.rsschool.android2021;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity<previousNumber> extends AppCompatActivity implements SwitchFragment{


    private Object previousNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFirstFragment(0);
        getSupportActionBar().hide();
    }

    private void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment).commit();
        // TODO: invoke function which apply changes of the transaction
    }

    private void openSecondFragment(int min, int max) {
        final Fragment secondFragment = SecondFragment.newInstance(min, max);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, secondFragment).commit();
        // TODO: implement it
    }
    @Override
    public void switchToFirstFragment(int previousNumber) {
        openFirstFragment(previousNumber);
    }
    @Override
    public void switchToSecondFragment(int min, int max) {
        openSecondFragment(min, max);
    }

}

