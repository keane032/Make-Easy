package br.com.ufc.mkix.UI.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.UI.Activitys.ClienteActivity;
import br.com.ufc.mkix.UI.Activitys.Home;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void logar(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void cadastrar(View view){
        Intent intent = new Intent(this, ClienteActivity.class);
        startActivity(intent);
    }


}
