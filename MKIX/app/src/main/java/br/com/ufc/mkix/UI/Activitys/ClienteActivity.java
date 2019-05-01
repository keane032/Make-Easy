package br.com.ufc.mkix.UI.Activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ufc.mkix.R;

public class ClienteActivity extends Activity {

    EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_clientes);


        nome = (EditText) findViewById(R.id.editTextNome);

    }


    public void cadastrarCliente(View view){

        String snome = nome.getText().toString();
        Toast.makeText(ClienteActivity.this, snome, Toast.LENGTH_SHORT).show();

    }

}
