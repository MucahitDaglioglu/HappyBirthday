package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage("Happy Birthday", "GDSC ATAUNI")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)   // The background of our app

    Box {
        Image(
            painter = image,
            contentDescription = "image",
            contentScale = ContentScale.Crop   // Specify a contentScale option to crop or change how an image is scaled inside its bounds
        )
        BirthdayGreetingWithText(message, from)
    }

}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {

    Column {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier  // Modifier allow you to decorate or augment a composable
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true   // If you need to display the status and action bars inside a preview, add the showSystemUi parameter
)
@Composable
fun DefaultPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage("Happy Birthday", "GDSC ATAUNI")
    }
}