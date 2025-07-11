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
import com.example.zerowaste.screens.data.AnorganikParag
import com.example.zerowaste.ui.theme.Primary


@Composable
fun AnorganikSreen(navController: NavHostController) {


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        HeaderScreen(
            title = "Anorganik 🗑️",
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
fun Content1(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp, start = 10.dp, end = 10.dp)
    ){
        Text("Apa itu sampah Anorganik 🤔", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            AnorganikParag,
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
fun Content2(modifier: Modifier = Modifier) {
    val items = listOf(
        Triple(R.drawable.kardusdankertas, "Kertas dan kardus", "Kertas dan kardus"),
        Triple(R.drawable.bahanplastik, "Sampah plastik", "Sampah plastik"),
        Triple(R.drawable.pecahankaca, "Pecahan Kaca", "Pecahan Kaca"),
        Triple(R.drawable.styrofoam, "Styrofoam", "Styrofoam")
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
fun Content3(modifier: Modifier = Modifier) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp, start = 10.dp, end = 10.dp)
    ){
        Text("Cara Pengolahannya ", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        LastContent(
            image1 = (painterResource(id = R.drawable.daurulang1)),
            contentDescription1 = "Gambar Proses Daur Ulang 1",
            image2 = (painterResource(id = R.drawable.daurulang2)),
            contentDescription2 = "Gambar Proses Daur Ulang  2",
            title = "Daur Ulang (Recycle)",
            paragraph = "Sampah seperti plastik, kertas, logam, dan kaca diproses kembali menjadi bahan mentah atau barang baru oleh industri daur ulang."
        )
        LastContent(
            image1 = (painterResource(id = R.drawable.reduce1)),
            contentDescription1 = "Gambar hasil reduce 1",
            image2 = (painterResource(id = R.drawable.reduce2)),
            contentDescription2 = "Gambar hasil reduce 2",
            title = "Pengurangan Penggunaan (Reduce)",
            paragraph = "Mengurangi penggunaan barang-barang sekali pakai untuk menekan jumlah sampah anorganik yang dihasilkan sejak awal, contohnya mengganti kantong plastik dengan tas belanja."
        )
        LastContent(
            image1 = (painterResource(id = R.drawable.reuse1)),
            contentDescription1 = "Gambar Hasil reuse sampah 1",
            image2 = (painterResource(id = R.drawable.reuse2)),
            contentDescription2 = "Gambar Hasil reuse sampah 2",
            title = "Penggunaan Ulang (Reuse)",
            paragraph = "Barang-barang anorganik yang masih layak pakai, seperti botol atau wadah, digunakan kembali untuk fungsi yang sama atau berbeda."
        )
    }
}