package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterProductSection(onProductClick: (String) -> Unit) {

    val items = listOf("Pizza", "Juice", "Coffee")
    var selectedIndex = remember { mutableIntStateOf(0) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        items(items.size) { index ->
            Box(
                modifier = Modifier
                    .size(120.dp, 50.dp)
                    .clip(RoundedCornerShape(60.dp))
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .clickable {
                        selectedIndex.intValue = index
                        onProductClick.invoke(items[index])
                    }
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp, 35.dp)
                        .clip(RoundedCornerShape(60.dp))
                        .background(
                            color = if (selectedIndex.intValue == index) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onPrimary
                            }
                        )
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = items[index],
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFDCF6FF),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }

}