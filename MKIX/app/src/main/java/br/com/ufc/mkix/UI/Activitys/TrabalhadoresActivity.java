package br.com.ufc.mkix.UI.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.UI.Activitys.adapters.RVTrabalhadorAdapter;

public class TrabalhadoresActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhadores);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_trabalhadores);
        RVTrabalhadorAdapter RVAdapter = new RVTrabalhadorAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(RVAdapter);
    }

    public void onClickGetPosition(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
