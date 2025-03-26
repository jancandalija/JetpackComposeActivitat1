package cat.jan.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    MaterialTheme (
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF24292e))
                .padding(start = 30.dp, end = 30.dp)
        ) { padding ->
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF24292e))
            ) {
                item {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        painter = painterResource(id = R.drawable.institut_rafael_campalans),
                        contentDescription = "Imatge del curriculum"
                    )

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