package com.example.composeaula01

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeaula01.data.Profile
import com.example.composeaula01.ui.theme.ComposeAula01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAula01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenContent()
                }
            }
        }
    }
}

@Composable
fun ScreenContent() {
    val profiles = List<Profile>(100){
        Profile("Lars $it", "Texto $it", R.drawable.lars)
    }
    Column() {
        Surface(
            modifier = Modifier.weight(1f)
        ){
            ProfileList(profiles = profiles)
        }
        Surface(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ){
            Button(
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Add Lars")
            }
        }
    }
}

@Composable
fun ProfileList(profiles: List<Profile>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
    ) {
        items(profiles) { profile ->
            ProfileCard(profile = profile)
        }
    }
}

@Composable
fun ProfileCard(
    profile: Profile
) {
    Row(modifier = Modifier.padding(8.dp)){
        Image(
            painter = painterResource(id = profile.avatar),
            contentDescription = "Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(2.dp, Color.DarkGray, CircleShape)
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = profile.name,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = profile.description,
                style = MaterialTheme.typography.body2
                    .copy(
                        color = Color.LightGray,
                    )
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320)
@Composable
fun ProfileCardPreview() {
    ComposeAula01Theme {
        ProfileCard(Profile("Lars", "Stackoverflow", R.drawable.lars))
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 600, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ProfileListPreview() {
    ComposeAula01Theme {
        val profiles = List<Profile>(100){
            Profile("Lars $it", "Texto $it", R.drawable.lars)
        }
        ProfileList(profiles = profiles)
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 600, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ScreenPreview() {
    ComposeAula01Theme {
        ScreenContent()
    }
}