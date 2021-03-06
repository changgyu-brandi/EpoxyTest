package com.changgyu.epoxytest.epoxy

import com.airbnb.epoxy.EpoxyController
import com.changgyu.epoxytest.LicenseClickListener
import com.changgyu.epoxytest.LicenseInfo

class MainEpoxyController(private val listener: LicenseClickListener<LicenseInfo>) :
    EpoxyController() {

    lateinit var mLicenstList: List<LicenseInfo>

    fun setData(licenstList: List<LicenseInfo>) {
        mLicenstList = licenstList
        requestModelBuild()
    }

    override fun buildModels() {
        mLicenstList.forEach {
            license {
                id(it.id)
                licenseInfo(it)
                licenseClickListener(listener)
            }
        }
    }

}