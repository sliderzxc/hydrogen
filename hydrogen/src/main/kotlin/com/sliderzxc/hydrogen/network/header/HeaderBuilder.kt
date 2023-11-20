package com.sliderzxc.hydrogen.network.header

import com.sliderzxc.hydrogen.HydrogenDsl
import com.sliderzxc.hydrogen.model.Header

@HydrogenDsl
class HeaderBuilder {

    var key = ""
    var value = ""

    fun build(): Header = Header(key, value)
}