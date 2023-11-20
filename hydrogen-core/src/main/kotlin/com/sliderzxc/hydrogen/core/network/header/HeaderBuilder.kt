package com.sliderzxc.hydrogen.core.network.header

import com.sliderzxc.hydrogen.core.HydrogenDsl
import com.sliderzxc.hydrogen.core.model.Header

@HydrogenDsl
class HeaderBuilder {

    var key = ""
    var value = ""

    fun build(): Header = Header(key, value)
}