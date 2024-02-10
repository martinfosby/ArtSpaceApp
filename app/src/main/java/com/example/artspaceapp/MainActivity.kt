package com.example.artspaceapp

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Artwork(
                        art = R.drawable.edvard_munch_the_scream,
                        description = null,
                        title = R.string.scream_title,
                        artist = R.string.edward_artist,
                        year = R.string.scream_year
                    )
                }
            }
        }
    }

}

@Composable
fun Artwork(
    @DrawableRes art: Int,
    @StringRes description: Int?,
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ImageCard(
            art = art,
            description = description,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TitleArtistYear(
            title = title,
            artist = artist,
            year = year,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(horizontal = 80.dp, vertical = 10.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        ForwardBackwardButtons(
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Composable
fun ImageCard(
    @DrawableRes art: Int,
    @StringRes description: Int?,
    shadow: Dp = 20.dp,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = shadow,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = art),
            contentDescription = description?.let { stringResource(id = it) },
            modifier = modifier
        )
    }

}

@Composable
fun TitleArtistYear(
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = title),
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
        ) {
            Text(text = stringResource(id = artist))
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(text = stringResource(id = year))
        }
    }
}

@Composable
fun ForwardBackwardButtons(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        Button(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(
                    id = R.string.back_arrow_description
                )
            )
        }
        Button(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.ArrowForward, contentDescription = stringResource(
                    id = R.string.front_arrow_description
                )
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        Artwork(
            art = R.drawable.edvard_munch_the_scream,
            description = R.string.scream_title,
            title = R.string.scream_title,
            artist = R.string.edward_artist,
            year = R.string.scream_year
        )
    }
}