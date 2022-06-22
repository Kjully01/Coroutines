package com.teste.excoroutinesdata

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MyRepository {

    val listMock = listOf<String>(
        "Bem Vinda",
        "Ao Bootcamp",
        "Code Like a Girl"
    )

    suspend fun getData(): Flow<String> {
        return flow {
            listMock.forEach{ string ->
                emit(string)
                delay(1000)
            }
        }
    }

}