package com.sliderzxc.hydrogen.requests.get

import com.sliderzxc.hydrogen.utils.toObject
import okhttp3.OkHttpClient
import okhttp3.Request

data class HydrogenGetModel(
    val url: String?,
) {
    inline fun <reified T: Any> execute(): Result<T> {
        val request: Request = Request.Builder()
            .url(url ?: return Result.failure(Exception("give me url")))
            .get()
            .build()


        val client = OkHttpClient()
        val s = client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                //println(response.body?.string())
                response.peekBody(2048).string()
            } else {
                "Error: ${response.code}"
            }
        }
        return Result.success(s.toObject<T>())
    }
}