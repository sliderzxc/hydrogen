package com.sliderzxc.hydrogen.test

import com.sliderzxc.hydrogen.hydrogen
import com.sliderzxc.hydrogen.requests.get.get

fun main() {
    val hydrogen = hydrogen {}

    val result = hydrogen.get<ResultDTO> {
        url = "https://jsonplaceholder.typicode.com/todos/1"
    }

    println("GET Request Result:")
    println(result)

    println("Hydrogen Name: ${hydrogen.name}")
}