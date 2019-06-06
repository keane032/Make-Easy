package br.com.ufc.mkix.UI.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.UI.adapters.Sobre;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.navigation_about){
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
