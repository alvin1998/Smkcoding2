package com.smkcoding.smkcodingchalleng2.home_tampil
import HomeAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.smkcoding.smkcodingchalleng2.hidup_sehat.HidupFragment
import com.smkcoding.smkcodingchalleng2.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
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
        initView()
        hidup_sehat.setOnClickListener { goToSehatFragmnet() }

    }
    private fun goToSehatFragmnet() {
        val intent = Intent(context, HidupFragment::class.java)
        startActivity(intent)
    }

    private fun initView() {
        data_gambar()
        tampilTeman()
    }
    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}