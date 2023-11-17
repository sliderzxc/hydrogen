package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.HydrogenDsl
import com.sliderzxc.hydrogen.requests.HydrogenRequestType

@HydrogenDsl
class HydrogenGetRequestBuilder {

    var url: String? = null
    var type: HydrogenRequestType? = null
    fun build(): HydrogenGetModel = HydrogenGetModel(url, type)
}