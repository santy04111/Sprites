package com.example.sprites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sprites.ui.theme.SpritesTheme


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.sp
import kotlinx.coroutines.isActive



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                SpriteAnimationWithTwoSets()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SpriteAnimationWithTwoSets() {
    // Primer conjunto de sprites
    val firstSetFrames = listOf(
        R.drawable.cuphead_run_0001,
        R.drawable.cuphead_run_0002,
        R.drawable.cuphead_run_0003,
        R.drawable.cuphead_run_0004,
        R.drawable.cuphead_run_0005,
        R.drawable.cuphead_run_0006,
        R.drawable.cuphead_run_0007,
        R.drawable.cuphead_run_0008,
        R.drawable.cuphead_run_0009,
        R.drawable.cuphead_run_0010,
        R.drawable.cuphead_run_0011,
        R.drawable.cuphead_run_0012,
        R.drawable.cuphead_run_0013,
        R.drawable.cuphead_run_0014,
        R.drawable.cuphead_run_0015,
        R.drawable.cuphead_run_0016,
        R.drawable.cuphead_run_0017,
        R.drawable.cuphead_run_0018
    )

    // Segundo conjunto de sprites
    val secondSetFrames = listOf(
        R.drawable.cuphead_ghost_0001,
        R.drawable.cuphead_ghost_0002,
        R.drawable.cuphead_ghost_0003,
        R.drawable.cuphead_ghost_0004,
        R.drawable.cuphead_ghost_0005,
        R.drawable.cuphead_ghost_0006,
        R.drawable.cuphead_ghost_0007,
        R.drawable.cuphead_ghost_0008,
        R.drawable.cuphead_ghost_0009,
        R.drawable.cuphead_ghost_0010,
        R.drawable.cuphead_ghost_0011,
        R.drawable.cuphead_ghost_0012,
        R.drawable.cuphead_ghost_0013,
        R.drawable.cuphead_ghost_0014,
        R.drawable.cuphead_ghost_0015,
        R.drawable.cuphead_ghost_0016,
        R.drawable.cuphead_ghost_0017,
        R.drawable.cuphead_ghost_0018,
        R.drawable.cuphead_ghost_0019,
        R.drawable.cuphead_ghost_0020,
        R.drawable.cuphead_ghost_0021,
        R.drawable.cuphead_ghost_0022,
        R.drawable.cuphead_ghost_0023,
        R.drawable.cuphead_ghost_0024




    )

    // Estado para mantener el frame actual de cada conjunto
    var firstSetCurrentFrame by remember { mutableStateOf(0) }
    var secondSetCurrentFrame by remember { mutableStateOf(0) }

    // Estado para controlar si los botones están presionados
    var firstSetIsPressed by remember { mutableStateOf(false) }
    var secondSetIsPressed by remember { mutableStateOf(false) }

    // Imagen actual del primer conjunto de sprites
    val firstSetCurrentImage: Painter = painterResource(firstSetFrames[firstSetCurrentFrame])

    // Imagen actual del segundo conjunto de sprites
    val secondSetCurrentImage: Painter = painterResource(secondSetFrames[secondSetCurrentFrame])

    // Corrutinas para cambiar los frames mientras los botones están presionados
    LaunchedEffect(firstSetIsPressed) {
        if (firstSetIsPressed) {
            while (isActive) {
                delay(100)
                firstSetCurrentFrame = (firstSetCurrentFrame + 1) % firstSetFrames.size
            }
        }
    }

    LaunchedEffect(secondSetIsPressed) {
        if (secondSetIsPressed) {
            while (isActive) {
                delay(100)
                secondSetCurrentFrame = (secondSetCurrentFrame + 1) % secondSetFrames.size
            }
        }
    }

    // Diseño de la interfaz con dos conjuntos de sprites y sus botones correspondientes
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Primer conjunto de sprites
        Text(
            text = "Primer Conjunto de Sprites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = firstSetCurrentImage,
            contentDescription = "Primer Conjunto de Sprites",
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { /* No necesita acción aquí */ },
            modifier = Modifier
                .pointerInteropFilter {
                    when (it.action) {
                        android.view.MotionEvent.ACTION_DOWN -> {
                            firstSetIsPressed = true
                        }
                        android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                            firstSetIsPressed = false
                        }
                    }
                    true
                }
        ) {
            Text(text = "Mantén Presionado (Set 1)")
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Segundo conjunto de sprites
        Text(
            text = "Segundo Conjunto de Sprites",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = secondSetCurrentImage,
            contentDescription = "Segundo Conjunto de Sprites",
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { /* No necesita acción aquí */ },
            modifier = Modifier
                .pointerInteropFilter {
                    when (it.action) {
                        android.view.MotionEvent.ACTION_DOWN -> {
                            secondSetIsPressed = true
                        }
                        android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                            secondSetIsPressed = false
                        }
                    }
                    true
                }
        ) {
            Text(text = "Mantén Presionado (Set 2)")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        SpriteAnimationWithTwoSets()
    }
}
