package com.bikram.thecomicapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.bikram.thecomicapp.ui.theme.colorPrimary

@Composable
fun SavedComicsScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize())
    {
        Text(
            text = "View your favorite comics here!",
            textAlign = TextAlign.Center,
            color = colorPrimary
        )
    }
}