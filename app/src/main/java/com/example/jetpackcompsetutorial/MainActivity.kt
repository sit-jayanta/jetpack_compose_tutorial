package com.example.jetpackcompsetutorial

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompsetutorial.ui.theme.JetPackComposeTutorialTheme
import com.example.jetpackcompsetutorial.ui.theme.darkBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTutorialTheme {
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
                        Spacer(modifier = Modifier.height(18.dp))
                        ArtistCardModifiers(onClick = { expandable(this@MainActivity) })
                    }
                }
            }
        }
    }
}
fun expandable(context: Context){
    Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
}


@Composable
fun MessageCard(profile : String, desc : String) {
    // Add padding around our message
Surface(shape = MaterialTheme.shapes.medium , shadowElevation = 15.dp , modifier = Modifier.height(100.dp)) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.geo),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(80.dp)
                    // Clip image to be shaped as a circle
                    .clip(shape = ShapeDefaults.Small)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = profile,
                    fontSize = 25.sp
                )
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = desc,
                    fontSize = 15.sp,
                    color = darkBlue,
                    style = MaterialTheme.typography.titleSmall
                )
                TimerText(viewModel = MyViewModel())
                GameContent(viewModel = MyViewModel())
            }
        }
    }

}
@Composable
fun ArtistAvatar() {
    Box(contentAlignment = Alignment.BottomEnd) {
        Image(
            painter = painterResource(R.drawable.nature),
            contentDescription = "Artist image",
            modifier = Modifier
                // Set image size to 40 dp
                .size(80.dp)
                // Clip image to be shaped as a circle
                .clip(shape = CircleShape)
        )
        Icon(
            painterResource(id = R.drawable.remove),
            contentDescription = "Check mark",
            modifier = Modifier
                .height(30.dp)
                .width(30.dp)
        )
    }
}

@Composable
fun ArtistCardModifiers(
    onClick: () -> Unit
) {
    val padding = 16.dp
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) { ArtistAvatar() }
        Spacer(Modifier.size(padding))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
        }
    }
}

@Composable
fun TimerText(viewModel: MyViewModel) {
    var timerState by remember {
        mutableStateOf("")
    }

    viewModel.subTimerState = {
        timerState = it.toString()
    }

    Text(
        text = timerState
    )
}

@Composable
fun GameContent(viewModel: MyViewModel) {
    viewModel.updateTimerState()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeTutorialTheme {
        MessageCard(
            profile = "Earth",
            desc = "This is an image of earth or what it should look like"
        )
    }
}