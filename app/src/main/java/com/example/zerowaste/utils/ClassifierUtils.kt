package com.example.zerowaste.utils

import android.content.Context
import android.graphics.Bitmap
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

fun classifyImage(context: Context, bitmap: Bitmap): String {
    val resized = Bitmap.createScaledBitmap(bitmap, 128, 128, true)
    val byteBuffer = ByteBuffer.allocateDirect(4 * 128 * 128 * 3).apply {
        order(ByteOrder.nativeOrder())
    }

    val pixels = IntArray(128 * 128)
    resized.getPixels(pixels, 0, 128, 0, 0, 128, 128)
    for (pixel in pixels) {
        val r = (pixel shr 16 and 0xFF) / 255.0f
        val g = (pixel shr 8 and 0xFF) / 255.0f
        val b = (pixel and 0xFF) / 255.0f
        byteBuffer.putFloat(r)
        byteBuffer.putFloat(g)
        byteBuffer.putFloat(b)
    }

    val model = Interpreter(loadModelFile(context, "model_sampah.tflite"))
    val output = Array(1) { FloatArray(2) } // 2 kelas

    model.run(byteBuffer, output)
    model.close()

    val maxIndex = output[0].indices.maxByOrNull { output[0][it] } ?: -1
    return if (maxIndex == 0) "Anorganik" else "Organik"
}

fun loadModelFile(context: Context, modelFile: String): MappedByteBuffer {
    val fileDescriptor = context.assets.openFd(modelFile)
    val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
    val fileChannel = inputStream.channel
    val startOffset = fileDescriptor.startOffset
    val declaredLength = fileDescriptor.declaredLength
    return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
}