package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.SubcomposeAsyncImage

@Composable
fun CircularImageTiles(imageList: List<String>) {
    Box(
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        imageList.takeLast(4).forEachIndexed { index, imageId ->
            Box(
                modifier = Modifier.scale(1.3f).padding(start = (20 * index).dp, )
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(Color.Transparent).zIndex(4 - index.toFloat())
            ) {
                SubcomposeAsyncImage(
                    alignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize(),
                    model = imageId,
                    contentDescription = "refreshments images",
                    contentScale = ContentScale.Crop,
                    loading = {
                        CircularProgressIndicator(
                            strokeWidth = 1.dp,
                            modifier = Modifier
                                .size(10.dp)
                                .padding(1.dp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                )
            }
        }
    }
}