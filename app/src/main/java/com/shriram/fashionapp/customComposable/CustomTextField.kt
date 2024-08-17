package com.shriram.fashionapp.customComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: (String)? = null,
    label: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,

        placeholder = {
            if (placeholder != null) {
                Text(placeholder, fontSize = 16.sp, color = Color.Gray)
            }
        },
        label = label,
        visualTransformation = visualTransformation,
        singleLine = true,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,

        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            disabledTextColor = Color.Transparent,
            focusedContainerColor = Color(0xFFFFDFE3),
            unfocusedContainerColor = Color(0xFFFFDFE3),
            disabledContainerColor = Color(0xFFFFDFE3),
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            disabledLabelColor = Color.Gray,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(10.dp, RoundedCornerShape(10.dp)) // Shadow and rounded corners
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewCustomInputFields() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {

        CustomTextField(
            value = "",
            onValueChange = {},
            placeholder = "Email"
        )
        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = "",
            onValueChange = {},
            placeholder = "Password",
        )
    }
}
