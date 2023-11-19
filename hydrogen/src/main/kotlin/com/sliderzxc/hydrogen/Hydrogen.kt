package com.sliderzxc.hydrogen

class Hydrogen(
    val name: String?
) {

    private constructor(builder: Builder) : this(builder.name)

    class Builder {
        var name: String? = null
        fun build() = Hydrogen(this)
    }
}

fun hydrogen(block: Hydrogen.Builder.() -> Unit) = Hydrogen.Builder().apply(block).build()
fun hydrogen() = Hydrogen.Builder().build()