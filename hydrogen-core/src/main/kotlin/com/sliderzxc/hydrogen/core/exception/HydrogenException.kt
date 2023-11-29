package com.sliderzxc.hydrogen.core.exception

sealed class HydrogenException(message: String) : Exception(message) {
    data class HydrogenUrlException(
        val errorMessage: String = HydrogenExceptionMessages.HydrogenUrlExceptionMessage.message
    ) : HydrogenException(errorMessage)

    data class HydrogenWrongEndOfUrlException(
        val errorMessage: String = HydrogenExceptionMessages.HydrogenWrongEndOfUrlException.message
    ) : HydrogenException(errorMessage)
}