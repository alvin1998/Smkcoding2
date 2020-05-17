package com.smkcoding.smkcodingchalleng2.profil
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.login.Login
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_profil.*

class ProfilFragment : Fragment() {
    private lateinit var auth: FirebaseAuth//
    private var fStateListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CekLogin()
        btnLogout.setOnClickListener {Keluar()}
    }

    private fun Keluar(){
        FirebaseAuth.getInstance().signOut()
        val intent = Intent (context, Login::class.java)
        startActivity(intent)

    }



    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

    private  fun CekLogin() {

        auth = FirebaseAuth.getInstance()
        fStateListener =  FirebaseAuth.AuthStateListener(){
            val user = auth.currentUser
            if (user != null) {
                Log.d("alsd", "User : Masuk");
            } else {
                // User sedang logout
                Log.d("alsd", "User : Keluar");
                val intent = Intent (context, Login::class.java)
                startActivity(intent)

            }
        }

    }


     override fun onStart() {
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