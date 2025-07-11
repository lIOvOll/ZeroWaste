package com.example.zerowaste.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zerowaste.ui.theme.Primary
import com.example.zerowaste.ui.theme.White

@Composable
fun HeaderScreen(
    title: String,
    onBackClick: () -> Unit
) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .background(White)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            BackButton(
                onClick = onBackClick
            )

            Spacer(modifier = Modifier.width(40.dp))

            Text(title, style = MaterialTheme.typography.headlineLarge)

        }

        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(2.dp)
        ) {
            drawLine(
                color = Primary,
                start = androidx.compose.ui.geometry.Offset(0f, 0f),
                end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                strokeWidth = size.height
            )
        }


    }
}

