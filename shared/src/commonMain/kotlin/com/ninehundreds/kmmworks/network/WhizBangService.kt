package com.ninehundreds.kmmworks.network

interface WhizBangService {

    suspend fun createWhizBang(whiz: WhizBang): WhizBang

    suspend fun updateWhizBang(whiz: WhizBang): WhizBang

    suspend fun deleteWhizBang(id: String): Boolean

    suspend fun getWhizBang(id: String): WhizBang

    suspend fun getAllWhizBangs(): ArrayList<WhizBang>
}