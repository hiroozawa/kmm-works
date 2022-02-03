package com.ninehundreds.kmmworks.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import com.ninehundreds.kmmworks.Greeting
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.android.material.composethemeadapter.MdcTheme
import com.ninehundreds.kmmworks.network.WhizBang

fun greet(): String {
    return Greeting().greet()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val whizLiz = findViewById<ComposeView>(R.id.whizList)
        whizLiz.setContent {
            MdcTheme { // or AppCompatTheme
                Greeting()
            }
        }
    }

    @Composable
    private fun Greeting(
        viewModel: WhizBangViewModel = WhizBangViewModel()
    ) {
        val uiState: List<WhizBang> by viewModel.uiState.collectAsState()

        Column {
            uiState.map { SnapImage(url = it.snap ?: "") }
            uiState.map { it.id }.joinToString(", ").let { Text(text = "ids: $it") }
            uiState.map { it.code }.joinToString(", ").let { Text(text = "codes: $it") }
            uiState.map { it.desc }.joinToString(" ").let { Text(text = "desc: $it") }
        }
    }

    @Composable
    private fun SnapImage(
        url: String
    ) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            modifier = Modifier.size(900.dp, 21.dp)
        )
    }

}
