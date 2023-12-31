package com.example.composebasics


import android.os.Bundle
import android.os.Debug.InstructionCount
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composebasics.ui.theme.ComposeBasicsTheme
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        MyApp {
            MyScreenContent()
        }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    ComposeBasicsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
           content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "There")){
    var counterState by remember{
        mutableStateOf(0)
    }
    Column {
        for(name in names){
          Greeting(name = name)
          Divider()
       }
        Counter(
            count = counterState,
            updateCount = { newCount ->
                counterState = newCount
            }
        )
        if(counterState > 5){
            Text(text = "I love to count!")
        }
    }
}

@Composable
fun Counter(count: Int,updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I've been clicked $count times")
    }
}

@Composable
fun Greeting(name: String) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(16.dp)

        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MyScreenContent()
    }
}