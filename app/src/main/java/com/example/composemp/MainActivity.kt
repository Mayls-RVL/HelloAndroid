package com.example.composemp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composemp.ui.theme.ComposeMPTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            header()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Welcome, $name!")
}

@Composable
fun GreetingContainer() {
    Greeting(name = "User")
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun header() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mini Profile") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            item { UserDeets() }
            item { title1() }

            items(AcS) { profileSettings ->
                SettingsCard(title = profileSettings.name)
            }
            item { title2() }
            items(Ast) { otherSettings ->
                SettingsCard(title = otherSettings.name)
            }
        }
    }
}





@Composable
fun Pfp() {
    Image(
        painter = painterResource(id = R.drawable.pfp_snip),
        contentDescription = "Profile picture"
    )
}

@Composable
fun Fname() {
    Text(text = stringResource(id = R.string.full_name))
}

@Composable
fun hlink() {
    Text(
        text = stringResource(id = R.string.email),
        color = Color(0xFF64B5F6),
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable {
            // handle click here
        }
    )
}


@Composable
fun title1() {
    Text(
        text = "Profile Settings",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 20.dp)
    )
}
@Composable
fun title2(){
    Text(
        text = "Account Details",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 20.dp)
    )
}


@Composable
fun SettingsCard(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp
        )
    }
}



data class AccSet(val name: String)

data class AssT(val name: String)

val AcS = listOf(
    AccSet("Personal Information"),
    AccSet("Education"),
    AccSet("Hobbies"),
    AccSet("Time Spent")
)

val Ast = listOf(
    AssT("Terms and Conditions"),
    AssT("Privacy Policy"),
    AssT("FAQ and Help"),
    AssT("Contact us")
)


@Composable
fun UserDeets() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Pfp()
        Spacer(modifier = Modifier.height(8.dp))
        Fname()
        Spacer(modifier = Modifier.height(4.dp))
        hlink()
    }
}

