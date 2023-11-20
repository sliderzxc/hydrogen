package com.sliderzxc.hydrogen.network.header

import com.sliderzxc.hydrogen.HydrogenDsl
import com.sliderzxc.hydrogen.model.Header

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
