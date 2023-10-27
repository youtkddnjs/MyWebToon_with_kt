package mhha.sample.mywebtoon

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import android.window.OnBackAnimationCallback
import androidx.activity.OnBackPressedCallback
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import mhha.sample.mywebtoon.databinding.FragmentWebviewBinding

class WebViewFragment( private val posistion : Int) : Fragment() {
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
        //weview client 실행
        binding.webview.webViewClient = WebtoonWebViewClient(binding.progressbar) {url ->
            activity?.getSharedPreferences("WEB_HISTORY", Context.MODE_PRIVATE)?.edit {
                putString("tab$posistion", url)
                Log.d("commit", "$url")
            }
        }//binding.webview.webViewClient = WebtoonWebViewClient
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl("https://comic.naver.com/")

        binding.backTOLastButton.setOnClickListener{
            val sharedPreference = activity?.getSharedPreferences("WEB_HISTORY",Context.MODE_PRIVATE)
            val webUrl = sharedPreference?.getString("tab$posistion", "")
            if(webUrl.isNullOrEmpty()){
                Toast.makeText(context,"저장 시점 없음", Toast.LENGTH_SHORT).show()
            }else{
                binding.webview.loadUrl(webUrl)
            }

        }//binding.backTOLastButton.setOnClickListener
    }//override fun onViewCreated(view: View, savedInstanceState: Bundle?)


    //뒤로가기 버튼 구현
    fun cangoback():Boolean{
        return binding.webview.canGoBack()
    }

    fun goback(){
        return binding.webview.goBack()
    }


}//class WebViewFragment : Fragment()