package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                color = colorResource(id = R.color.white),
                modifier = Modifier.fillMaxSize()
            ) {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                Modifier
                    .background(colorResource(id = R.color.dark_blue))
                    .size(100.dp),
            )
            Text(
                text = stringResource(id = R.string.user_name),
                fontSize = 40.sp,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )
            Text(
                text = stringResource(id = R.string.user_description),
                color = Color.Green
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .padding(bottom = 100.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.width(180.dp)
            ) {
                Surface(
                    contentColor = Color.Green
                ) {
                    Icon(
                        Icons.Default.Phone,
                        null,
                        modifier = Modifier.weight(1f)
                    )
                }
                Text(
                    text = "xxx-xxxx-xxxx",
                    modifier = Modifier.weight(9f)
                    )
            }
            Row (
                modifier = Modifier.width(180.dp)
            ) {
                Surface(
                    contentColor = Color.Green
                ) {
                    Icon(
                        Icons.Default.Share,
                        null,
                        modifier = Modifier.weight(1f)
                    )
                }
                Text(
                    text = "https://vercelapp.com",
                    modifier = Modifier.weight(9f)
                    )
            }
            Row(
                modifier = Modifier.width(180.dp)
            ) {
                Surface(
                    contentColor = Color.Green
                ) {
                    Icon(
                        Icons.Default.Email,
                        null,
                        modifier = Modifier.weight(1f)
                    )
                }
                Text(
                    text = "hoge@example.com",
                    modifier = Modifier.weight(9f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    MainScreen()
}