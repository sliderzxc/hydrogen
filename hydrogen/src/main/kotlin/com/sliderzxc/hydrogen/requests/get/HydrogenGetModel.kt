package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.exception.HydrogenException
import com.sliderzxc.hydrogen.model.Header
import com.sliderzxc.hydrogen.result.HydrogenResult
import com.sliderzxc.hydrogen.utils.toObject
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