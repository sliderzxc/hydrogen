package com.sliderzxc.hydrogen.test

import com.sliderzxc.hydrogen.utils.toObject
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val request: Request = Request.Builder()
        .url("https://jsonplaceholder.typicode.com/todos/1")
        .get()
        .build()

    //response.peekBody(2048).string()



    val client = OkHttpClient()
    client.newCall(request).execute().use { response ->
        if (response.isSuccessful) {
            response.peekBody(2048).string()
            println(response.peekBody(2048).string())
            val a = response.body?.string()?.toObject<TestResponse>()
            println(a)
        } else {
            "Error: ${response.code}"
        }
    }
}
