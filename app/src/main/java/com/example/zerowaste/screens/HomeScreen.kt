package com.example.zerowaste.screens

import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.zerowaste.R
import com.example.zerowaste.components.OutputClassification
import com.example.zerowaste.ui.theme.Grey
import com.example.zerowaste.ui.theme.Primary
import com.example.zerowaste.ui.theme.White
import com.example.zerowaste.utils.classifyImage
import java.io.File

@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var classificationResult by remember { mutableStateOf<String?>(null) }
    var latestPhotoFile by remember { mutableStateOf<File?>(null) }
    var latestCameraUri by remember { mutableStateOf<Uri?>(null) }


    // Launcher galeri
    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        uri?.let {
            imageUri = it
        }
    }

    // Launcher kamera
    val cameraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            imageUri = latestCameraUri
        }
    }


    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        item {
            Box (
                modifier = Modifier
                    .height(100.dp),
            ){
                Image(
                    painter = painterResource(id = R.drawable.zerowaste_no_bg),
                    contentDescription = "Logo zerowaste",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(300.dp)
                )
            }
        }

        // Image View
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Grey)
                    .border(
                        width = 3.dp,
                        color = Primary,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (imageUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = "Selected image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Text("Belum ada gambar",
                        style = MaterialTheme.typography.bodyLarge,
                        color = White,
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(12.dp))
        }

        // Button Kamera dan Galeri
        item {
            Row (
            ) {
                Button(
                    onClick = {
                        val newPhotoFile = File.createTempFile("temp_image", ".jpg", context.cacheDir).apply {
                            deleteOnExit()
                        }
                        val newCameraUri = FileProvider.getUriForFile(
                            context,
                            "${context.packageName}.provider",
                            newPhotoFile
                        )

                        latestPhotoFile = newPhotoFile
                        latestCameraUri = newCameraUri

                        cameraLauncher.launch(newCameraUri)
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .width(100.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(12.dp),
                        ),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary,
                        contentColor = White
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_photo_camera_24),
                        contentDescription = "Camera",
                        modifier = Modifier.size(25.dp)
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                Button(
                    onClick = {
                        galleryLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .width(100.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(12.dp),
                        ),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary,
                        contentColor = White
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_photo_24),
                        contentDescription = "pilih foto di galeri",
                        modifier = Modifier.size(25.dp)

                    )
                }

            }

        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
        }

        // Button Klasifikasi
        item {
            // Clasification Button
            Button(
                onClick = {
                    imageUri?.let {
                        val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                        classificationResult = classifyImage(context, bitmap)
                    }
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(300.dp)
                    .shadow(
                        elevation = 12.dp,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
                    contentColor = White
                )
            ) {
                Text("Classification", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Ouput Klasifikasi
        item {

            classificationResult?.let { result ->
                if (result == "Organik") {
                    OutputClassification(
                        image = (painterResource(id = R.drawable.organik)),
                        contentDescription = "Image Organik",
                        onNextClick = {
                            navController.navigate("OrganikInfo")

                        },
                        onCancelClick = {
                            classificationResult = null
                            imageUri = null
                        },
                        classification = "organik"
                    )
                } else if (result == "Anorganik") {
                    OutputClassification(
                        image = (painterResource(id = R.drawable.anorganik)),
                        contentDescription = "Image Anorganik",
                        onNextClick = {
                            navController.navigate("AnorganikInfo")
                        },
                        onCancelClick = {
                            classificationResult = null
                            imageUri = null
                        },
                        classification = "anorganik"
                    )
                }
            }
        }

    }

}

