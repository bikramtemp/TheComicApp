package com.bikram.thecomicapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bikram.thecomicapp.model.response.ComicResponse
import com.bikram.thecomicapp.ui.theme.colorPrimary
import com.bikram.thecomicapp.ui.viewmodel.MainViewModel

@Preview(showBackground = true)
@Composable
fun ComicsScreen() {
    val viewModel: MainViewModel = viewModel()
    val comic = viewModel.comicState.value

    ComicDetails(comic, viewModel)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComicDetails(
    comic: ComicResponse,
    viewModel: MainViewModel
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowLeft,
                contentDescription = "Left",
                tint = colorPrimary,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(36.dp)
                    .combinedClickable(
                        onClick = {
                            // TODO show previous comic
                        },
                        onLongClick = {
                            // TODO show first comic
                        },
                    )
            )

            Column(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ID: ${comic.num}",
                    textAlign = TextAlign.Start,
                    color = Color.DarkGray
                )

                Text(
                    text = viewModel.getFormattedDate(comic.day, comic.month, comic.year),
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Start,
                    color = Color.DarkGray,
                )
            }

            Icon(
                imageVector = Icons.Filled.ArrowRight,
                contentDescription = "Right",
                tint = colorPrimary,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(36.dp)
                    .combinedClickable(
                        onClick = {
                            // TODO show next comic
                        },
                        onLongClick = {
                            // TODO show last comic
                        },
                    )
            )
        }

        AsyncImage(
            model = ImageRequest
                .Builder(context)
                .data(comic.img)
                .crossfade(true)
                .build(),
            contentDescription = comic.alt,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )

        comic.title?.let {
            Text(
                text = it,
                color = colorPrimary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
        }

        comic.alt?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}