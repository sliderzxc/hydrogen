package com.sliderzxc.hydrogen.test

import com.sliderzxc.hydrogen.exception.HydrogenException
import com.sliderzxc.hydrogen.hydrogen
import com.sliderzxc.hydrogen.requests.get.get
import com.sliderzxc.hydrogen.result.HydrogenResult

fun main() {
    val hydrogen = hydrogen()
    val hydrogen1 = hydrogen{}

    val resultSuccess = hydrogen.get<ResultDTO> {
        url = "https://jsonplaceholder.typicode.com/todos/1"
    }

    val resultFailure = hydrogen1.get<ResultDTO> {
        // url = "https://jsonplaceholder.typicode.com/todos/1"
    }

    when (resultSuccess) {
        is HydrogenResult.Success -> {
            val successResult = resultSuccess.result
            println("Success: $successResult")
        }
        is HydrogenResult.Error -> {
            when (resultSuccess.exception) {
                is HydrogenException.HydrogenUrlException -> {
                    println("Error: ${resultSuccess.exception.message}")
                }
            }
        }
    }

    when (resultFailure) {
        is HydrogenResult.Error -> {
            when (resultFailure.exception) {
                is HydrogenException.HydrogenUrlException -> {
                    println("Error: ${resultFailure.exception.message}")
                }
            }
        }
        is HydrogenResult.Success -> {
            println("Success: ${resultFailure.result}")
        }
    }
}