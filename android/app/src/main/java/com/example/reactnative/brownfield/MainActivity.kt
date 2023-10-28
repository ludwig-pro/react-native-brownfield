package com.example.reactnative.brownfield

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reactnative.brownfield.ui.theme.ReactNativeBrownfieldTheme
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings

class MainActivity : ComponentActivity() {
    companion object {
        const val OVERLAY_PERMISSION_REQ_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE)
            }
        }

        setContent {
            ReactNativeBrownfieldTheme {
                // A surface container using the 'background' color from the theme

                    OnboardingCard()

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    // SYSTEM_ALERT_WINDOW permission not granted
                }
            }
        }
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingCard() {
    Scaffold {
    Box {
        Image(
            painter = painterResource(id = R.drawable.bg2),
            contentDescription = "Background Image",
            modifier= Modifier
                .align(Alignment.Center).fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier =
        Modifier
            .padding(horizontal = 32.dp, vertical = 80.dp)
            .fillMaxSize()) {
            Text(
                text = "Welcome to Southampton FC",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 36.sp,
            )
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.6f))
            Box(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .border(
                        width = 1.dp,
                        color = Color.White.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(27.dp)
                    )
                    .clip(RoundedCornerShape(27.dp)),

            ) {


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(27.dp)
                ) {
                    Text(
                        "Official Saints App",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "Bringing you closer than ever before to Southampton Football Club! ",
                        color = Color.White.copy(0.8f),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.padding(bottom = 27.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(percent = 50),
                        modifier = Modifier.border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(percent = 50)
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White.copy(0.1f),
                            contentColor = Color.White,
                        )
                    ) {
                        Text(
                            "Get Started Now",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 40.dp, vertical = 4.dp),
                        )
                    }
                }

            }
        }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CardPreview() {
    ReactNativeBrownfieldTheme {
        OnboardingCard()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReactNativeBrownfieldTheme {
        Text("hello jetpack compose")
    }
}