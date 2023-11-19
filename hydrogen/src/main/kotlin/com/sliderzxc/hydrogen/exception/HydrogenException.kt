package com.sliderzxc.hydrogen.exception

sealed class HydrogenException(message: String) : Exception(message) {
    data class HydrogenUrlException(
        val errorMessage: String = HydrogenExceptionMessages.HydrogenUrlExceptionMessage.message
    ) : HydrogenException(errorMessage)
}