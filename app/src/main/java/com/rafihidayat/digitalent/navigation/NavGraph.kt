package com.rafihidayat.digitalent.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rafihidayat.digitalent.model.User
import com.rafihidayat.digitalent.ui.screen.DetailScreen
import com.rafihidayat.digitalent.ui.screen.FormScreen
import com.rafihidayat.digitalent.ui.screen.InfoScreen
import com.rafihidayat.digitalent.ui.screen.ListScreen
import com.rafihidayat.digitalent.ui.screen.LoginScreen
import com.rafihidayat.digitalent.ui.screen.MainScreen
import com.rafihidayat.digitalent.ui.screen.RegisterScreen
import com.rafihidayat.digitalent.util.UserDataStore

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    val context = LocalContext.current

    val userDataStore = UserDataStore(context)
    val userData by userDataStore.userFlow.collectAsState(User())

    var startDestination = Screen.login.route

    if (userData.id > 0L) {
        startDestination = Screen.main.route
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
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
        composable(route = Screen.list.route) {
            ListScreen(navController)
        }
        composable(route = Screen.information.route) {
            InfoScreen(navController)
        }

        composable(route = Screen.newData.route) {
            FormScreen(navController)
        }
        composable(
            route = Screen.editData.route,
            arguments = listOf(navArgument(KEY_ID_MAHASISWA) {
                type = NavType.LongType
            })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_MAHASISWA)
            FormScreen(navController, id)
        }

        composable(
            route = Screen.detailData.route,
            arguments = listOf(navArgument(KEY_ID_MAHASISWA) {
                type = NavType.LongType
            })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments!!.getLong(KEY_ID_MAHASISWA)
            DetailScreen(navController, id)
        }
    }
}