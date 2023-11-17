package com.sliderzxc.hydrogen

import com.sliderzxc.hydrogen.requests.get

fun main() {
    val hydrogen = Hydrogen.Builder().build()
    val hydrogen1 = hydrogen {
        name = "Vadym1"
    }
    hydrogen1.get {

    }
    println(hydrogen1.name)
}