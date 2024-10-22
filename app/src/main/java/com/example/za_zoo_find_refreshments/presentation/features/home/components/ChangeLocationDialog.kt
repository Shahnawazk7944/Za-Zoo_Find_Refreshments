package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.za_zoo_find_refreshments.R


@Composable
fun ChangeLocationDialog(
    onLocationChange: (newLocation: String) -> Unit,
    onCancel: (Boolean) -> Unit,
) {
    var location: String by remember { mutableStateOf("") }

    AlertDialog(
        containerColor = MaterialTheme.colorScheme.background,
        onDismissRequest = { },
        title = { Text("Change Location") },
        text = {
            OutlinedInputField(
                value = location,
                onChange = {
                    location = it
                },
                label = "New Location",
                placeholder = {
                    Text(
                        text = "Enter Your New Location",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.edit_location),
                        contentDescription = "Location Icon",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(18.dp)
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                error = if (location.isNotEmpty() && location.length <= 3) "ⓘ Location is too short" else null,
            )
        },

        confirmButton = {
            Button(
                onClick = { onLocationChange.invoke(location) },
                enabled = location.isNotEmpty() && location.length > 3,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Text("Done")
            }
        },
        dismissButton = {
            Button(
                onClick = { onCancel(false) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Text("Cancel")
            }
        }
    )
}



