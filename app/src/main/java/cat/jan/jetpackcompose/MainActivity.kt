@file:OptIn(ExperimentalMaterial3Api::class)

package cat.jan.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var puntsCSharp by rememberSaveable { mutableStateOf(0) }
    var puntsJava by rememberSaveable { mutableStateOf(0) }
    var puntsKotlin by rememberSaveable { mutableStateOf(0) }

    MaterialTheme (
    ) {
        Scaffold(
            topBar = { topBar() },
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF24292e))
        ) { padding ->
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF24292e))
                    .padding(padding)
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                item {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        painter = painterResource(id = R.drawable.institut_rafael_campalans),
                        contentDescription = "Imatge del curriculum"
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        filaConeixements("C#", puntsCSharp, { puntsCSharp++ }, { puntsCSharp = 0} )
                        filaConeixements("Java", puntsJava, { puntsJava++ }, { puntsJava = 0} )
                        filaConeixements("Kotlin", puntsKotlin, { puntsKotlin++ }, { puntsKotlin = 0} )
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF2b3137),
                            contentColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .padding(bottom = 20.dp)
                            ) {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp,
                                    text = "DADES"
                                )
                            }
                            Row (
                                modifier = Modifier.padding(bottom = 10.dp)
                            ) {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    text = "Nom: "
                                )
                                Text("Jan")
                            }
                            Row (
                                modifier = Modifier.padding(bottom = 10.dp)
                            ) {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    text = "Cognoms: "
                                )
                                Text("Candalija Blesas")
                            }
                            Row (
                                modifier = Modifier.padding(bottom = 10.dp)
                            ) {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    text = "Edat: "
                                )
                                Text("19")
                            }
                            Column (
                                modifier = Modifier.padding(bottom = 10.dp)
                            ) {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    text = "Estudis: "
                                )
                                Column(
                                    modifier = Modifier.padding(start = 15.dp)
                                ) {
                                    Text("Actualment cursant: DAM2")
                                    Text("Grau Superior: DAM")
                                    Text("Grau Mig: SMX")
                                }
                            }
                            Column {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    text = "Experiència laboral: "
                                )
                                Column(
                                    modifier = Modifier.padding(start = 15.dp)
                                ) {
                                    Text("Esolvo (Junior Android Dev)")
                                }
                            }
                        }
                    }

                }


                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF2b3137),
                            contentColor = Color.White
                        )
                    ) {
                        Column (
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .padding(bottom = 20.dp)
                            ) {
                                Text(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp,
                                    text = "PROJECTES"
                                )
                            }

                            Text(
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontWeight = FontWeight.Bold,
                                text = "eCalSync (APP)"
                            )

                            Text(
                                textAlign = TextAlign.Justify,
                                text = "A Esolvo, com a projecte per aprendre Kotlin vaig fer un projecte d'una APP per sincronitzar calendaris, fet amb Kotlin i JetpackCompose. És una llastima però no esta a la PlayStore de moment"
                            )
                        }
                    }
                }





            }
        }
    }
}

@Composable
fun topBar() {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(
            text = "Jan Candalija",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        ) },
        modifier = Modifier.background(Color.Black),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        ),
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_home_24),
                contentDescription = "Inici",
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context, "Funcionaitat en contrucció", Toast.LENGTH_LONG).show()
                    }
                    .padding(start = 20.dp)
                    .background(Color.White)
            )
        }
    )
}

@Composable
fun filaConeixements(llenguatge: String, punts: Int, augmentarPunts: () -> Unit, netejar: () -> Unit) {
    Row (
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            fontSize = 20.sp,
            text = llenguatge,
            color = Color.White,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                fontSize = 20.sp,
                text = punts.toString(),
                color = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(end = 60.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Guarda",
                modifier = Modifier
                    .clickable {
                        augmentarPunts()
                    }
                    .height(45.dp)
                    .width(45.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_clear),
                contentDescription = "Netejar",
                modifier = Modifier
                    .clickable {
                        netejar()
                    }
                    .height(45.dp)
                    .width(45.dp)
            )
        }
    }
}