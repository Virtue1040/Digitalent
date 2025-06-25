package com.rafihidayat.digitalent.navigation

const val KEY_ID_MAHASISWA = "idMahasiswa"

sealed class Screen(val route: String) {
    data object login: Screen("loginScreen")
    data object register: Screen("registerScreen")
    data object main: Screen("mainScreen")
    data object list: Screen("listScreen")
    data object information: Screen("infoScreen")

    data object newData: Screen("formScreen")
    data object editData: Screen("formScreen/{$KEY_ID_MAHASISWA}") {
        fun withId(id: Long) = "formScreen/$id"
    }
    data object detailData: Screen("detailScreen/{$KEY_ID_MAHASISWA}") {
        fun withId(id: Long)  = "detailScreen/$id"
    }
}