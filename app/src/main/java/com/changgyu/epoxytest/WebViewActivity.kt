package com.changgyu.epoxytest

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.changgyu.epoxytest.databinding.ActivityWebviewBinding


class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url = intent.getStringExtra("libraryUrl")?:""
        binding.webview.loadUrl(url)
        binding.webview.webViewClient = WebViewClient()
        val mWebSettings = binding.webview.settings
        mWebSettings.javaScriptEnabled = true
        mWebSettings.useWideViewPort = true
        mWebSettings.setSupportZoom(true)
        mWebSettings.builtInZoomControls = true
        mWebSettings.displayZoomControls = false
        mWebSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK


    }

    override fun onBackPressed() {
        if(binding.webview.canGoBack()){
            binding.webview.goBack()
        }else{
            super.onBackPressed()
        }
    }
}