package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.exception.HydrogenException
import com.sliderzxc.hydrogen.result.HydrogenResult
import com.sliderzxc.hydrogen.utils.toObject
import okhttp3.OkHttpClient
import okhttp3.Request

data class HydrogenGetModel(
    val url: String?,
) {
    inline fun <reified T: Any> execute(): HydrogenResult<T> {
        val request: Request = Request.Builder()
            .url(url ?: return HydrogenResult.Error(HydrogenException()))
            .get()
            .build()


        val client = OkHttpClient()
        val json = client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                response.peekBody(2048).string()
            } else {
                "Error: ${response.code}"
            }
        }
        return HydrogenResult.Success(json.toObject<T>())
    }
}