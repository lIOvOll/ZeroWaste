package com.example.zerowaste.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zerowaste.R

@Composable
fun LastContent(
    image1: Painter,
    contentDescription1: String,
    image2: Painter,
    contentDescription2: String,
    title: String,
    paragraph: String
) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 24.dp)
    ){
        Text(title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        Text(paragraph, style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box (
                modifier = Modifier
                    .width(154.dp)
                    .height(174.dp)
            ){
                Image(
                    painter = image1,
                    contentDescription = contentDescription1,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(54.dp))

            Box (
                modifier = Modifier
                    .width(154.dp)
                    .height(174.dp)
            ){
                Image(
                    painter = image2,
                    contentDescription = contentDescription2,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }


        }

    }

}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun view(
) {
    LastContent(
        image1 = (painterResource(id = R.drawable.pengomposan)),
        contentDescription1 = "Gambar Pengomoposan 1",
        image2 = (painterResource(id = R.drawable.pengomposan1)),
        contentDescription2 = "Gambar Pengomposan 2",
        title = "Pengomposan (Komposting)",
        paragraph = "Sampah organik seperti sisa makanan dan daun kering diuraikan oleh mikroorganisme hingga menjadi kompos yang bermanfaat sebagai pupuk alami."
    )

}