package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.zIndex
import coil.compose.SubcomposeAsyncImage
import com.example.za_zoo_find_refreshments.R
import com.example.za_zoo_find_refreshments.domain.model.DetailResult
import com.example.za_zoo_find_refreshments.presentation.viewmodels.events.ProductsState
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RefreshmentsPager(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    state: ProductsState,
    addToCart: (DetailResult) -> Unit,
    addImageToCart: (String) -> Unit,
) {
    HorizontalPager(
        state = pagerState,
        pageSpacing = (-20).dp,
        contentPadding = PaddingValues(start = 54.dp, end = 54.dp, top = 30.dp),
        modifier = modifier
    ) { page ->
        val randomDollarAmount = remember { (10..99).random() }
        Box(
            Modifier
                .graphicsLayer {
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue
                    if (page != pagerState.currentPage) {
                        val rotationAngle = if (page < pagerState.currentPage) {
                            lerp(
                                start = -10f,
                                stop = 0f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        } else {
                            lerp(
                                start = 10f,
                                stop = 0f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                        rotationZ = rotationAngle
                    }
                    val scale = lerp(
                        start = 0.70f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                    scaleX = scale
                    scaleY = scale

                }
                .zIndex(if (page == pagerState.currentPage) 1f else 0f)
                .size(300.dp, 440.dp)
                .blur(
                    radius = if (page == pagerState.currentPage) 0.dp else 5.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(38.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .padding(all = 20.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .size(285.dp, 243.dp)
                        .background(Color.Transparent)
                ) {
                    SubcomposeAsyncImage(
                        alignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(),
                        model = state.products[page].scrollablePhotos.first().src,
                        contentDescription = "refreshments images",
                        contentScale = ContentScale.Crop,
                        loading = {
                            CircularProgressIndicator(
                                strokeWidth = 4.dp,
                                modifier = Modifier
                                    .size(60.dp)
                                    .padding(10.dp),
                                color = MaterialTheme.colorScheme.primary
                            )
                        },
                    )
                }
                Text(
                    state.products[page].name,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                ReviewsAndRatingsRow(
                    reviews = state.products[page].reviewCount,
                    ratings = state.products[page].rating.toFloat()
                )
                Button(
                    onClick = {
                        addToCart.invoke(state.products[page])
                        addImageToCart.invoke(state.products[page].scrollablePhotos.first().src)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bag),
                            contentDescription = "Cart Image"
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = "Add to Cart",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.size(35.dp))
                        Text(
                            text = "$$randomDollarAmount.00",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}