package com.sliderzxc.hydrogen.core.requests.get

import com.sliderzxc.hydrogen.core.exception.HydrogenException
import com.sliderzxc.hydrogen.core.model.Header
import com.sliderzxc.hydrogen.core.result.HydrogenResult
import com.sliderzxc.hydrogen.core.utils.toObject
import okhttp3.OkHttpClient
import okhttp3.Request

typealias Headers = List<Header>

data class HydrogenGetModel(
    val url: String?,
    val headers: Headers
) {
    inline fun <reified T: Any> execute(): HydrogenResult<T> {
        val headerBuilder = okhttp3.Headers.Builder()
        headers.forEach { (key, value) ->
            // todo
            println("header: $key, $value")
            headerBuilder.add(key, value)
        }

        val request: Request = Request.Builder()
            .url(url ?: return HydrogenResult.Error(HydrogenException.HydrogenUrlException()))
            .get()
            .headers(headerBuilder.build())
            .build()

        val client = OkHttpClient()
        val json = client.newCall(request).execute().use { response ->
            if (response.isSuccessful) response.peekBody(2048).string()
            else "Error: ${response.code}"
        }

        return try {
            HydrogenResult.Success(json.toObject<T>())
        } catch (e: Exception) {
            HydrogenResult.Error(HydrogenException.HydrogenUrlException())
        }
    }
}