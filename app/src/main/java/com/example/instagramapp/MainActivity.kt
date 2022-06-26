package com.example.instagramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagramapp.auth.LoginScreen
import com.example.instagramapp.auth.SignupScreen
import com.example.instagramapp.main.FeedScreen
import com.example.instagramapp.main.MyPostsScreen
import com.example.instagramapp.main.NotificationMessage
import com.example.instagramapp.main.SearchScreen
import com.example.instagramapp.ui.theme.InstagramAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InstagramApp()
                }
            }
        }
    }
}

sealed class DestinationScreen(val route: String) {
    object Signup : DestinationScreen("signup")
    object Login : DestinationScreen("login")
    object FeedScreen : DestinationScreen("feed")
    object SearchScreen : DestinationScreen("search")
    object MyPostsScreen : DestinationScreen("myposts")
}

@Composable
fun InstagramApp() {
    val vm = hiltViewModel<IgViewModel>()
    val navController = rememberNavController()

    NotificationMessage(vm = vm)

    NavHost(navController = navController, startDestination = DestinationScreen.Signup.route) {
        composable(DestinationScreen.Signup.route) {
            SignupScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Login.route) {
            LoginScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.FeedScreen.route) {
            FeedScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.SearchScreen.route) {
            SearchScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.MyPostsScreen.route) {
            MyPostsScreen(navController = navController, vm = vm)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstagramAppTheme {
        InstagramApp()
    }
}