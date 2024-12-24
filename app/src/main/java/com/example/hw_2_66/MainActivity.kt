package com.example.hw_2_66

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    private val favorites = mutableStateListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookApp(favorites)
        }
    }

    @Composable
    fun BookApp(favorites: SnapshotStateList<String>) {
        val navController = rememberNavController()
        Scaffold(bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
            NavHost(navController = navController, startDestination = "book_list", Modifier.padding(innerPadding)) {
                composable("book_list") {
                    BookListScreen(favorites, { bookId ->
                        if (favorites.contains(bookId)) favorites.remove(bookId) else favorites.add(bookId)
                    }, navController)
                }
                composable("book_details/{bookId}") { backStackEntry ->
                    BookDetailsScreen(backStackEntry.arguments?.getString("bookId") ?: "Unknown")
                }
                composable("favorites") {
                    FavoritesScreen(sampleBooks.filter { favorites.contains(it.id) }, navController)
                }
                composable("profile") { ProfileScreen() }
            }
        }
    }

    @Composable
    fun BottomNavigationBar(navController: NavHostController) {
        val items = listOf(Screen.BookList, Screen.Favorites, Screen.Profile)
        BottomNavigation {
            val currentRoute = currentRoute(navController)
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.icon, contentDescription = screen.title) },
                    label = { Text(screen.title) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Composable
    fun BookListScreen(favorites: List<String>, onFavoriteClick: (String) -> Unit, navController: NavHostController) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(sampleBooks) { book ->
                BookItem(book, favorites.contains(book.id), { onFavoriteClick(book.id) }, navController)
            }
        }
    }

    @Composable
    fun BookItem(book: Book, isFavorite: Boolean, onFavoriteClick: () -> Unit, navController: NavHostController) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(book.title, style = MaterialTheme.typography.bodyLarge)
            Text("by ${book.author}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(book.description, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onFavoriteClick) {
                    Icon(imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites")
                }
                Text(if (isFavorite) "Added to Favorites" else "Add to Favorites")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("book_details/${book.id}") }) {
                Text("See Details")
            }
        }
    }

    @Composable
    fun BookDetailsScreen(bookId: String) {
        val book = sampleBooks.find { it.id == bookId } ?: return Column {
            Text("Book not found", style = MaterialTheme.typography.bodyLarge)
        }

        Column(modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
            Text(book.title, style = MaterialTheme.typography.headlineMedium)
            Text("by ${book.author}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Year: ${book.year}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Genre: ${book.genre}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(book.description, style = MaterialTheme.typography.bodySmall)
        }
    }

    @Composable
    fun FavoritesScreen(favoriteBooks: List<Book>, navController: NavHostController) {
        if (favoriteBooks.isEmpty()) {
            Text("No favorites added yet.", modifier = Modifier.padding(16.dp))
        } else {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(favoriteBooks) { book ->
                    BookItem(book, true, {}, navController)
                }
            }
        }
    }

    @Composable
    fun ProfileScreen() {
        val user = User("John Doe", "johndoe@example.com")

        Column(modifier = Modifier.padding(16.dp)) {
            Text("Profile", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Name: ${user.name}", style = MaterialTheme.typography.bodyLarge)
            Text("Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { }) {
                Text("Log Out")
            }
        }
    }

    private fun currentRoute(navController: NavHostController): String? {
        return navController.currentBackStackEntry?.destination?.route
    }
}