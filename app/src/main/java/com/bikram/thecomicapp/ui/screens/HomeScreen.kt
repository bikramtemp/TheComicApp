package com.bikram.thecomicapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bikram.thecomicapp.ui.components.CustomAppBar
import com.bikram.thecomicapp.ui.components.CustomBottomBar
import com.bikram.thecomicapp.ui.theme.colorPrimary
import com.bikram.thecomicapp.ui.theme.ghost_white

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val selectedIndex = remember { mutableStateOf(0) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomAppBar()
            },
            content = {
                Surface(modifier = Modifier.fillMaxSize(), color = colorPrimary) {
                    Card(
                        backgroundColor = ghost_white,
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Box(modifier = Modifier.padding(bottom = 100.dp)) {
                            when (selectedIndex.value) {
                                0 -> {
                                    // TODO show comics here
                                }
                                1 -> {
                                    // TODO show saved comics
                                }
                            }
                        }
                    }
                }
            },
            bottomBar = {
                CustomBottomBar(selectedIndex = selectedIndex)
            },
        )
    }
}