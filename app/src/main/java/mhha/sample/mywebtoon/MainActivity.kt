package mhha.sample.mywebtoon

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.webkit.WebViewClient
import android.widget.TextView
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import mhha.sample.mywebtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , TabName {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewPager 연결
        binding.viewpager2.adapter = ViewPagerAdapter(this)

        val sharedPreference = getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE )
        val tab0 = sharedPreference?.getString("tab0_name", "무제")
        val tab1 = sharedPreference?.getString("tab1_name", "무제")
        val tab2 = sharedPreference?.getString("tab2_name", "무제")
        //TabLayout 연결
        TabLayoutMediator(binding.tabLayout, binding.viewpager2){tab, position ->
            run{
                // 탭이름 변경 방법 1
//                val textView = TextView(this@MainActivity)
//                textView.text = "무제-$position"
//                textView.gravity = Gravity.CENTER
//                tab.customView = textView

                // 탭이름 변경 방법 2
//                tab.text = when(position){
//                    0-> tab0
//                    1-> tab1
//                    2-> tab2
//                    else -> "무제"
//                }

            }
        }.attach()//TabLayoutMediator(binding.tabLayout, binding.viewpager2){tab, position ->



        //뒤로가기 버튼
        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val currentFrgment = supportFragmentManager.fragments[binding.viewpager2.currentItem]
                if(currentFrgment is WebViewFragment) {
                    if ( currentFrgment.cangoback() ){
                        currentFrgment.goback()
                    } else{
                        finish()
                    }
                }else {
                    finish()
                }//if(currentFrgment is WebViewFragment)
            }//override fun handleOnBackPressed()
        }) //this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true)

    } //override fun onCreate(savedInstanceState: Bundle?)

    override fun nameChanged(posistion: Int, name: String) {
        Log.d("changedName", "$name")
        val tab = binding.tabLayout.getTabAt(posistion)
        //탭이름 방법 1
//        val textview = TextView(this@MainActivity)
//        textview.text = name
//        textview.gravity = Gravity.CENTER
//        tab?.customView = textview
        //탭이름 변경 방법 2
        tab?.text = name
    }//override fun nameChanged(posistion: Int, name: String)

}  //class MainActivity : AppCompatActivity()