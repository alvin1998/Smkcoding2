package com.smkcoding.smkcodingchalleng2.home_tampil


import HomeAdapter
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.donor_darah.DonorDarahFragment
import com.smkcoding.smkcodingchalleng2.islam.HidupFragment
import com.smkcoding.smkcodingchalleng2.login.Login
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth//
    private var fStateListener: FirebaseAuth.AuthStateListener? = null
    lateinit var listTeman : ArrayList<Home_img>
    private fun data_gambar() {
        // Hopefully your alarm will have a lower frequency than this!
            listTeman = ArrayList()
            listTeman.add(Home_img("https://covid19.mathdro.id/api/og"))

    }
    private fun tampilTeman() {
        listfoto.layoutManager = LinearLayoutManager(activity)
        listfoto.adapter = HomeAdapter(activity!!, listTeman)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CekLogin()
        initView()
        hidup_sehat.setOnClickListener { goToSehatFragmnet() }
        donor_darah.setOnClickListener { goToDonorDarah() }

    }
    private fun goToSehatFragmnet() {

          val intent = Intent(this.context, HidupFragment::class.java)
          startActivity(intent)
//         Log.d("polo123","asas")
//        return inflater.inflate(R.layout.fragment_github, container, false)
                }
    private fun goToDonorDarah() {

        val intent = Intent(this.context, DonorDarahFragment::class.java)
        startActivity(intent)
//         Log.d("polo123","asas")
//        return inflater.inflate(R.layout.fragment_github, container, false)
    }


    private fun initView() {
        data_gambar()
        tampilTeman()
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