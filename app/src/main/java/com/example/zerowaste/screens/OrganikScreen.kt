package com.example.zerowaste.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.zerowaste.R
import com.example.zerowaste.components.Card
import com.example.zerowaste.components.HeaderScreen
import com.example.zerowaste.components.LastContent
import com.example.zerowaste.screens.data.organikParag
import com.example.zerowaste.ui.theme.Primary

@Composable
fun OrganikScreen(navController: NavHostController) {


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        HeaderScreen(
            title = "Organik 🌿",
            onBackClick = {
                navController.navigate("home")
            }
        )

        LazyColumn {
            item {
                Content1()
            }
            item {
                Content2()
            }
            item {
                Content3()
            }

        }

    }


}


@Composable
private fun Content1() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp, start = 10.dp, end = 10.dp)
    ) {
        Text("Apa itu sampah Organik 🤔", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            organikParag,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(12.dp))

        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .fillMaxWidth()
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

@Composable
private fun Content2() {
    val items = listOf(
        Triple(R.drawable.buahdansayursampah, "Sayur dan buah", "Sayur dan buah"),
        Triple(R.drawable.sisamakanan, "Sisa makanan", "Sisa makanan"),
        Triple(R.drawable.cangkangtelur, "Cangkang telur", "Cangkang telur"),
        Triple(R.drawable.daunkering, "Daun kering", "Daun kering")
    )
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 10.dp, end = 10.dp)
    ) {
        Text(
            "Contoh Sampah Organik",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        LazyRow (
            modifier = Modifier.padding(top = 16.dp)
        ) {
            items(items) { (image, label, desc) ->
                Card(
                    image = painterResource(id = image),
                    label = label,
                    contentDescription = desc
                )
                Spacer(modifier = Modifier.width(24.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .fillMaxWidth()
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


@Composable
private fun Content3() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp, start = 10.dp, end = 10.dp)
    ){
        Text("Cara Pengolahannya ", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        LastContent(
            image1 = (painterResource(id = R.drawable.pengomposan)),
            contentDescription1 = "Gambar Pengomoposan 1",
            image2 = (painterResource(id = R.drawable.pengomposan1)),
            contentDescription2 = "Gambar Pengomposan 2",
            title = "Pengomposan (Komposting)",
            paragraph = "Sampah organik seperti sisa makanan dan daun kering diuraikan oleh mikroorganisme hingga menjadi kompos yang bermanfaat sebagai pupuk alami."
        )
        LastContent(
            image1 = (painterResource(id = R.drawable.fermentasipupuk1)),
            contentDescription1 = "Gambar fermentasi pupuk 1",
            image2 = (painterResource(id = R.drawable.fermentasipupuk2)),
            contentDescription2 = "Gambar fermentasi pupuk 2",
            title = "Fermentasi menjadi Pupuk cair",
            paragraph = "Sampah organik difermentasi menggunakan bahan tambahan seperti gula merah untuk menghasilkan pupuk cair organik yang berguna bagi tanaman."
        )
        LastContent(
            image1 = (painterResource(id = R.drawable.pembuatanbiogas1)),
            contentDescription1 = "GambarPembuatan Biogas 1",
            image2 = (painterResource(id = R.drawable.pembuatanbiogas2)),
            contentDescription2 = "Gambar Pembuatan Biogas 2",
            title = "Pembuatan Biogas",
            paragraph = "Sampah organik diolah dalam reaktor biogas untuk menghasilkan gas metana yang dapat dimanfaatkan sebagai sumber energi alternatif."
        )


    }




}



