package com.bikram.thecomicapp

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.bikram.thecomicapp.ui.screens.ComicsScreen
import org.junit.Rule
import org.junit.Test

class ComicsScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            MaterialTheme() {
                ComicsScreen()
            }
        }

        // for debug, get all nodes
        composeTestRule.onRoot().printToLog("TAG")

        //perform a manual click left on navigation
        //todo assert the UI state on clicking
        composeTestRule.onNodeWithContentDescription("Left").performClick()

        //todo handle test case for browser explanation comic
        composeTestRule.onNodeWithContentDescription("Help").performClick()

        //todo handle test case for share menu comic
        composeTestRule.onNodeWithContentDescription("Share").performClick()
    }
}