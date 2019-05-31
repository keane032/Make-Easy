package br.com.ufc.mkix.UI.Activitys;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.Cliente;
import br.com.ufc.mkix.model.Contato;
import br.com.ufc.mkix.model.Issue;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.enums.Categoria;
import de.hdodenhof.circleimageview.CircleImageView;

public class ClienteActivity extends Activity {

    private static int RESULT_LOAD_IMAGE = 1;
    EditText nome;
    EditText sobrenome;
    EditText email;
    EditText cpf;
    EditText senha;
    CircleImageView circleImageView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ArrayList<Trabalhador> clientes =  new ArrayList<Trabalhador>();

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_clientes);

        this.isStoragePermissionGranted();
        circleImageView = findViewById(R.id.profile_image);
        nome = (EditText) findViewById(R.id.editTextNome);
        sobrenome = (EditText) findViewById(R.id.editTextSNome);
        email = (EditText) findViewById(R.id.editTextEmail);
        cpf = (EditText) findViewById(R.id.editTextCpf);
        senha = (EditText) findViewById(R.id.editTextSenha);
        mDatabase = database.getInstance().getReference().child("clientes");
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK, android.provider
                        .MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

    }


    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("permission","Permission is granted");
                return true;
            } else {
                Log.v("permission","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("permission","Permission is granted");
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);

            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap image = BitmapFactory.decodeFile(picturePath);

            circleImageView.setImageBitmap(image);

        }

    }

    public void cadastrarCliente(View view){

        String snome = nome.getText().toString();
        String ssobrenome = sobrenome.getText().toString();
        String semail = email.getText().toString();
        String scpf = cpf.getText().toString();
        String ssenha = senha.getText().toString();

        if(snome.length() == 0){
            nome.setError("Insira um nome");
        }
        else if(ssobrenome.length() == 0){
            sobrenome.setError("Insira um sobreNome");
        } else if (semail.length() == 0){
            email.setError("insira um email");
        } else if (scpf.length() == 0 ||  scpf.length() != 11){
            cpf.setError("Insira um cpf");
        } else if (ssenha.length() == 0 ){
            senha.setError("Insira uma senha");
        }else{
            String id = mDatabase.push().getKey();
            Cliente cliente = new Cliente(id, snome, ssobrenome, semail, ssenha, scpf);
            mDatabase.child(id).setValue(cliente);
            Toast.makeText(ClienteActivity.this, "usuario cadastrado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
        //        List<Contato> contatos = new ArrayList<>();
//        contatos.add(new Contato("8889898989","Tim"));
//        contatos.add(new Contato("8889898989","Oi"));

//        List<Categoria> categorias = new ArrayList<>();
//        categorias.add(Categoria.CARPINTEIRO);
//        categorias.add(Categoria.ELETRICISTA);
//        categorias.add(Categoria.COZINHA);
//
//        clientes.add(new Trabalhador(1L,snome,ssobrenome,semail,ssenha,new LatLng(-4.980706, -39.021918)
//                ,scpf,contatos, categorias,"Olá, quero lhe ajudar", R.drawable.image));


    }

}
