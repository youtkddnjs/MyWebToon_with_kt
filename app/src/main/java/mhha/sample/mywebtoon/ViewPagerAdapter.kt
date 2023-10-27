package mhha.sample.mywebtoon

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {
    //class ViewPagerAdapter : FragmentStateAdapter
    override fun getItemCount(): Int {
        return 3
    }//override fun getItemCount(): Int

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { return WebViewFragment(position)}
            1 -> {return WebViewFragment(position)}
            else -> {return WebViewFragment(position)}
        }//return when(position)
    }//override fun createFragment(position: Int): Fragment

}//class ViewPagerAdapter(private val mainActivity: MainActivity) : FragmentStateAdapter(mainActivity)