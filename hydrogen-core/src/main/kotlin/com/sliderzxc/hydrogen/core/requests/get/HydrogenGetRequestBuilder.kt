package com.sliderzxc.hydrogen.core.requests.get

import com.sliderzxc.hydrogen.core.HydrogenDsl
import com.sliderzxc.hydrogen.core.model.Header
import com.sliderzxc.hydrogen.core.network.header.HeaderContainer

@HydrogenDsl
class HydrogenGetRequestBuilder {

    var url: String? = null
    private var headers: ArrayList<Header> = ArrayList()

    fun headers(block: HeaderContainer.() -> Unit) {
        val headerContainer = HeaderContainer().apply(block)
        headers.addAll(headerContainer.content)
    }

    fun build(): HydrogenGetModel = HydrogenGetModel(url, headers)
}