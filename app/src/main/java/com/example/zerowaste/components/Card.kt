package com.example.zerowaste.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zerowaste.R
import com.example.zerowaste.ui.theme.Black
import com.example.zerowaste.ui.theme.Primary
import com.example.zerowaste.ui.theme.White

@Composable
fun Card(
    image: Painter,
    label: String,
    contentDescription: String,
) {

    Box (
        modifier = Modifier
            .width(123.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Black,
                shape = RoundedCornerShape(12.dp)
            )
    ){
        Image(
            painter = image,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .align(androidx.compose.ui.Alignment.BottomCenter) // ini yang menempatkan di bawah
                    .background(White)
                    .border(
                        width = 1.dp,
                        color = Black,
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 12.dp,
                            bottomEnd = 12.dp
                        )
                    )
            ) {
                Text(
                    text = label, // gunakan label dari parameter
                    modifier = Modifier.align(Alignment.Center),
                    style = MaterialTheme.typography.labelMedium
                )
            }


    }


}

@Preview
@Composable
private fun view() {

    Card(
        image = (painterResource(id = R.drawable.buahdansayursampah)),
        label = "Sayur dan buah",
        contentDescription = "abbaa"
    )

}