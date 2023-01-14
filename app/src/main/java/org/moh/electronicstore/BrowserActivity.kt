package org.moh.electronicstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)
        val wb=findViewById<WebView>(R.id.webview_brw)
        val edt_url=findViewById<EditText>(R.id.edt_url)
        wb.getSettings().javaScriptEnabled = true

        // Add a WebViewClient
        wb.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // Inject CSS when page is done loading
                try {
                    wb!!.loadUrl(
                        "javascript:(function() { " +
                                "var links = document.getElementsByTagName('a');"
                                + "for(var i = 0; i < links.length; i++) {" +
                                "links[i].style.color=\"red\";" +
                                "}" +
                                "})()"
                    )
                } catch (e: Exception) {
                    Log.i("injectCSS", e.message!!)
                }
                super.onPageFinished(view, url)
            }
        })


        findViewById<Button>(R.id.btn_go).setOnClickListener(){
            wb.loadUrl(edt_url.text.toString())
        }
    }

}
