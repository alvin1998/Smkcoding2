package com.smkcoding.smkcodingchalleng2
import GithubUserAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.smkcoding.smkcodingchalleng2.data.*
import com.smkcoding.smkcodingchalleng2.data_covid.CovidItem
import com.smkcoding.smkcodingchalleng2.login.Login
import com.smkcoding.smkcodingchalleng2.util.dismissLoading
import com.smkcoding.smkcodingchalleng2.util.showLoading
import com.smkcoding.smkcodingchalleng2.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_github.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_github, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CekLogin()
        callApiGetGithubUser()

    }

    private fun callApiGetGithubUser() {
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequestCovid<GetCovid>(httpClient)
        val call = apiRequest.getcovid()
        call.enqueue(object : Callback<List<CovidItem>> {
            override fun onFailure(call: Call<List<CovidItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }
            override fun onResponse(
                call: Call<List<CovidItem>>,
                response: Response<List<CovidItem>>
            ) {
                dismissLoading(swipeRefreshLayout)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilGithubUser(response.body()!!)
                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }

                }
            }
        })
    }
    private fun tampilGithubUser(githubUsers: List<CovidItem>) {
        listGithubUser.layoutManager = LinearLayoutManager(context)
        listGithubUser.adapter = GithubUserAdapter(context!!, githubUsers) {
            val githubUser = it
            tampilToast(context!!, githubUser.attributes.provinsi)
        }
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