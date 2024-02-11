package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                color = colorResource(id = R.color.white),
                modifier = Modifier.fillMaxSize()
            ) {
                QuadrantScreen()
            }
        }
    }
}

@Composable
fun QuadrantScreen() {
    Row {
        Column {
            QuarterElement(0xFFEADDFF.toInt(), 0.5f, 0.5f, R.string.text_composable_title, R.string.text_composable_content)
            QuarterElement(0xFFB69DF8.toInt(), 0.5f,  1f, R.string.row_composable_title, R.string.row_composable_content)
        }
        Column {
            QuarterElement(0xFFD0BCFF.toInt(), 1f, 0.5f, R.string.image_composable_title, R.string.image_composable_content)
            QuarterElement(0xFFF6EDFF.toInt(), 1f,  1f, R.string.column_composable_title, R.string.column_composable_content)
        }
    }
}

@Composable
fun QuarterElement(
    color: Int,
    maxWidth: Float,
    maxHeight: Float,
    titleId: Int,
    contentId: Int
) {
    Surface(
        color = Color(color),
        modifier = Modifier
            .fillMaxWidth(maxWidth)
            .fillMaxHeight(maxHeight)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(titleId),
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(contentId))
        }
    }
}