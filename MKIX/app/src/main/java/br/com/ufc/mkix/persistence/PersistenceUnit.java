package br.com.ufc.mkix.persistence;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/***
 * Essa classe implementa o padrão de projeto Singleton
 * para possuir somente uma instância de conexão com o fb
 */
public class PersistenceUnit extends Application {

    private static PersistenceUnit persistenceUnit;

    private final FirebaseDatabase firebaseDatabase;

    private PersistenceUnit(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
    }

    public static synchronized PersistenceUnit getInstance(){
        if (persistenceUnit == null){
            persistenceUnit = new PersistenceUnit();
        }

        return persistenceUnit;
    }

    public DatabaseReference getReference(){
        return firebaseDatabase.getReference();
    }

    public DatabaseReference getReference(String ref){
        return firebaseDatabase.getReference(ref);
    }

}
