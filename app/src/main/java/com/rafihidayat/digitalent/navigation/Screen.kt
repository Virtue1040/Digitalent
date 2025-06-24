package com.rafihidayat.digitalent.navigation

const val KEY_ID_USER = "idUser"

sealed class Screen(val route: String) {
    data object login: Screen("loginScreen")
    data object register: Screen("registerScreen")
    data object main: Screen("mainScreen")
}