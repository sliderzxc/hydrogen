package com.sliderzxc.hydrogen.test

import com.sliderzxc.hydrogen.hydrogen
import com.sliderzxc.hydrogen.requests.HydrogenRequestType
import com.sliderzxc.hydrogen.requests.get.get

fun main() {
    val hydrogen = hydrogen {
        name = "Vadym1"
    }
    val getRequest = hydrogen.get {
        type = HydrogenRequestType.GET
        url = "dsdsds"
    }
    println(getRequest.type)
    println(getRequest.url)
    println(hydrogen.name)
}
