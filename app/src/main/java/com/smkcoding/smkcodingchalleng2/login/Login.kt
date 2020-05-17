package com.smkcoding.smkcodingchalleng2.login

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.smkcoding.smkcodingchalleng2.MainActivity
import com.smkcoding.smkcodingchalleng2.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false
    private lateinit var auth: FirebaseAuth//
    private var fStateListener: AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        CekLogin()

        btnLogin.setOnClickListener {AksiLogin()}
        btnRegister.setOnClickListener {Register()}
    }

    private  fun CekLogin() {

        auth = FirebaseAuth.getInstance()
        fStateListener =  FirebaseAuth.AuthStateListener(){
                   val user = auth.currentUser
            if (user != null) {
                // User sedang login
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // User sedang logout
                Log.d("alsd", "onAuthStateChanged:signed_out");
            }
        }

    }

    private  fun Register(){

        val intent = Intent(this, Register::class.java)
        startActivity(intent)

    }


    private fun AksiLogin(){
        val email = inputEmail.text.toString()
        val password = inputPassword.text.toString()

        val progressDialog = ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)

        if (email.isEmpty()|| password.isEmpty()) {
            Toast.makeText(this, "Tolong Masukan Email Dan Password", Toast.LENGTH_SHORT).show()

        }else{

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{

                if (!it.isSuccessful){ return@addOnCompleteListener
                    val intent = Intent (this, Login::class.java)
                    startActivity(intent)
                }
                else {

                    Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            .addOnFailureListener{
                Log.d("Main", "Failed Login: ${it.message}")
                Toast.makeText(this, "Email/Password Salah", Toast.LENGTH_SHORT).show()
                progressDialog.hide()

            }
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed()
//            return
            finish();
            System.exit(0);
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Back Dua Kali Untuk Keluar Aplikasi", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }

    public override fun onStart() {
        super.onStart();
        auth.addAuthStateListener(fStateListener!!)
    }
    override fun onStop() {
        super.onStop()
        if (fStateListener != null) {
            auth.removeAuthStateListener(fStateListener!!)
        }
    }
}
