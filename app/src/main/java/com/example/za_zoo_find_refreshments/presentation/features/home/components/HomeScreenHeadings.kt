package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.za_zoo_find_refreshments.R

@Composable
fun HomeScreenTopBarHeading() {
    Text(
        text = stringResource(R.string.app_name),
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 10.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary,
        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 27.sp,
        lineHeight = 30.sp,
        textAlign = TextAlign.Center
    )
    Text(
        text = stringResource(R.string.headline),
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondary,
        fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
        fontSize = 18.sp,
        lineHeight = 30.sp,
        textAlign = TextAlign.Center
    )
}
@Composable
fun HomeScreenProductsHeading() {
    Text(
        text = stringResource(R.string.product_section_heading),
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp,bottom = 10.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondary,
        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 27.sp,
        lineHeight = 30.sp,
    )
}