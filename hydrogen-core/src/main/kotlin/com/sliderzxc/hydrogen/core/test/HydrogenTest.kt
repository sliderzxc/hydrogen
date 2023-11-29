package com.sliderzxc.hydrogen.core.test

import com.sliderzxc.hydrogen.core.builders.hydrogen
import com.sliderzxc.hydrogen.core.exception.HydrogenException
import com.sliderzxc.hydrogen.core.model.to
import com.sliderzxc.hydrogen.core.requests.get.get
import com.sliderzxc.hydrogen.core.result.HydrogenResult

fun main() {
    val hydrogen = hydrogen()
    val hydrogen1 = hydrogen("baseUrl")
    val hydrogen2 = hydrogen {
        baseUrl = "http://127.0.0.1:8080/"
    }

    val result1 = hydrogen1.get<TestResponse> {
        url = "http://127.0.0.1:8080/get"
        headers {
            header("testKey" to "testValue")
            header {
                key = "testKey1"
                value = "testValue1"
            }
        }
    }

    val resultSuccess2 = hydrogen2.get<TestResponse> {
        url = "get"
        headers {
            header("testKey" to "testValue")
            header {
                key = "testKey1"
                value = "testValue1"
            }
        }
    }

//    val resultFailure = hydrogen1.get<ResultDTO> {
//        // url = "https://jsonplaceholder.typicode.com/todos/1"
//    }

    when (resultSuccess2) {
        is HydrogenResult.Success -> {
            val successResult = resultSuccess2.result
            println("Success: $successResult")
        }
        is HydrogenResult.Error -> {
            when (resultSuccess2.exception) {
                is HydrogenException.HydrogenUrlException -> {
                    println("Error: ${resultSuccess2.exception.message}")
                }

                is HydrogenException.HydrogenWrongEndOfUrlException -> {
                    println("Error: ${resultSuccess2.exception.message}")
                }
            }
        }
    }

    when (result1) {
        is HydrogenResult.Success -> {
            val successResult = result1.result
            println("Success: $successResult")
        }
        is HydrogenResult.Error -> {
            when (result1.exception) {
                is HydrogenException.HydrogenUrlException -> {
                    println("Error: ${result1.exception.message}")
                }

                is HydrogenException.HydrogenWrongEndOfUrlException -> {
                    println("Error: ${result1.exception.message}")
                }
            }
        }
    }
}