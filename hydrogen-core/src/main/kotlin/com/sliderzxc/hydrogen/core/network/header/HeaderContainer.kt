package com.sliderzxc.hydrogen.core.network.header

import com.sliderzxc.hydrogen.core.HydrogenDsl
import com.sliderzxc.hydrogen.core.model.Header

class HeaderContainer {

    val content: MutableList<Header> = mutableListOf()

    @HydrogenDsl
    inline fun header(block: HeaderBuilder.() -> Unit): Header {
        return HeaderBuilder().apply(block).build().also { content.add(it) }
    }

    @HydrogenDsl
    fun header(header: Header): Header {
        return HeaderBuilder().build().also { content.add(header) }
    }
}
