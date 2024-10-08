package com.shriram.fashionapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shriram.fashionapp.R
import com.shriram.fashionapp.customComposable.CustomShapeImage_T
import com.shriram.fashionapp.customComposable.CustomTextField
import com.shriram.fashionapp.navigation.Screen


@Composable
fun LoginScreen(navController: NavHostController) {

    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    val context = LocalContext.current

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
                .padding(32.dp, 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier
                        .border(
                            BorderStroke(2.dp, Color.Black),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .clickable {
                            // Go back
                            navController.navigate(Screen.GetStarted.route)
                        }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "WELCOME BACK!",
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Let's help you find your style!",
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Custom image shape
            CustomShapeImage_T(painter = painterResource(id = R.drawable.login_image))

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = userEmail,
                onValueChange = { userEmail = it },
                label = {
                    Text(text = "Email")
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color.Gray
                    )
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = userPassword,
                onValueChange = { userPassword = it },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = "Password",
                        tint = Color.Gray
                    )
                }
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Forget Password?",
                color = Color.Black,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFDFE3)
                ),
                elevation = ButtonDefaults.buttonElevation(10.dp),
                onClick = {
                    // Login Button Clicked , Go to home page on login
                    navController.navigate(Screen.Home.route)
                }
            ) {
                Text(text = "Login", color = Color.Black)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}

