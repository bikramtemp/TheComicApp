package com.bikram.thecomicapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bikram.thecomicapp.ui.theme.colorPrimary

@Composable
fun CustomBottomBar(selectedIndex: MutableState<Int>) {
    val listItems = listOf("Home", "Saved")

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(64.dp)
            .border(width = 1.dp, colorPrimary, shape = RoundedCornerShape(20.dp))
    ) {
        BottomNavigation(backgroundColor = Color.White) {
            listItems.forEachIndexed { index, _ ->
                val isSelected = selectedIndex.value == index
                BottomNavigationItem(
                    icon = {
                        when (index) {
                            0 -> {
                                TabIcons(
                                    Icons.Filled.Home,
                                    isSelected
                                )
                            }
                            1 -> {
                                TabIcons(
                                    Icons.Filled.BookmarkBorder,
                                    isSelected
                                )
                            }
                        }
                    },
                    selected = isSelected,
                    onClick = { selectedIndex.value = index }
                )
            }
        }
    }
}

@Composable
fun TabIcons(imageVector: ImageVector, isTintColor: Boolean) {
    if (isTintColor) {
        Image(
            modifier = Modifier.wrapContentSize(),
            imageVector = imageVector,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            contentDescription = "tab_icon_selected"
        )
    } else {
        Image(
            modifier = Modifier.wrapContentSize(),
            imageVector = imageVector,
            colorFilter = ColorFilter.tint(Color.Gray),
            contentScale = ContentScale.Fit,
            contentDescription = "tab_icon_unselected"
        )
    }
}