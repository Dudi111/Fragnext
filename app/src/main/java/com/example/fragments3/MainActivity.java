package com.example.fragments3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mbtnAdddA;
    private Button mbtnAddb;
    private Button mbtnremoveA;
    private Button mbtnremoveB;
    private Button mbtnreplaceA;
    private Button mbtnreplaceB;
    private Button mbtnreplaceAwithBwithbackstack;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        fragmentManager=getSupportFragmentManager();
    }
    private void initview() {
        mbtnAdddA = findViewById(R.id.btnAddA);
        mbtnAddb = findViewById(R.id.btnAddB);
        mbtnremoveA = findViewById(R.id.btnRemoveA);
        mbtnremoveB = findViewById(R.id.btnRemoveB);
        mbtnreplaceA = findViewById(R.id.btnReplaceAWithB);
        mbtnreplaceB = findViewById(R.id.btnReplaceBWithA);
        mbtnreplaceAwithBwithbackstack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mbtnAdddA.setOnClickListener(this);
        mbtnAddb.setOnClickListener(this);
        mbtnremoveA.setOnClickListener(this);
        mbtnremoveB.setOnClickListener(this);
        mbtnreplaceA.setOnClickListener(this);
        mbtnreplaceB.setOnClickListener(this);
        mbtnreplaceAwithBwithbackstack.setOnClickListener(this);
    }

    private void AddA(){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentA fragmentA=new FragmentA();
        transaction.add(R.id.flContainer,fragmentA,"FragmentA").commit();
    }
    private void replaceBwithA(){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentA fragmentA=new FragmentA();
        transaction.replace(R.id.flContainer,fragmentA,"FragmentA").commit();

    }
    private void removeA(){
        FragmentA fragmentA= (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
        if(fragmentA!=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.remove(fragmentA).commit();
        }
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btnAddA:
                AddA();
                break;
            case R.id.btnAddB:
                AddB();
                break;
            case R.id.btnRemoveA:
                removeA();

                break;
            case R.id.btnRemoveB:
                removeB();

                break;
            case R.id.btnReplaceAWithB:
                replaceAwithB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBwithA();
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAwithBwithbackstack();
                break;
        }

    }

    private void replaceAwithBwithbackstack() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentB fragmentB=new FragmentB();
        transaction.replace(R.id.flContainer,fragmentB,"FragmentB").addToBackStack("").commit();

    }

    private void removeB() {
        FragmentB fragmentB= (FragmentB) fragmentManager.findFragmentByTag("FragmentB");
        if(fragmentB!=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.remove(fragmentB).commit();
        }
    }

    private void replaceAwithB() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentB fragmentB=new FragmentB();
        transaction.replace(R.id.flContainer,fragmentB,"FragmentB").commit();

    }

    private void AddB() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentB fragmentB=new FragmentB();
        transaction.add(R.id.flContainer,fragmentB,"FragmentB").commit();
    }
}
