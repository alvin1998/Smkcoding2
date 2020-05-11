package com.smkcoding.smkcodingchalleng2
import HomeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var listTeman : ArrayList<Home_img>
    private fun data_gambar() {
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