package com.example.za_zoo_find_refreshments.presentation.features.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.za_zoo_find_refreshments.ui.theme.ZaZoo_Find_RefreshmentsTheme
import com.example.za_zoo_find_refreshments.ui.theme.spacing

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "")
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value
    // background(color = Color.LightGray.copy(alpha = alpha))
    background(color = MaterialTheme.colorScheme.tertiary.copy(alpha = alpha))
}


@Composable
fun ZaZooShimmerEffect() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
                    .shimmerEffect()
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spacing.extraLarge)
                            .size(60.dp)
                            .clip(CircleShape)
                            .shimmerEffect()
                    )
                    Spacer(Modifier.width(10.dp))

                    Column {
                        Box(
                            modifier = Modifier
                                .height(20.dp)
                                .width(70.dp)
                                .clip(MaterialTheme.shapes.small)
                                .shimmerEffect()
                        )
                        Spacer(Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .height(16.dp)
                                .width(50.dp)
                                .clip(MaterialTheme.shapes.small)
                                .shimmerEffect()
                        )
                    }
                }
            }
        }) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(top = 30.dp).padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .width(250.dp)
                        .clip(MaterialTheme.shapes.small)
                        .shimmerEffect()
                )
                Spacer(Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width(150.dp)
                        .clip(MaterialTheme.shapes.small)
                        .shimmerEffect()
                )
            }
            Spacer(Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp, 45.dp)
                        .clip(RoundedCornerShape(60.dp))
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier
                        .size(120.dp, 45.dp)
                        .clip(RoundedCornerShape(60.dp))
                        .shimmerEffect()

                )
                Box(
                    modifier = Modifier
                        .size(120.dp, 45.dp)
                        .clip(RoundedCornerShape(60.dp))
                        .shimmerEffect()

                )
            }
            Spacer(Modifier.height(35.dp))
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.extraLarge)
                    .clip(MaterialTheme.shapes.small)
                    .shimmerEffect()
            )
            Spacer(Modifier.height(35.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .clip(RoundedCornerShape(38.dp))
                    .shimmerEffect(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .padding(all = 20.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .size(285.dp, 243.dp)
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier
                        .height(32.dp)
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.extraLarge)
                        .clip(MaterialTheme.shapes.small)
                        .shimmerEffect()
                )
                Spacer(Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.extraLarge),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .height(25.dp)
                            .width(100.dp)
                            .clip(MaterialTheme.shapes.small)
                            .shimmerEffect()
                    )
                    Box(
                        modifier = Modifier
                            .height(25.dp)
                            .width(100.dp)
                            .clip(MaterialTheme.shapes.small)
                            .shimmerEffect()
                    )
                }
                Spacer(Modifier.height(35.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = MaterialTheme.spacing.extraLarge)
                        .clip(MaterialTheme.shapes.extraLarge)
                        .shimmerEffect()
                )
                Spacer(Modifier.height(20.dp))

            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerEffectPreview() {
    ZaZoo_Find_RefreshmentsTheme {
        ZaZooShimmerEffect()
    }
}