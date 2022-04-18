package net.maromo.androidfirebaseapp.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.maromo.androidfirebaseapp.R;
import net.maromo.androidfirebaseapp.model.Product;

import java.util.Objects;
import java.util.UUID;

public class ProductActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;

    EditText edt_product_description;
    EditText edt_product_price;
    CheckBox check_activate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        initializeFirebase();

        edt_product_description = findViewById(R.id.edt_product_description);
        edt_product_price = findViewById(R.id.edt_product_price);
        check_activate = findViewById(R.id.check_activate);
        Button btn_save = findViewById(R.id.btn_save);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_close = findViewById(R.id.btn_close);
        Product product = new Product();

        Intent intent = getIntent();
        if(intent.getExtras()!=null) {
            String _product_id = intent.getStringExtra("product_id");
            product.setProductId(_product_id);
            //recuperar no Firebase o campo atualizado
            databaseReference.child("Product").child(product.getProductId()).
                    addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            edt_product_description.setText(Objects.requireNonNull(snapshot.child("productName").getValue()).toString());
                            edt_product_price.setText(Objects.requireNonNull(snapshot.child("productPrice").getValue()).toString());
                            boolean isActivate = Boolean.parseBoolean(Objects.requireNonNull(snapshot.child("active").getValue()).toString());
                            check_activate.setChecked(isActivate);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(ProductActivity.this, "Erro: "  +
                                    error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(product.getProductId()==null) {
                    product.setProductId(UUID.randomUUID().toString());
                }
                product.setProductName(edt_product_description.getText().toString());
                product.setProductPrice(Double.parseDouble(edt_product_price.getText().toString()));
                product.setActive(check_activate.isChecked());
                databaseReference.child("Product").child(product.getProductId()).setValue(product);
                clearComponents();
                Toast.makeText(ProductActivity.this, "Registro Atualizado/Gravado com sucesso", Toast.LENGTH_SHORT).show();

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(product.getProductId()==null) {
                    Toast.makeText(ProductActivity.this, "Só é possível excluir registros existentes", Toast.LENGTH_LONG).show();
                }else{
                    //recuperar no Firebase o campo atualizado
                    databaseReference.child("Product").child(product.getProductId()).removeValue();
                    Toast.makeText(ProductActivity.this, "Registro excluído com sucesso", Toast.LENGTH_LONG).show();
                    clearComponents();
                }
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initializeFirebase() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    private void clearComponents() {
        edt_product_price.setText("");
        edt_product_description.setText("");
        check_activate.setChecked(false);
    }
}