package com.smkcoding.smkcodingchalleng2.islam

import HidupAdapter
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smkcoding.smkcodingchalleng2.R
import com.smkcoding.smkcodingchalleng2.agama.IslamItem
import com.smkcoding.smkcodingchalleng2.data.Getislam
import com.smkcoding.smkcodingchalleng2.data.apiRequestIslam
import com.smkcoding.smkcodingchalleng2.data.httpClient
import com.smkcoding.smkcodingchalleng2.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_hidup_sehat.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HidupFragment : AppCompatActivity() {


    var mediaPlayer: MediaPlayer? = MediaPlayer()
    var kondisi = "0"
    var suara = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_hidup_sehat)
        callApiGetGithubUser()

        PlayAudio.setOnClickListener { Play() }
        PauseAudio.setOnClickListener { Puase()}
        StopAudio.setOnClickListener { Stop() }

        if(mediaPlayer?.isPlaying()!!){
            PlayAudio.setEnabled(false);
            PauseAudio.setEnabled(false);
            StopAudio.setEnabled(false);
        }else {
            PlayAudio.setEnabled(false);
            PauseAudio.setEnabled(true);
            StopAudio.setEnabled(true);
        }

    }

    private  fun Play(){
        kondisi = "1"
        Audio(suara,kondisi)
        PlayAudio.setEnabled(false);
        PauseAudio.setEnabled(true);
        StopAudio.setEnabled(true);

    }
    private  fun Puase(){
        kondisi = "2"
    }
    private  fun Stop(){
        kondisi = "3"
        Audio(suara,kondisi)
        PlayAudio.setEnabled(true);
        PauseAudio.setEnabled(false);
        StopAudio.setEnabled(false);
    }


    private fun callApiGetGithubUser() {
        val httpClient = httpClient()
        val apiRequest = apiRequestIslam<Getislam>(httpClient)
        val call = apiRequest.getislam()
        call.enqueue(object : Callback<List<IslamItem>> {
            override fun onFailure(call: Call<List<IslamItem>>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<List<IslamItem>>,
                response: Response<List<IslamItem>>
            ) {
                tampilGithubUser(response.body()!!)
            }
        })
    }
    private fun tampilGithubUser(githubUsers: List<IslamItem>) {
        listsehat.layoutManager = LinearLayoutManager(this)
        listsehat.adapter = HidupAdapter(this!!, githubUsers) {
            val githubUser = it
            tampilToast(this!!, githubUser.nama)
            suara = githubUser.audio

            PlayAudio.setEnabled(true);
            PauseAudio.setEnabled(false);
            StopAudio.setEnabled(false);

        }
    }

    private fun Audio(audio: String, Kondisi: String) {
        val url = audio// your URL here
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)


            if(Kondisi == "1" ) {
//                var mediaPlayer: MediaPlayer? = MediaPlayer()
                mediaPlayer?.setDataSource(url)
                mediaPlayer?.prepare() // might take long! (for buffering, etc)

                mediaPlayer?.start()

                Log.d("polo123","$Kondisi")
            }
            if(Kondisi == "2" ) {

                mediaPlayer!!.pause()
                mediaPlayer?.setDataSource(url)


                Log.d("polo123","pause")
            }
            if(Kondisi == "3" ) {

                mediaPlayer!!.stop()
                mediaPlayer!!.release()
                mediaPlayer = null


                Log.d("polo123","Stop")
            }

    }


    override fun onDestroy() {

        super.onDestroy()
        this.clearFindViewByIdCache()
    }


}