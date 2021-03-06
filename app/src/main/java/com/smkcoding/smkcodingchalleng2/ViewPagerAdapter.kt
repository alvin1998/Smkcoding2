package com.smkcoding.smkcodingchalleng2
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.smkcoding.smkcodingchalleng2.home_tampil.HomeFragment
import com.smkcoding.smkcodingchalleng2.profil.ProfilFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
 FragmentStateAdapter(fragmentActivity) {

    private val JUMLAH_MENU = 3
    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> { return HomeFragment()
            }
            1 -> { return GithubFragment() }
            2 -> { return ProfilFragment()
            }
            else -> {
                return GithubFragment()
            }
        }
    }
    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}