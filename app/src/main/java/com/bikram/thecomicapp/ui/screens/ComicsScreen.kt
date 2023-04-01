package com.bikram.thecomicapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bikram.thecomicapp.ui.viewmodel.MainViewModel

@Preview(showBackground = true)
@Composable
fun ComicsScreen() {
    val viewModel: MainViewModel = viewModel()
    val comic = viewModel.comicState.value

    //TODO show Comic UI
}