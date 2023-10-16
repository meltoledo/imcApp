package br.edu.fatecjahu.imcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class DebugActivity extends AppCompatActivity {

    protected static final String TAG = "Marca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i(TAG, getClassName() + ".onCreate() chamado: " + savedInstanceState);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, getClassName() + ".onStart chamado.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getClassName() + ".onRestart() chamado.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getClassName() + "onResume() chamado.");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, getClassName() + ".onSaveInstanceState() chamado.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getClassName() + ".onStop() chamado.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getClassName() + ".onStop() chamado.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getClassName() + ".onDestroy() chamado.");
    }

    protected String getClassName() {
        //Retorna o nome da classe sem o pacote

        // s = "com.example.loginapp.MainActivity" ou
        // s = "com.example.login.app.BemVindoActivity"
        String s = getClass().getName();
        // retorna somente s = ".MainActivity" ou
        // retorna somente s = ".BemVindoActivity"
        return s.substring(s.lastIndexOf("."));
    }

    public void onBackPressed(){
        super.onBackPressed();
        Log.i(TAG, getClassName() + "onBackPressed() chamado.");
    }


}