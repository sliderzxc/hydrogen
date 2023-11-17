package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.HydrogenDsl
import com.sliderzxc.hydrogen.requests.HydrogenRequestType
import kotlin.reflect.KClass

@HydrogenDsl
class HydrogenGetRequestBuilder {

    var url: String? = null


    fun build(): HydrogenGetModel = HydrogenGetModel(url)
}