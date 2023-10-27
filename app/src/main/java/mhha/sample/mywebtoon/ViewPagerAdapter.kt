package mhha.sample.mywebtoon

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {
    //class ViewPagerAdapter : FragmentStateAdapter
    override fun getItemCount(): Int {
        return 3
    }//override fun getItemCount(): Int

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { return WebViewFragment(position, " https://m.comic.naver.com/index").apply {
                Log.d("changedName", "동작했나?")
                listener = mainActivity
            }}
            1 -> {return WebViewFragment(position, " https://m.comic.naver.com/index").apply {
                listener = mainActivity
            }}
            else -> {return WebViewFragment(position, " https://m.comic.naver.com/index").apply { listener = mainActivity }}
        }//return when(position)
    }//override fun createFragment(position: Int): Fragment

}//class ViewPagerAdapter(private val mainActivity: MainActivity) : FragmentStateAdapter(mainActivity)