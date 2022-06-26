package com.example.instagramapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.instagramapp.IgViewModel

@Composable
fun MyPostsScreen(navController: NavController, vm : IgViewModel){
    Column(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "My Posts screen")
        }

        BottomNavigationMenu(selectedItem = BottomNavigationItem.POSTS, navController = navController)
    }
}