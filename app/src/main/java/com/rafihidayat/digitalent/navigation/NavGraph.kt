package com.rafihidayat.digitalent.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafihidayat.digitalent.ui.screen.LoginScreen
import com.rafihidayat.digitalent.ui.screen.MainScreen
import com.rafihidayat.digitalent.ui.screen.RegisterScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.login.route
    ) {
        composable(route = Screen.login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.register.route) {
            RegisterScreen(navController)
        }
        composable(route = Screen.main.route) {
            MainScreen(navController)
        }
    }
}