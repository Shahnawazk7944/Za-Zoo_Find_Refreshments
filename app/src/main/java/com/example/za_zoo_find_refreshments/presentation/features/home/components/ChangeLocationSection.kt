package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.za_zoo_find_refreshments.R

@Composable
fun ChangeLocationSection(openChangeLocationDialog: (isOpen: Boolean) -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Location",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(Modifier.width(2.dp))
        IconButton(onClick = {openChangeLocationDialog.invoke(true)}) {
            Icon(
                painter = painterResource(id = R.drawable.edit_location),
                contentDescription = "Location Edit Button",
                modifier = Modifier.size(20.dp),
                tint = Color(0xFFFE5D00)
            )
        }
    }
}