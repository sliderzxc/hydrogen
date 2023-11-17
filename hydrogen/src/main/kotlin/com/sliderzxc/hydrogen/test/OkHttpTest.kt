package com.sliderzxc.hydrogen.test

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

fun main() {
    val request: Request = Request.Builder()
        .url("https://publicobject.com/helloworld.txt")
        .get()
        .build()

    val client = OkHttpClient()

    // Use the client to execute the request
    client.newCall(request).execute().use { response: Response ->
        if (response.isSuccessful) {
            val responseBody = response.body?.string()
            println(responseBody)
        } else {
            println("Error: ${response.code}")
        }
    }
}
