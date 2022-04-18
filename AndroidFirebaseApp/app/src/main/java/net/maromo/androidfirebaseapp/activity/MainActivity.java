package net.maromo.androidfirebaseapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.maromo.androidfirebaseapp.R;
import net.maromo.androidfirebaseapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    private ListView list;
    private List<Product> listProducts = new ArrayList<>();
    private ArrayAdapter<Product>arrayAdapterProduct;

    Product productSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_logout = findViewById(R.id.btn_logout);
        Button btn_add = findViewById(R.id.btn_add);
        list = findViewById(R.id.list);

        //Inicializando firebase
        initializeFirebase();

        //atualizando o grid de produtos
        updateGrid();


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                productSelected = (Product)parent.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                intent.putExtra("product_id", productSelected.getProductId());
                startActivity(intent);
            }
        });
    }

    private void updateGrid() {
        databaseReference.child("Product").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listProducts.clear();
                for(DataSnapshot objSnapshot: snapshot.getChildren()){
                    Product product = objSnapshot.getValue(Product.class);
                    listProducts.add(product);
                }
                arrayAdapterProduct = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, listProducts);
                list.setAdapter(arrayAdapterProduct);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initializeFirebase() {
        //iniciando autenticação
        mAuth = FirebaseAuth.getInstance();
        //iniciando realtime database
        FirebaseApp.initializeApp(MainActivity.this);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();

    }


    @Override
    protected void onStart() {
    super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null){
           Intent intent = new Intent(MainActivity.this, LoginActivity.class);
           startActivity(intent);
           finish();
       }

    }
}