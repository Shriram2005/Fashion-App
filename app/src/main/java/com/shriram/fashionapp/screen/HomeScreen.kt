package com.shriram.fashionapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shriram.fashionapp.R
import com.shriram.fashionapp.customComposable.CustomTextField


@Composable
fun HomeScreen(navController: NavHostController) {

    val context = LocalContext.current
    var searchProduct by remember { mutableStateOf("") }
    val userName by remember { mutableStateOf("Shriram") }
    val userAddress by remember {
        mutableStateOf("Trimurti Chowk")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White,        // #FFF
                        Color(0xFFFFBEC8), // rgba(255, 190, 200, 0.99)
                        Color(0xFFFFBEC8), // rgba(255, 190, 200, 0.99)
                        Color(0xFFFFDFE3) // rgba(255, 223, 227, 1.00)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 32.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .border(
                            BorderStroke(2.dp, Color.Black),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .clickable {
                            // Go back
                            navController.popBackStack()
                        }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painterResource(id = R.drawable.register_image),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .align(Alignment.CenterVertically),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Hi $userName",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Row() {
                        Icon(
                            Icons.Outlined.LocationOn,
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "Deliver to $userAddress",
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            CustomTextField(
                value = searchProduct,
                onValueChange = { searchProduct = it },
                label = {
                    Text(text = "Search for a product")
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Email",
                        tint = Color.Gray
                    )
                },
            )
//            LazyRow {
//                // chip
//
//            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}

