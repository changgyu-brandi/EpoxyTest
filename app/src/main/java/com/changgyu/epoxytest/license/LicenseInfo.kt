package com.changgyu.epoxytest

data class LicenseData(val doc: String, val data: List<LicenseInfo>)

data class LicenseInfo(
    val id: Int,
    val libraryName: String,
    val libraryUrl: String,
    val licenseName: String,
    val licenseDesc: String
)
