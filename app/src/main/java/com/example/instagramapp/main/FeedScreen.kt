package com.example.instagramapp.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.instagramapp.IgViewModel

@Composable
fun FeedScreen(navController: NavController, vm : IgViewModel){
    Text(text = "Feed screen")
}