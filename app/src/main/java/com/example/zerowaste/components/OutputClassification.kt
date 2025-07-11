package com.example.zerowaste.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zerowaste.R
import com.example.zerowaste.ui.theme.Primary
import com.example.zerowaste.ui.theme.White

@Composable
fun OutputClassification(
    image: Painter,
    contentDescription: String,
    onNextClick: () -> Unit,
    onCancelClick: () -> Unit,
    classification: String,
    modifier: Modifier = Modifier
) {
    Column (
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Hasil Klasifikasi", style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
        Box (
            modifier = Modifier
                .width(114.dp)
                .height(140.dp),
        ){
            Image(
                painter = image,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text("Apakah anda ingin tahu info lebih lanjut tentang sampah $classification ?",
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            )
        Row (
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ){
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .height(38.dp)
                    .width(100.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = White
                )
            ) {
                Text("Ya", style = MaterialTheme.typography.labelLarge)
            }

            Button(
                onClick = onCancelClick,
                modifier = Modifier
                    .height(38.dp)
                    .width(100.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = White
                )
            ) {
                Text("Tidak", style = MaterialTheme.typography.labelLarge)
            }
        }


    }

}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun view() {

    OutputClassification(
        image = (painterResource(id = R.drawable.organik)),
        contentDescription = "Image Organik",
        onNextClick = {},
        onCancelClick = {},
        classification = "organik"
    )

}