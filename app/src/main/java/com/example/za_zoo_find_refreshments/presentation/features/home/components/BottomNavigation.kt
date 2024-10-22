package com.example.za_zoo_find_refreshments.presentation.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.za_zoo_find_refreshments.R

@Composable
fun NavigationBar(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.rectangle_1),
            contentDescription = "Bottom bar background Image"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(
                        text = "18",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
                Spacer(Modifier.width(10.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = "Cart",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Items",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }

            CircularImageTiles(
                imageList = listOf(
                    "https://s3-media0.fl.yelpcdn.com/bphoto/CshEeBdbMraPh2GBj-0mZg/ls.jpg",
                    "https://s3-media0.fl.yelpcdn.com/bphoto/CshEeBdbMraPh2GBj-0mZg/ls.jpg",
                    "https://s3-media0.fl.yelpcdn.com/bphoto/CshEeBdbMraPh2GBj-0mZg/ls.jpg",
                    "https://s3-media0.fl.yelpcdn.com/bphoto/CshEeBdbMraPh2GBj-0mZg/ls.jpg",
                    "https://s3-media0.fl.yelpcdn.com/bphoto/CshEeBdbMraPh2GBj-0mZg/ls.jpg"
                )
            )
        }

    }
}