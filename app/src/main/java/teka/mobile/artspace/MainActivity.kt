package teka.mobile.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import teka.mobile.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier){
    var counterNum by remember {
        mutableStateOf(0)
    }
    val imageResource = when(counterNum){
        0 -> R.drawable.female1
        1 -> R.drawable.male1
        2 -> R.drawable.male2
        3 -> R.drawable.male3
        4 -> R.drawable.male4
        5 -> R.drawable.female2
        6 -> R.drawable.female3
        else -> R.drawable.female4
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = imageResource), contentDescription = "", modifier.padding(32.dp))
        Spacer(modifier = modifier.height(16.dp))
        Text(text = counterNum.toString())
        Spacer(modifier = modifier.width(16.dp))
        Text(text = "Sarufi 001")
        Text(text = "2020")
        modifier.height(16.dp)
        
        //buttons for navigating
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = { counterNum = counterRegulator(false, currentCounter = counterNum) }, modifier.width(120.dp)) {
                Text(stringResource(id = R.string.previous_btn))
            }
            Spacer(modifier = modifier.width(16.dp))
            Button(onClick = { counterNum = counterRegulator(true, currentCounter = counterNum) }, modifier.width(120.dp)) {
                Text(stringResource(id = R.string.next_btn))
            }
        }
    }
}

fun counterRegulator(next: Boolean, currentCounter: Int): Int{
    var update = currentCounter
     if(next && update <= 7){
         update++
     }else if(!next && update >= 0){
        update--
     }
    return update
}