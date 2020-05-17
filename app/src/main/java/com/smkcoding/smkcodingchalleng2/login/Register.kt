package com.smkcoding.smkcodingchalleng2.login

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.smkcoding.smkcodingchalleng2.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnDaftar.setOnClickListener {Register()}
    }

    private fun Register(){
        val email = DaftarEmail.text.toString()
        val password = DaftarPassword.text.toString()

        val progressDialog = ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)

        if (email.isEmpty()|| password.isEmpty()) {
            Toast.makeText(this, "Tolong Masukan Email Dan Password", Toast.LENGTH_SHORT).show()

        }else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener{

                    if (!it.isSuccessful){ return@addOnCompleteListener
                        val intent = Intent (this, Register::class.java)
                        startActivity(intent)
                    }
                    else {

                        Toast.makeText(this, "Berhasil Daftar", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                    }
                }
                .addOnFailureListener{
                    Log.d("Main", "Failed Login: ${it.message}")
                    Toast.makeText(this, "Email Sudah Ada", Toast.LENGTH_SHORT).show()
                    progressDialog.hide()

                }
        }
    }
}
