package com.smkcoding.smkcodingchalleng2.donor_darah

import DonorDarahAdapter
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.agama.IslamItem
import com.smkcoding.smkcodingchalleng2.data.*
import com.smkcoding.smkcodingchalleng2.data_donor_darah.Darah
import com.smkcoding.smkcodingchalleng2.data_donor_darah.Data
import com.smkcoding.smkcodingchalleng2.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_donor_darah.*
import kotlinx.android.synthetic.main.fragment_hidup_sehat.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DonorDarahFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_donor_darah)
        callApiGetGithubUser()

    }
    private fun callApiGetGithubUser() {


        val httpClient = httpClient()
        val apiRequest = apiRequestData<GetDarah>(httpClient)
        val call = apiRequest.getDarah()
        call.enqueue(object : Callback<Darah> {
            override fun onFailure(call: Call<Darah>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<Darah>,
                response: Response<Darah>
            ) {
                tampilGithubUser(response.body()?.data!!)
            }
        })
    }
    private fun tampilGithubUser(githubUsers: List<Data>) {
        listDonor.layoutManager = LinearLayoutManager(this)
        listDonor.adapter = DonorDarahAdapter(this!!, githubUsers) {
            val githubUser = it
//            tampilToast(this!!, githubUser.nama)

        }
    }
}
