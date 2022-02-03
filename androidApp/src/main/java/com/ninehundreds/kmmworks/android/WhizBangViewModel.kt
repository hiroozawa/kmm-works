package com.ninehundreds.kmmworks.android

import androidx.lifecycle.ViewModel
import com.ninehundreds.kmmworks.network.WhizApiClient
import com.ninehundreds.kmmworks.network.WhizBang
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking

class WhizBangViewModel : ViewModel() {
    private val appClient = WhizApiClient()
    private val _uiState = MutableStateFlow<List<WhizBang>>(emptyList())
    val uiState: StateFlow<List<WhizBang>> = _uiState
    init {
        getAllWhizBangs()
    }

    private fun getAllWhizBangs() {
        runBlocking {
            appClient.getWhizBangs(
                success = {
                    _uiState.value = it.sortedBy { it.code }
                },
                failure = {
                    it?.printStackTrace()
                }
            )
        }
    }
}

