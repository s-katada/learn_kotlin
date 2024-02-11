package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                color = colorResource(id = R.color.white),
                modifier = Modifier.fillMaxSize()
            ) {
                RenderScreen()
            }
        }
    }
}

@Composable
fun RenderScreen() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompletedImage()
            CompletedText()
            ComplimentaryText()
        }
    }
}

@Composable
fun CompletedImage() {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Image(painter = image, contentDescription = null)
}

@Composable
fun CompletedText() {
    Text(
        text = stringResource(id = R.string.completed_text),
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ComplimentaryText() {
    Text(
        text = stringResource(id = R.string.complimentary_text),
        fontSize = 16.sp
    )
}