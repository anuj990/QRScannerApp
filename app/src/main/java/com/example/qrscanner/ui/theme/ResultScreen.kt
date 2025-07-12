package com.example.qrscanner.ui.theme

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(qrData: String?) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Scanned QR Result", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))

        qrData?.let { data ->
            Text(
                text = data,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp,
                textDecoration = TextDecoration.None,
                modifier = Modifier
                    .clickable {
                        openInChrome(context, data)
                    }
                    .padding(8.dp)
            )
        } ?: Text("No data found")
    }
}

fun openInChrome(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            // Force open with Chrome if available
            setPackage("com.android.chrome")
        }
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // Fallback if Chrome isn't installed
        val fallbackIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(fallbackIntent)
    } catch (e: Exception) {
        Log.e("OPEN_URL", "Failed to open URL: $url", e)
    }
}
