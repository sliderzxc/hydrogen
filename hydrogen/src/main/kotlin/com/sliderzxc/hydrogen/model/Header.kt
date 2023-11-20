package com.sliderzxc.hydrogen.model

import com.sliderzxc.hydrogen.HydrogenDsl

data class Header(
    val key: String,
    val value: String
)

@HydrogenDsl
infix fun String.to(value: String) = Header(this, value)