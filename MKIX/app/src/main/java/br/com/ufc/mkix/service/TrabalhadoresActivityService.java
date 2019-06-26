package br.com.ufc.mkix.service;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.mkix.R;
import br.com.ufc.mkix.model.Contato;
import br.com.ufc.mkix.model.LatLong;
import br.com.ufc.mkix.model.Trabalhador;
import br.com.ufc.mkix.model.Usuario;
import br.com.ufc.mkix.model.enums.Categoria;
import br.com.ufc.mkix.persistence.PersistenceUnit;
import com.google.android.gms.maps.model.LatLng;
public class TrabalhadoresActivityService {

    PersistenceUnit persistenceUnit;
    private List<Trabalhador> trabalhadores = new ArrayList<>();;
    DatabaseReference mDatabase;

    //Mocks
    private List<Trabalhador> initValues(){


        persistenceUnit = PersistenceUnit.getInstance();

//        mDatabase = PersistenceUnit.getInstance().getReference("trabalhadores");

        //TODO Substituir pelo firebase
        List<Trabalhador> teste = new ArrayList<Trabalhador>();
//
//        List<Contato> contatos = new ArrayList<>();
//        contatos.add(new Contato("8889898989","Tim"));
//        contatos.add(new Contato("8889898989","Oi"));
//
//        List<Categoria> categorias = new ArrayList<>();
//        categorias.add(Categoria.CARPINTEIRO);
//        categorias.add(Categoria.ELETRICISTA);
//        categorias.add(Categoria.COZINHA);
//
//      teste.add(new Trabalhador(1L,"Paulo",
//              "Oliveira","email@email.com",
//              "123qwe","Rua José de Queiroz Pessoa, 1693 - Centro, Quixadá - CE, 63900-221",
//              "",contatos, categorias,"Olá, quero lhe ajudar",
//              R.drawable.image));
//
//        List<Categoria> categorias2 = new ArrayList<>();
//        categorias2.add(Categoria.BABA);
//        categorias2.add(Categoria.COPEIRA);
//        categorias2.add(Categoria.COZINHA);
//        categorias2.add(Categoria.EMPREGADA);
//
//       teste.add(new Trabalhador(1L,"Lisa","Hofman","email@email.com",
//               "123qwe","Rua José de Queiroz Pessoa, 1693 - Centro, Quixadá - CE, 63900-221", "",contatos, categorias2,
//               "Olá, quero lhe ajudar", R.drawable.image__1_));
//
//        List<Categoria> categorias3 = new ArrayList<>();
//        categorias3.add(Categoria.DIARISTA);
//        categorias3.add(Categoria.LAVADEIRA);
//        categorias3.add(Categoria.GARCOM);
//
//
//        teste.add(new Trabalhador(1L,"Laura","Ferreira","email@email.com",
//                "123qwe","Rua José de Queiroz Pessoa, 1693 - Centro, Quixadá - CE, 63900-221",
//                "",contatos, categorias3,"Olá, quero lhe ajudar", R.drawable.image__2_));
//
//        List<Categoria> categorias4 = new ArrayList<>();
//        categorias4.add(Categoria.GARCOM);
//        categorias4.add(Categoria.EMPREGADA);
//        categorias4.add(Categoria.OUTRO);
////
////
//        teste.add(new Trabalhador(1L,"Isabella","Coutinho",
//                "email@email.com","123qwe","Rua José de Queiroz Pessoa, 1693 - Centro, Quixadá - CE, 63900-221","",contatos, categorias4,"Olá, quero lhe ajudar", R.drawable.image__3_));
//
//        List<Categoria> categorias5 = new ArrayList<>();
//        categorias5.add(Categoria.CARPINTEIRO);
//        categorias5.add(Categoria.MORDOMO);
//        categorias5.add(Categoria.GARCOM);
//        categorias5.add(Categoria.PISCINEIRO);
//
//
//        teste.add(new Trabalhador(1L,"Richard","Farias",
//                "email@email.com",
//                "123qwe","Rua José de Queiroz Pessoa, 1693 - Centro, Quixadá - CE," +
//                " 63900-221","",contatos,
//                categorias5,"Olá, quero lhe ajudar", R.drawable.image__4_));
//
//        List<Categoria> categorias6 = new ArrayList<>();
//        categorias6.add(Categoria.MORDOMO);
//        categorias6.add(Categoria.ELETRICISTA);
//        categorias6.add(Categoria.CHURRASQUEIRO);
//        categorias6.add(Categoria.LAVADEIRA);
//
//
//        teste.add(new Trabalhador(1L,"Arnaldo",
//                "dos Santos","email@email.com",
//                "123qwe",
//                "Rua José de Queiroz Pessoa, 1693 - Centro, Quixadá - CE, 63900-221",
//                "",contatos, categorias6,"Olá, quero lhe ajudar",
//                R.drawable.image__5_));


        return teste;
    }

    //Mock
    public List<Trabalhador> getTrabalhadoresByCategoria(String categoria){
        //TODO Substituir pelo firebase

         List<Trabalhador> trabalhadoresPorCategoria = new ArrayList<>();

        Log.d("wqqeqweqeqw",""+this.trabalhadores.get(0).getNome());
        return trabalhadores;
    }

    public Trabalhador getTrabalhadorByPosition(int position){
        return trabalhadores.get(position);
    }
}
