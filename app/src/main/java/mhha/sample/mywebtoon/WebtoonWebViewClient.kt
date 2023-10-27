package mhha.sample.mywebtoon

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.core.view.isVisible

class WebtoonWebViewClient(
    private val grogressbar : ProgressBar,
    private val savaData : (String) -> Unit,
    ) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        Log.d("webview", "${request?.url}")

        if(request != null && request.url.toString().contains("detail")){
            savaData.invoke(request.url.toString())
        }


        return super.shouldOverrideUrlLoading(view, request)
    }//override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        grogressbar.isVisible=true
    }//override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?)

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        grogressbar.isVisible=false
    }//override fun onPageFinished(view: WebView?, url: String?)

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
    }//override fun onReceivedError


}//class WebtoonWebViewClient : WebViewClient()