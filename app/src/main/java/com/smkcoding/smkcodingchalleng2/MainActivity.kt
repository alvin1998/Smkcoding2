package com.smkcoding.smkcodingchalleng2
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    val menuTeks = arrayOf("Home", "Covid", "profil")
    val manuIcon = arrayOf(R.drawable.ic_construction, R.drawable.ic_add,
        R.drawable.ic_social_media)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(this)
        view_pager.setAdapter(adapter);
        TabLayoutMediator(tab_layout, view_pager,
            TabConfigurationStrategy { tab, position ->
                tab.text = menuTeks[position]
                tab.icon = ResourcesCompat.getDrawable(resources,

                    manuIcon[position], null)

            }).attach()
    }

    override fun onBackPressed() {

    }


}