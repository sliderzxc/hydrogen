package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.Hydrogen
import com.sliderzxc.hydrogen.HydrogenDsl
import com.sliderzxc.hydrogen.requests.HydrogenRequestType

@HydrogenDsl
inline fun Hydrogen.get(block: HydrogenGetRequestBuilder.() -> Unit): HydrogenGetModel{
    return HydrogenGetRequestBuilder().apply(block).build()
}