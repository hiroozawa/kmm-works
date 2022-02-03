package com.ninehundreds.kmmworks.network

import co.touchlab.kermit.Kermit
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

class WhizApiClient {
    private val log = Kermit()
    private val networkLogger = object : Logger {
        override fun log(message: String) {
            log.v("KMM-Works:") { message }
        }
    }

    private fun getClient(): HttpClient {
        return HttpClient().config {
            install(Logging) {
                logger = networkLogger
                level = LogLevel.ALL
            }

            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }
    }

    suspend fun getWhizBangs(
        success: (List<WhizBang>) -> Unit,
        failure: (Throwable?) -> Unit
    ) {
        try {
            WhizBangServiceImpl(getClient()).getAllWhizBangs().also(success)
        } catch (e: Exception) {
            failure(e)
        }
    }
}



