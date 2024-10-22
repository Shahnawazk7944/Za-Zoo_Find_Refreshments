package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.za_zoo_find_refreshments.presentation.viewmodels.events.ProductsState

@Composable
fun FilterProductSection(onProductChange: (String) -> Unit, state: ProductsState) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        items(state.productCategories) { product ->
            Box(
                modifier = Modifier
                    .size(120.dp, 50.dp)
                    .clip(RoundedCornerShape(60.dp))
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .clickable {
                        onProductChange.invoke(product)
                    }
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp, 35.dp)
                        .clip(RoundedCornerShape(60.dp))
                        .background(
                            color = if (state.selectedProduct == product) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onPrimary
                            }
                        )
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = product,
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