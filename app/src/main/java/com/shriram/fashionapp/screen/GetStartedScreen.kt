package com.shriram.fashionapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shriram.fashionapp.R
import com.shriram.fashionapp.navigation.Screen


@Composable
fun GetStartedScreen(navController: NavHostController) {
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
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(42.dp, 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "WELCOME",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Follow latest trends in fashion!",
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.get_started_image),
                contentDescription ="",
                modifier = Modifier
                    .fillMaxWidth(),
//                    .sizeIn(
//                        maxWidth = 300.dp
//                    ),
                contentScale = ContentScale.FillWidth,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "FIND YOUR\nFASHION STYLE",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFDFE3)
                ),
                elevation = ButtonDefaults.buttonElevation(10.dp),
                onClick = {
                    // Go to Login screen
                    navController.navigate(Screen.Login.route)
                }
            ) {
                Text(text = "Get Started", color = Color.Black)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFDFE3)
                ),
                elevation = ButtonDefaults.buttonElevation(10.dp),
                onClick = {
                    // Go to Register page
                    navController.navigate(Screen.Register.route)
             }
            ) {
                Text(text = "Create an Account", color = Color.Black)
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGetStartedScreen() {
    val navController = rememberNavController()
    GetStartedScreen(navController = navController)
}
