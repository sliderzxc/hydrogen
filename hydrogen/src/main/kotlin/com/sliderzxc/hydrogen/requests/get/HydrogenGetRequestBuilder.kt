package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.HydrogenDsl

@HydrogenDsl
class HydrogenGetRequestBuilder {

    var url: String? = null


    fun build(): HydrogenGetModel = HydrogenGetModel(url)
}