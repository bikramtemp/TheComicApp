package com.bikram.thecomicapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.bikram.thecomicapp.ui.theme.colorPrimary
import com.bikram.thecomicapp.ui.theme.ghost_white
import com.bikram.thecomicapp.ui.viewmodel.MainViewModel

@Composable
fun CustomSearchDialog(viewModel: MainViewModel) {
    var comicID by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { viewModel.openCustomDialogState.value = false },
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = ghost_white
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(
                    value = comicID,
                    onValueChange = {
                        comicID = it
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorPrimary
                    ),
                    singleLine = true,
                    modifier = Modifier.padding(top = 8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Comic ID", color = colorPrimary) })

                // Dialog action buttons
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = {
                        viewModel.openCustomDialogState.value = false
                    }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = {
                        viewModel.openCustomDialogState.value = false
                        comicID.toIntOrNull()?.let {
                            viewModel.currentId = it
                            viewModel.getGenericComic(it)
                        }
                    }) {
                        Text(text = "OK", color = colorPrimary)
                    }
                }
            }
        }
    }
}
