package com.example.instagramapp.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instagramapp.DestinationScreen
import com.example.instagramapp.R

enum class BottomNavigationItem(val icon: Int, val destination: DestinationScreen) {
    FEED(R.drawable.ic_home, DestinationScreen.FeedScreen),
    SEARCH(R.drawable.ic_search, DestinationScreen.SearchScreen),
    ADDPOST(R.drawable.ic_add_post,DestinationScreen.NewPostScreen),
    POSTS(R.drawable.ic_posts, DestinationScreen.MyPostsScreen)
}


@Composable
fun BottomNavigationMenu(selectedItem: BottomNavigationItem, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 4.dp)
            .background(Color.White)
    ) {
        for ( item in BottomNavigationItem.values()){
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .weight(1f)
                    .clickable {
                        navigateTo(navController, item.destination)
                    },
                colorFilter = if (item == selectedItem) ColorFilter.tint(Color.Black) else ColorFilter.tint(Color.Gray)
            )
        }
    }
}