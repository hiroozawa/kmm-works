package com.ninehundreds.kmmworks.network

import io.ktor.client.*
import io.ktor.client.request.*

class WhizBangServiceImpl(private val client: HttpClient) : WhizBangService {

    override suspend fun createWhizBang(whiz: WhizBang): WhizBang {
        TODO("Not yet implemented")
    }

    override suspend fun updateWhizBang(whiz: WhizBang): WhizBang {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWhizBang(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getWhizBang(id: String): WhizBang {
        TODO("Not yet implemented")
    }

    override suspend fun getAllWhizBangs(): ArrayList<WhizBang> {
        return client.get(url)
    }

    companion object {
        private const val url = "https://61fbe6bc3f1e34001792c6c7.mockapi.io/api/v1/whizbang/"
    }
}