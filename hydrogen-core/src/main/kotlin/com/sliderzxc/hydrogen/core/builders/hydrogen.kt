package com.sliderzxc.hydrogen.core.builders

import com.sliderzxc.hydrogen.core.Hydrogen

fun hydrogen(block: Hydrogen.Builder.() -> Unit) = Hydrogen.Builder().apply(block).build()
fun hydrogen(baseUrl: String) = Hydrogen(baseUrl)
fun hydrogen() = Hydrogen.Builder().build()