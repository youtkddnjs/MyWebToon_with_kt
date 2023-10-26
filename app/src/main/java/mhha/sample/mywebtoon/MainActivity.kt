package mhha.sample.mywebtoon

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

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.viewpager2.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewpager2){tab, position ->
            run{
                val textView = TextView(this@MainActivity)
                textView.text = "postion $position"
                textView.gravity = Gravity.CENTER
                tab.customView = textView
            }
        }.attach()//TabLayoutMediator(binding.tabLayout, binding.viewpager2){tab, position ->


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



} //class MainActivity : AppCompatActivity()