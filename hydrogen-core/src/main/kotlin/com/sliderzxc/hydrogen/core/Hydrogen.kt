package com.sliderzxc.hydrogen.core

class Hydrogen(
    val baseUrl: String?
) {

    private constructor(builder: Builder) : this(builder.baseUrl)

    class Builder {
        var baseUrl: String? = null
        fun build() = Hydrogen(this)
    }
}