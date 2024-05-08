import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@ExperimentalComposeUiApi
@Composable
fun MainPage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Berikut yang anda butuhkan",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Schedule()
        Spacer(modifier = Modifier.weight(1f))
        ChatBox()
    }
}

@Composable
fun Schedule() {
    var tasks by remember { mutableStateOf(listOf("Buah Pisang ", "Keju parut", "Coklat")) }
    Column(modifier = Modifier.fillMaxWidth()) {
        tasks.forEachIndexed { index, task ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = { }
                )
                Text(
                    text = task,
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f),
                    color = Color.DarkGray
                )
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun ChatBox() {
    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(" Tuliskan Plan Kamu") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions(onSend = {
                // Jawaban Ai
                text = ""
                keyboardController?.hide()
            })
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                // Jawaban AI
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tanya")
        }
    }
}