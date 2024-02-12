package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeApp(Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Header(modifier)
        Content(modifier)
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Surface(
        color = Color.Yellow,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
        ) {
            Text(
                text = "Lemonade",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(24.dp)
            )
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var imageId by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf((2..4).random()) }
    var (image, description) =
        when (imageId) {
            1 -> Pair(painterResource(R.drawable.lemon_tree), stringResource(R.string.lemon_tree))
            2 -> Pair(painterResource(R.drawable.lemon_squeeze), stringResource(R.string.lemon))
            3 -> Pair(painterResource(R.drawable.lemon_drink), stringResource(R.string.glass_of_lemonade))
            else -> Pair(painterResource(R.drawable.lemon_restart), stringResource(R.string.empty_glass))
        }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = "tree",
            modifier = Modifier.background(color = Color(red = 105, green = 205, blue = 216, alpha = 150), shape = RoundedCornerShape(10.dp))
                               .clickable {
                                   when (imageId) {
                                       2 -> {
                                           if (squeezeCount == 0) {
                                               imageId++
                                           } else {
                                               squeezeCount--
                                           }
                                       }
                                       4 -> {
                                           squeezeCount = (2..4).random()
                                           imageId = 1
                                       }
                                       else -> imageId++
                                   }
                               },
        )
        Spacer(modifier = modifier.padding(16.dp))
        Text(text = description, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    LemonadeApp()
}