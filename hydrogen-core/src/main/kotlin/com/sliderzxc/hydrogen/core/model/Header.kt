package com.sliderzxc.hydrogen.core.model

import com.sliderzxc.hydrogen.core.HydrogenDsl

data class Header(
    val key: String,
    val value: String
)

@HydrogenDsl
infix fun String.to(value: String) = Header(this, value)