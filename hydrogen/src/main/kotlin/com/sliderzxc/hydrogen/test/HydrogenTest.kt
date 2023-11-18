package com.sliderzxc.hydrogen.test

import com.sliderzxc.hydrogen.Hydrogen
import com.sliderzxc.hydrogen.hydrogen
import com.sliderzxc.hydrogen.requests.get.get
import com.sliderzxc.hydrogen.result.HydrogenResult

fun main() {
    val hydrogen = hydrogen {}

    val resultSuccess = hydrogen.get<ResultDTO> {
        url = "https://jsonplaceholder.typicode.com/todos/1"
    }
    val resultFailure = hydrogen.get<ResultDTO> {
        // url = "https://jsonplaceholder.typicode.com/todos/1"
    }

    when(resultSuccess) {
        is HydrogenResult.Error -> {
            resultSuccess.exception
        }
        is HydrogenResult.Success -> {
            resultSuccess.result
        }
    }
    when(resultFailure) {
        is HydrogenResult.Error -> {
            resultFailure.exception
        }
        is HydrogenResult.Success -> {
            resultFailure.result
        }
    }
    println(resultSuccess)
    println(resultFailure)

    println("Hydrogen Name: ${hydrogen.name}")
}