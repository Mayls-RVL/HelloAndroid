package com.example.composemp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun header(navController: NavController) {
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
                SettingsCard(
                    title = profileSettings.name,
                    onClick = {
                        when (profileSettings.name) {
                            "Personal Information" ->
                                navController.navigate("personal_info") { launchSingleTop = true }
                            "Education" ->
                                navController.navigate("education") { launchSingleTop = true }
                            "Hobbies" ->
                                navController.navigate("hobbies") { launchSingleTop = true }
                            "Time Spent" ->
                                navController.navigate("time_spent") { launchSingleTop = true }
                        }
                    }
                )
            }

            item { title2() }

            items(Ast) { otherSettings ->
                SettingsCard(
                    title = otherSettings.name,
                    onClick = {
                        when (otherSettings.name) {
                            "Terms and Conditions" ->
                                navController.navigate("terms") { launchSingleTop = true }
                            "Privacy Policy" ->
                                navController.navigate("privacy") { launchSingleTop = true }
                            "FAQ and Help" ->
                                navController.navigate("faq") { launchSingleTop = true }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun SettingsCard(
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = null,
                tint = Color.Gray
            )
        }
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
    AssT("FAQ and Help")
)

@Composable
fun UserDeets() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth() // ✅ FIXED
    ) {
        Image(
            painter = painterResource(id = R.drawable.pfp_snip),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(stringResource(id = R.string.full_name))
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.email),
            color = Color(0xFF64B5F6),
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable fun title1() = Text("Profile Settings", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 12.dp))
@Composable fun title2() = Text("Account Details", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp))

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // Home
        composable("home") {
            header(navController)
        }

        // Profile settings
        composable("personal_info") {
            PersonalInformationScreen(navController)
        }
        composable("education") {
            EducationScreen(navController)
        }
        composable("hobbies") {
            HobbiesScreen(navController)
        }
        composable("time_spent") {
            TimeSpentScreen(navController)
        }

        // Account details
        composable("privacy") {
            PrivacyPolicyScreen(navController)
        }
        composable("terms") {
            TermsScreen(navController)
        }
        composable("faq") {
            FAQScreen(navController)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTemplate(title: String) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(title) }) }
    ) { padding ->
        Text(
            text = "$title Screen",
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInformationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Personal Information") }
            )
        }
    ) { padding ->
        Text(
            text = "Edit your personal information here",
            modifier = Modifier.padding(padding)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Education") }
            )
        }
    ) { padding ->
        Text(
            text = "Edit your personal information here",
            modifier = Modifier.padding(padding)
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HobbiesScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hobbies") }
            )
        }
    ) { padding ->
        Text(
            text = "Edit your personal information here",
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeSpentScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hours Spent") }
            )
        }
    ) { padding ->
        Text(
            text = "Edit your personal information here",
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Terms & Conditions") }
            )
        }
    ) { padding ->
        Text(
            text = "Edit your personal information here",
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy") }
            )
        }
    ) { padding ->
        Text(
            text = "Edit your personal information here",
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FAQ and Help") }
            )
        }
    ) { padding ->
        Text(
            text = "Edit your personal information here",
            modifier = Modifier.padding(padding)
        )
    }
}