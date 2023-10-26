package mhha.sample.mywebtoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.window.OnBackInvokedDispatcher
import mhha.sample.mywebtoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val container = binding.fragmentContainer

        binding.button01.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, WebViewFragment())
                commit()
            }
        }//binding.button01.setOnClickListener
        binding.button02.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, BFragment())
                commit()
            }
        }//binding.button02.setOnClickListener
    } //override fun onCreate(savedInstanceState: Bundle?)



    //뒤로가기 버튼 구현
//    override fun onBackPressed() {
//        var currentFragment = supportFragmentManager.fragments.first()
//        if( currentFragment is WebViewFragment){
//            if(currentFragment.goToBack()){currentFragment.goBack()}else{ super.onBackPressed()}
//        }else{super.onBackPressed()}
//    } //override fun onBackPressed()

} //class MainActivity : AppCompatActivity()