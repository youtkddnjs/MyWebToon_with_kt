package mhha.sample.mywebtoon

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.window.OnBackAnimationCallback
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import mhha.sample.mywebtoon.databinding.FragmentWebviewBinding

class WebViewFragment : Fragment() {
    private lateinit var binding : FragmentWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebviewBinding.inflate(inflater)
        return binding.root
    }//override fun onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webview.webViewClient = WebtoonWebViewClient(binding.progressbar)
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl("https://comic.naver.com/")
    }


    //뒤로가기 버튼 구현
    fun cangoback():Boolean{
        return binding.webview.canGoBack()
    }

    fun goback(){
        return binding.webview.goBack()
    }


}//class WebViewFragment : Fragment()