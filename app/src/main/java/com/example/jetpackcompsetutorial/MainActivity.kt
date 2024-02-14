package com.example.jetpackcompsetutorial

import android.content.res.Resources.Theme
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat.ThemeCompat
import com.example.jetpackcompsetutorial.ui.theme.JetPackCompseTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCompseTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(all = 8.dp)) {
                        MessageCard(
                            profile = "Earth",
                            desc = "This is an image of earth or what it should look like"
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        MessageCard(
                            profile = "Earth",
                            desc = "This is an image of earth or what it should look like"
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun MessageCard(profile : String, desc : String) {
    // Add padding around our message
Surface(shape = MaterialTheme.shapes.medium , shadowElevation = 10.dp , modifier = Modifier.height(100.dp)) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.geo),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(80.dp)
                    // Clip image to be shaped as a circle
                    .clip(RectangleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = profile,
                    fontSize = 25.sp)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = desc,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackCompseTutorialTheme {
        MessageCard(profile = "Earth", desc = "This is an image of earth or what it should look like")
    }
}