package com.changgyu.epoxytest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.changgyu.epoxytest.databinding.ActivityMainBinding
import com.changgyu.epoxytest.epoxy.MainEpoxyController
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val controller: MainEpoxyController by lazy { MainEpoxyController(
        object :LicenseClickListener<LicenseInfo>{
            override fun onLibraryNameClick(data: LicenseInfo) {
                Toast.makeText(this@MainActivity, data.libraryName, Toast.LENGTH_SHORT).show()
            }

            override fun onLibraryUrlClick(data: LicenseInfo) {
                val mIntent = Intent(this@MainActivity, WebViewActivity::class.java)
                mIntent.putExtra("libraryUrl", data.libraryUrl)
                startActivity(mIntent)
            }

            override fun onLicenseNameClick(data: LicenseInfo) {
                Toast.makeText(this@MainActivity, data.licenseName, Toast.LENGTH_SHORT).show()
            }

            override fun onLicenseDescClick(data: LicenseInfo) {
                Toast.makeText(this@MainActivity, data.licenseDesc, Toast.LENGTH_SHORT).show()
            }
        })

     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = controller.adapter
        val gl = GridLayoutManager(this,2 )
        binding.rvList.layoutManager = gl
/*        gl.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                if(position%3==0) return 2
                else return 1
            }
        }*/
        val str = Gson().toJson(getLicenseData())       //현재 LicenseData를 하드코딩으로 해놨는데 서버에서 받아오는 방식으로 변경
        val license = getStringToClass(str, LicenseData::class.java)
        binding.rvList.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        controller.setData(license.data)
    }


}