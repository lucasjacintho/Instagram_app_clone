package com.example.instagramapp.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.instagramapp.IgViewModel

@Composable
fun SearchScreen(navController: NavController, vm: IgViewModel){
    Column(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Search screen")
        }

        BottomNavigationMenu(selectedItem = BottomNavigationItem.SEARCH, navController = navController)
    }
}