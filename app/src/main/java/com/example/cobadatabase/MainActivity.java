package com.example.cobadatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cobadatabase.model.Requests;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private DatabaseReference database;
    private EditText editTextUsername, editTextemail, editTextStatus;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        database = FirebaseDatabase.getInstance().getReference();

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextemail = findViewById(R.id.editTextEmail);
        editTextStatus = findViewById(R.id.editTextStatus);

        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Susername = editTextUsername.getText().toString();
                String Semail = editTextemail.getText().toString();
                String Sstatus = editTextStatus.getText().toString();

                if (Susername.equals("")) {
                    editTextUsername.setError("Username Harap Diisi..");
                    editTextUsername.requestFocus();
                } else if (Semail.equals("")) {
                    editTextemail.setError("Email Harap Diisi..");
                    editTextemail.requestFocus();
                } else if (Sstatus.equals("")) {
                    editTextStatus.setError("Mohon Masukkan Status anda JOMBLO/BERPASANGAN ? ");
                } else {
                    dialog = ProgressDialog.show(MainActivity.this,
                            null,
                            "Mohon Ditunggu . . .",
                            true,
                            false);

                    submitUser(new Requests(
                            Susername.toLowerCase(),
                            Semail.toLowerCase(),
                            Sstatus.toLowerCase()
                    ));
                }
            }
        });
    }

    private void submitUser(Requests request) {
        database.child("User")
                .child("ozan")
                .child("zaaan")
//                .push()
                .setValue(request)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dialog.dismiss();

                        editTextUsername.setText("");
                        editTextemail.setText("");
                        editTextStatus.setText("");

                        Toast.makeText(MainActivity.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

