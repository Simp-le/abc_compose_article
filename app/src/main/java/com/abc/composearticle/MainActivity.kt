package com.abc.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abc.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeArticleApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(modifier: Modifier = Modifier) {
    Article(
        modifier = modifier,
        photo = painterResource(R.drawable.bg_compose_background),
        title = stringResource(R.string.article_title),
        shortDescription = stringResource(R.string.short_description),
        longDescription = stringResource(R.string.long_description)
    )
}

@Composable
fun Article(
    photo: Painter,
    title: String,
    shortDescription: String,
    longDescription: String,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Image(
            painter = photo,
            contentDescription = null,
            // The solution does not set the Modifier.fillMaxWidth() and contentScale
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        // They immediately put three composable Text() functions
        ArticleText(
            title = title,
            shortDescription = shortDescription,
            longDescription = longDescription
        )
    }
}

// This function is not included in the solution
@Composable
fun ArticleText(title: String, shortDescription: String, longDescription: String) {
    Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
    Text(
        text = shortDescription,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
    Text(
        text = longDescription,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposeArticleTheme {
        ComposeArticleApp()
    }
}