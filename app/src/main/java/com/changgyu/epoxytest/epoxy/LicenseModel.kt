package com.changgyu.epoxytest.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.changgyu.epoxytest.LicenseClickListener
import com.changgyu.epoxytest.LicenseInfo
import com.changgyu.epoxytest.R
import com.changgyu.epoxytest.databinding.ItemLicenseBinding

@EpoxyModelClass(layout = R.layout.item_license)
abstract class LicenseModel : EpoxyModelWithHolder<LicenseModel.LicenseHolder>() {

    @EpoxyAttribute
    lateinit var licenseClickListener: LicenseClickListener<LicenseInfo>

    @EpoxyAttribute
    lateinit var licenseInfo: LicenseInfo

    override fun bind(holder: LicenseHolder) {
        holder.binding.apply {
            tvLibraryName.text = licenseInfo.libraryName
            tvLicenseName.text = licenseInfo.licenseName
            tvLibraryUrl.text = licenseInfo.libraryUrl
            tvLicenseDesc.text = licenseInfo.licenseDesc

            tvLibraryUrl.setOnClickListener {
                licenseClickListener.onLibraryUrlClick(licenseInfo)
            }
            tvLicenseName.setOnClickListener {
                licenseClickListener.onLicenseNameClick(licenseInfo)
            }

            tvLibraryName.setOnClickListener {
                licenseClickListener.onLibraryNameClick(licenseInfo)
            }

            tvLicenseDesc.setOnClickListener {
                licenseClickListener.onLicenseDescClick(licenseInfo)
            }

        }
    }

    inner class LicenseHolder : EpoxyHolder() {

        lateinit var binding: ItemLicenseBinding

        override fun bindView(itemView: View) {
            binding = ItemLicenseBinding.bind(itemView)
        }

    }
}