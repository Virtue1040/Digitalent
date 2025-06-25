package com.rafihidayat.digitalent.ui.theme

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.rafihidayat.digitalent.ui.theme.normal.DefaultTheme
import com.rafihidayat.digitalent.ui.theme.red.RedTheme

@Composable
fun ThemeController(
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val sensorManager = remember {
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    val lightSensor = remember {
        sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    val getLux = remember { mutableFloatStateOf(100f) }
    val lightThreshold = 10f

    DisposableEffect(Unit) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.let {
                    getLux.floatValue = it.values[0]
                }
            }
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }
        sensorManager.registerListener(listener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    val isDarkTheme = getLux.floatValue < lightThreshold

    if (isDarkTheme) {
        RedTheme {
            content()
        }
    } else {
        DefaultTheme {
            content()
        }
    }
}
